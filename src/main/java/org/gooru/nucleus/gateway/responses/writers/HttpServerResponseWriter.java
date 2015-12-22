package org.gooru.nucleus.gateway.responses.writers;

import java.util.Map;

import org.gooru.nucleus.gateway.responses.transformers.ResponseTransformer;
import org.gooru.nucleus.gateway.responses.transformers.ResponseTransformerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

class HttpServerResponseWriter implements ResponseWriter {

  static final Logger LOG = LoggerFactory.getLogger(ResponseWriter.class);
  private final RoutingContext routingContext;
  private final AsyncResult<Message<Object>> message;
  
  public HttpServerResponseWriter(RoutingContext routingContext, AsyncResult<Message<Object>> message) {
    this.routingContext = routingContext;
    this.message = message;
  }
  
  @Override
  public void writeResponse() {
    ResponseTransformer transformer = new ResponseTransformerBuilder().build(message.result());
    final HttpServerResponse response = routingContext.response();
    // First set the status code
    response.setStatusCode(transformer.transformedStatus());
    // Then set the headers
    Map <String, String> headers = transformer.transformedHeaders();
    if (headers != null && !headers.isEmpty()) {            
      for (String headerName : headers.keySet()) {
        response.putHeader(headerName, headers.get(headerName));
      }
    }
    // Then it is turn of the body to be set and ending the response
    final String responseBody = transformer.transformedBody().toString(); 
    if (responseBody != null) {
      response.end(responseBody);
    } else {            
      response.end();
    }
  }
}
