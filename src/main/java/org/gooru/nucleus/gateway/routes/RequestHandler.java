package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.ext.web.RoutingContext;
import java.util.Map;
import java.util.Map.Entry;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.routes.utils.DeliveryOptionsBuilder;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;

/**
 * @author ashish.
 */

public class RequestHandler implements Handler<RoutingContext> {

  private final String op;
  private final RequestHandlerMessageBusContext context;
  private final PathParamCreator pathParamCreator;

  RequestHandler(String op,
      RequestHandlerMessageBusContext context,
      PathParamCreator pathParamCreator) {
    this.op = op;
    this.context = context;
    this.pathParamCreator = pathParamCreator;
  }


  @Override
  public void handle(RoutingContext routingContext) {
    DeliveryOptions options =
        DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
            .setSendTimeout(context.getMbusTimeout() * 1000)
            .addHeader(MessageConstants.MSG_HEADER_OP, op);
    Map<String, String> headers = pathParamCreator.getHeadersFromPathParams(routingContext, op);
    if (headers != null && !headers.isEmpty()) {
      for (Entry<String, String> entry : headers.entrySet()) {
        options.addHeader(entry.getKey(), entry.getValue());
      }
    }

    context.getEb().send(context.getMessageBusEndpoint(),
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility()
            .responseHandler(routingContext, reply, context.getLOGGER()));

  }

}
