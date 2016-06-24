package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.dropwizard.MetricsService;
import io.vertx.ext.web.Router;

class RouteInternalConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteInternalConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        router.route(RouteConstants.EP_INTERNAL_BANNER).handler(routingContext -> {
            JsonObject result =
                new JsonObject().put("Organisation", "gooru.org").put("Product", "nucleus").put("purpose", "api")
                    .put("mission", "Honor the human right to education");
            routingContext.response().end(result.toString());
        });

        final MetricsService metricsService = MetricsService.create(vertx);
        router.route(RouteConstants.EP_INTERNAL_METRICS).handler(routingContext -> {
            JsonObject ebMetrics = metricsService.getMetricsSnapshot(vertx);
            routingContext.response().end(ebMetrics.toString());
        });

        final EventBus eb = vertx.eventBus();

        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 5L);

        router.post(RouteConstants.EP_INTERNAL_EVENT).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EVENT_PUBLISH);
            try {
                JsonObject eventData = routingContext.getBodyAsJson();
                if (eventData == null || eventData.isEmpty()) {
                    LOGGER.warn("Invalid event data to be published");
                    routingContext.response().setStatusCode(HttpConstants.HttpStatus.BAD_REQUEST.getCode()).end();
                } else {
                    eb.send(MessagebusEndpoints.MBEP_EVENT, eventData, options);
                    routingContext.response().setStatusCode(HttpConstants.HttpStatus.SUCCESS.getCode()).end();
                }
            } catch (Throwable throwable) {
                LOGGER.warn("Error trying to publish event to publisher", throwable);
                // handled downstream
                throw throwable;
            }
        });

        router.post(RouteConstants.EP_INTERNAL_EVENT_PROCESSOR).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EVENT_PROCESS);
            try {
                JsonObject eventData = routingContext.getBodyAsJson();
                if (eventData == null || eventData.isEmpty()) {
                    LOGGER.warn("Invalid event data to be published");
                    routingContext.response().setStatusCode(HttpConstants.HttpStatus.BAD_REQUEST.getCode()).end();
                } else {
                    eb.send(MessagebusEndpoints.MBEP_EVENT, eventData, options);
                    routingContext.response().setStatusCode(HttpConstants.HttpStatus.SUCCESS.getCode()).end();
                }
            } catch (Throwable throwable) {
                LOGGER.warn("Error trying to publish event to publisher", throwable);
                // handled downstream
                throw throwable;
            }
        });

    }
}
