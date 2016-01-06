package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish on 6/1/16.
 */
public class RouteAssessmentConfigurator implements RouteConfigurator {

  static final Logger LOGGER = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_ASSESSMENT_GET).handler(routingContext -> {});

    router.post(RouteConstants.EP_ASSESSMENT_CREATE).handler(routingContext -> {});

    router.put(RouteConstants.EP_ASSESSMENT_UPDATE).handler(routingContext -> {});

    router.delete(RouteConstants.EP_ASSESSMENT_DELETE).handler(routingContext -> {});

    router.post(RouteConstants.EP_ASSESSMENT_ADD_QUESTION).handler(routingContext -> {});

    router.delete(RouteConstants.EP_ASSESSMENT_REMOVE_QUESTION).handler(routingContext -> {});

    // TODO: Validate the method types
    router.put(RouteConstants.EP_ASSESSMENT_COPY_QUESTION).handler(routingContext -> {});

    // TODO: Validate the method type
    router.put(RouteConstants.EP_ASSESSMENT_QUESTION_REORDER).handler(routingContext -> {});

    // TODO: Validate the method type
    router.put(RouteConstants.EP_ASSESSMENT_COLLABORATORS_UPDATE).handler(routingContext -> {});

    router.get(RouteConstants.EP_ASSESSMENT_COLLABORATORS_GET).handler(routingContext -> {});



  }
}
