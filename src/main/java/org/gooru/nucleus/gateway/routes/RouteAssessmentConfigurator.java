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
class RouteAssessmentConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteAssessmentConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.put(RouteConstants.EP_ASSESSMENT_COLLABORATORS_UPDATE).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_COLLABORATOR_UPDATE)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

        router.put(RouteConstants.EP_ASSESSMENT_QUESTION_REORDER).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_QUESTION_REORDER)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

        router.get(RouteConstants.EP_ASSESSMENT_GET).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_GET)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

        router.put(RouteConstants.EP_ASSESSMENT_UPDATE).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_UPDATE)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_ASSESSMENT_DELETE).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_DELETE)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

        router.put(RouteConstants.EP_ASSESSMENT_QUESTION_ADD).handler(routingContext -> {
            String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_QUESTION_ADD)
                .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

        router.post(RouteConstants.EP_ASSESSMENT_CREATE).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_CREATE);
            eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

        });

    }
}
