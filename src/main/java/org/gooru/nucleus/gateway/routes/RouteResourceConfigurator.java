package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RouteResourceConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);


    router.get(RouteConstants.EP_RESOURCE_GET).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RES_GET)
                             .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_RESOURCE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.post(RouteConstants.EP_RESOURCE_CREATE).handler(routingContext -> {
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RES_CREATE);
      eb.send(MessagebusEndpoints.MBEP_RESOURCE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });


    router.put(RouteConstants.EP_RESOURCE_UPDATE).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RES_UPDATE)
                             .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_RESOURCE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
  }


}
