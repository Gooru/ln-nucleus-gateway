package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish on 6/1/16.
 */
public class RouteTaxonomyConfigurator implements RouteConfigurator {

  public static final Logger LOGGER = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    // TODO: Provide implementation
  }
}
