package org.gooru.nucleus.gateway.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class RouteAuthConfigurator implements RouteConfigurator {

  static final Logger LOG = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    // TODO: Currently dummy implementation, need to provide a correct one
    router.route("/*").handler(routingContext -> {
      routingContext.put("authInfo", new JsonObject().put("success", true));
      routingContext.next();
    });


  }

}
