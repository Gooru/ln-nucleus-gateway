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
 * @author szgooru
 * Created On: 22-May-2017
 */
public class RouteNotificationConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteNotificationConfigurator.class);
    
    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final EventBus eb = vertx.eventBus();
        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
        
        router.get(RouteConstants.EP_NOTIFICATION_COUNT_GET).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_COUNT_GET);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_NOTIFICATION_GET).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_GET);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_NOTIFICATION_FILTERS_GET).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_FILTERS_GET);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.get(RouteConstants.EP_NOTIFICATION_FILTERS_BLOCKED_USERS_GET).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_BLOCKED_USERS_GET);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.put(RouteConstants.EP_NOTIFICATION_FILTERS_UPDATE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_FILTERS_UPDATE);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
        router.delete(RouteConstants.EP_NOTIFICATION_FILTERS_BLOCKED_USERS_DELETE).handler(routingContext -> {
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_NOTIFICATION_BLOCKED_USERS_DELETE);
            eb.send(MessagebusEndpoints.MBEP_NOTIFICATION, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
        
    }

}
