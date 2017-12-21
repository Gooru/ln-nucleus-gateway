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
 * Created by ashish on 28/1/16.
 */
class RouteProfileConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteProfileConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final EventBus eb = vertx.eventBus();
        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.get(RouteConstants.EP_PROFILE_COURSE_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_COURSE_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_COLLECTION_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_COLLECTION_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_ASSESSMENT_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_ASSESSMENT_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_RESOURCE_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_RESOURCE_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_QUESTION_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_QUESTION_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_PROFILE_RUBRIC_LIST).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_RUBRIC_LIST)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_DEMOGRAPHIC_GET).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_DEMOGRAPHICS_GET);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.post(RouteConstants.EP_PROFILE_FOLLOW).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_FOLLOW);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.delete(RouteConstants.EP_PROFILE_UNFOLLOW).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_UNFOLLOW)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_PROFILE_NETWORK_GET).handler(routingContext -> {
            String userId = routingContext.request().getParam(RouteConstants.ID_USER);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_NETWORK_GET)
                    .addHeader(RouteConstants.ID_USER, userId);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_PROFILE_SEARCH).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_SEARCH);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.put(RouteConstants.EP_PROFILE_PREFERENCE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_PREFERENCE_UPDATE);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_PROFILE_PREFERENCE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_PREFERENCE_GET);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.put(RouteConstants.EP_PROFILE_STATE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_STATE_UPDATE);
            eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
    }
}
