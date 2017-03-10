package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.DeliveryOptionsBuilder;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

class RouteClassContentConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteClassContentConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final EventBus eb = vertx.eventBus();
        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.post(RouteConstants.EP_CLASS_CONTENT).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_ADD)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_CONTENT).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_FETCH)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_CONTENT_ASSIGN).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_ASSIGN)
                    .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_CONTENT, contentId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
    }
}
