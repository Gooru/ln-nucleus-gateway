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
 * Created by ashish on 6/1/16.
 */
class RouteCourseConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteCourseConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.put(RouteConstants.EP_COURSE_COLLABORATOR_UPDATE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_COLLABORATOR_UPDATE)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_COURSE_CONTENT_REORDER).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_CONTENT_REORDER)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_COURSE_REORDER).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_REORDER);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_COURSE_MOVE_UNIT).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_MOVE_UNIT)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_COURSE_UPDATE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_UPDATE)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_COURSE_DELETE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_DELETE)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_COURSE_GET).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_GET)
                .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.post(RouteConstants.EP_COURSE_CREATE).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_CREATE);
            eb.send(MessagebusEndpoints.MBEP_COURSE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

    }
}
