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
 * Created by ashish on 8/1/16.
 */
class RouteQuestionConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteQuestionConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.delete(RouteConstants.EP_QUESTION_DELETE).handler(routingContext -> {
            String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_DELETE)
                    .addHeader(RouteConstants.ID_QUESTION, questionId);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_QUESTION_GET).handler(routingContext -> {
            String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_GET)
                    .addHeader(RouteConstants.ID_QUESTION, questionId);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_QUESTION_GET_BULK).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_GET_BULK);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_QUESTION_UPDATE).handler(routingContext -> {
            String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_UPDATE)
                    .addHeader(RouteConstants.ID_QUESTION, questionId);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.put(RouteConstants.EP_QUESTION_SCORE_UPDATE).handler(routingContext -> {
            String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_SCORE_UPDATE)
                    .addHeader(RouteConstants.ID_QUESTION, questionId);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.put(RouteConstants.EP_QUESTION_RUBRIC_ASSOCIATE).handler(routingContext -> {
            String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
            String rubricId = routingContext.request().getParam(RouteConstants.ID_RUBRIC );
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_RUBRIC_ASSOCIATE)
                    .addHeader(RouteConstants.ID_RUBRIC, rubricId)
                    .addHeader(RouteConstants.ID_QUESTION, questionId);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.post(RouteConstants.EP_QUESTION_CREATE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_CREATE);
            eb.send(MessagebusEndpoints.MBEP_QUESTION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

    }

}
