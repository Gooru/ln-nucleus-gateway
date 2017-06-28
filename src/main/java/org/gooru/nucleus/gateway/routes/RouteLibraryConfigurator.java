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
 * @author szgooru Created On: 29-May-2017
 */
public class RouteLibraryConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteLibraryConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        final EventBus eb = vertx.eventBus();
        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

        router.get(RouteConstants.EP_LIBRARY_GET).handler(routingContext -> {
            String libraryId = routingContext.request().getParam(RouteConstants.ID_LIBRARY);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LIBRARY_GET)
                    .addHeader(RouteConstants.ID_LIBRARY, libraryId);
            eb.send(MessagebusEndpoints.MBEP_LIBRARY, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_LIBRARIES_GET).handler(routingContext -> {
            LOGGER.debug("getting libraries");
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LIBRARIES_GET);
            eb.send(MessagebusEndpoints.MBEP_LIBRARY, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });

        router.get(RouteConstants.EP_LIBRARY_CONTENTS_GET).handler(routingContext -> {
            String libraryId = routingContext.request().getParam(RouteConstants.ID_LIBRARY);
            DeliveryOptions options =
                DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout * 1000)
                    .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LIBRARY_CONTENTS_GET)
                    .addHeader(RouteConstants.ID_LIBRARY, libraryId);
            eb.send(MessagebusEndpoints.MBEP_LIBRARY, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
        });
    }
}
