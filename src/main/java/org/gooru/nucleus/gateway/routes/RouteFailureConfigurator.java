package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.HttpConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by ashish on 4/2/16.
 */
class RouteFailureConfigurator implements RouteConfigurator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteFailureConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

        router.put().failureHandler(this::handleFailures);

        router.post().failureHandler(this::handleFailures);
    }

    private void handleFailures(RoutingContext frc) {
        Throwable currentThrowable = frc.failure();
        if (currentThrowable instanceof io.vertx.core.json.DecodeException) {
            LOGGER.error("Caught registered exception", currentThrowable);
            frc.response().setStatusCode(HttpConstants.HttpStatus.BAD_REQUEST.getCode()).end("Invalid Json payload");
        } else {
            LOGGER.error("Caught unregistered exception, will send HTTP.500", currentThrowable);
            frc.response().setStatusCode(HttpConstants.HttpStatus.ERROR.getCode()).end("Internal error");
        }
    }

}
