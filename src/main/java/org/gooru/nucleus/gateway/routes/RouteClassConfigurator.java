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

/**
 * Created by ashish on 6/1/16.
 */
class RouteClassConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteClassConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.put(RouteConstants.EP_CLASS_STUDENT_SETTING_REROUTE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_MEMBERS_REROUTE_SETTINGS_UPDATE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_SETTING_REROUTE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_REROUTE_SETTINGS_UPDATE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.post(RouteConstants.EP_CLASS_PROFILE_BASELINE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_LPBASELINE_TRIGGER)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASSES_FOR_COURSE).handler(routingContext -> {
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_LIST_FOR_COURSE)
                    .addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_CLASS_INVITE_REMOVE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String email = routingContext.request().getParam(RouteConstants.ID_EMAIL);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_INVITE_REMOVE)
                    .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_EMAIL, email);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_JOIN_INVITE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_INVITE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_COURSE_ATTACH).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_COURSE_ASSOCIATION)
                    .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_CONTENT_PUBLISHED_STATS).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP,
                        MessageConstants.MSG_OP_CLASS_GET_CONTENT_VISIBILITY_STATS)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_CONTENT_PUBLISHED).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_GET_CONTENT_VISIBILITY)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_CONTENT_PUBLISH).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_SET_CONTENT_VISIBILITY)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_MEMBERS_GET).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_MEMBERS_GET)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_CLASS_STUDENT_REMOVE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_REMOVE_STUDENT)
                    .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_JOIN).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_JOIN)
                    .addHeader(RouteConstants.CODE_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_COLLABORATOR_UPDATE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_COLLABORATORS_UPDATE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_CLASS_UPDATE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_UPDATE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.put(RouteConstants.EP_CLASS_ARCHIVE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_ARCHIVE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_CLASS_DELETE).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_DELETE)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_GET).handler(routingContext -> {
            String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_GET)
                    .addHeader(RouteConstants.ID_CLASS, classId);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.post(RouteConstants.EP_CLASS_CREATE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CREATE);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_CLASS_LIST).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_LIST);
            eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

    }
}
