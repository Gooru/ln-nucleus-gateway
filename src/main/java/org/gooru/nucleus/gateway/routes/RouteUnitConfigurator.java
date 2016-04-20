package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by ashish on 11/1/16.
 */
class RouteUnitConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteUnitConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.put(RouteConstants.EP_UNIT_CONTENT_REORDER).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);

            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_CONTENT_REORDER)
                .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_UNIT_MOVE_LESSON).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_MOVE_LESSON)
                .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_UNIT_GET).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_GET)
                .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_UNIT_UPDATE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_UPDATE)
                .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_UNIT_DELETE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_DELETE)
                .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.post(RouteConstants.EP_UNIT_CREATE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);

            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_CREATE)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

    }
}
