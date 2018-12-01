package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.gooru.nucleus.gateway.constants.HttpConstants;
import org.gooru.nucleus.gateway.exceptions.HttpResponseWrapperException;
import org.gooru.nucleus.gateway.responses.transformers.ResponseTransformerBuilder;
import org.gooru.nucleus.gateway.responses.writers.ResponseWriterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish on 4/2/16.
 */
class RouteFailureConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteFailureConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    router.put().failureHandler(this::handleFailures);
    router.post().failureHandler(this::handleFailures);
    router.get().failureHandler(this::handleFailures);
    router.delete().failureHandler(this::handleFailures);
  }

  private void handleFailures(RoutingContext frc) {
    Throwable currentThrowable = frc.failure();
    if (currentThrowable instanceof io.vertx.core.json.DecodeException) {
      LOGGER.error("Caught registered exception", currentThrowable);
      frc.response().setStatusCode(HttpConstants.HttpStatus.BAD_REQUEST.getCode())
          .end("Invalid Json payload");
    } else if (currentThrowable instanceof HttpResponseWrapperException) {
      LOGGER.error("Caught HttpResponseWrapperException", currentThrowable);
      ResponseWriterBuilder.build(frc, ResponseTransformerBuilder
          .buildHttpResponseWrapperExceptionBuild((HttpResponseWrapperException) currentThrowable))
          .writeResponse();
    } else {
      LOGGER.error("Caught unregistered exception, will send HTTP.500", currentThrowable);
      frc.response().setStatusCode(HttpConstants.HttpStatus.ERROR.getCode()).end("Internal error");
    }
  }

}
