package org.gooru.nucleus.gateway.responses.writers;

import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.gooru.nucleus.gateway.constants.HttpConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.responses.transformers.ResponseTransformer;
import org.gooru.nucleus.gateway.responses.transformers.ResponseTransformerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HttpServerResponseWriter implements ResponseWriter {

  private static final Logger LOG = LoggerFactory.getLogger("org.gooru.nucleus.performance.log");

  private final RoutingContext routingContext;
  ResponseTransformer transformer;

  public HttpServerResponseWriter(RoutingContext routingContext,
      AsyncResult<Message<Object>> message) {
    this.routingContext = routingContext;
    transformer = ResponseTransformerBuilder.build(message.result());
  }

  public HttpServerResponseWriter(RoutingContext routingContext, ResponseTransformer transformer) {
    this.routingContext = routingContext;
    this.transformer = transformer;
  }

  @Override
  public void writeResponse() {
    final HttpServerResponse response = routingContext.response();
    // First set the status code
    writeHttpStatus(response);
    // Then set the headers
    writeHttpHeaders(response);
    // Then it is turn of the body to be set and ending the response
    writeHttpBody(response);

    logPerformanceStats();
  }

  private void logPerformanceStats() {
    try {
      long authProcessingTime = (Long) routingContext.get(MessageConstants.MSG_OP_AUTH_TIME);
      long handlerProcessingStart = (Long) routingContext
          .get(MessageConstants.MSG_OP_HANDLER_START);
      long handlerProcessingTime = (System.currentTimeMillis() - handlerProcessingStart);
      String userId = (String) routingContext.get(MessageConstants.MSG_USER_ID);
      LOG.info("Auth Processing Time:{}ms -- Handler Processing Time:{}ms -- UserId:{}",
          authProcessingTime,
          handlerProcessingTime, userId);
    } catch (Throwable t) {
      LOG.error("error while logging request processing time", t.getMessage());
    }
  }

  private void writeHttpBody(HttpServerResponse response) {
    if (transformer.transformedStatus() != HttpConstants.HttpStatus.NO_CONTENT.getCode()) {
      final String responseBody =
          ((transformer.transformedBody() != null) && (!transformer.transformedBody().isEmpty())) ?
              transformer.transformedBody().toString() : null;
      if (responseBody != null) {
        // As of today, we always serve JSON
        response.putHeader(HttpConstants.HEADER_CONTENT_TYPE, HttpConstants.CONTENT_TYPE_JSON);
        response.putHeader(HttpConstants.HEADER_CONTENT_LENGTH,
            Integer.toString(responseBody.getBytes(StandardCharsets.UTF_8).length));
        response.end(responseBody);
      } else {
        response.end();
      }
    } else {
      response.end();
    }
  }

  private void writeHttpHeaders(HttpServerResponse response) {
    Map<String, String> headers = transformer.transformedHeaders();
    if (headers != null && !headers.isEmpty()) {
      // Never accept content-length from others, we do that
      headers.keySet().stream()
          .filter(headerName -> !headerName.equalsIgnoreCase(HttpConstants.HEADER_CONTENT_LENGTH))
          .forEach(headerName -> response.putHeader(headerName, headers.get(headerName)));
    }
  }

  private void writeHttpStatus(HttpServerResponse response) {
    response.setStatusCode(transformer.transformedStatus());
  }
}
