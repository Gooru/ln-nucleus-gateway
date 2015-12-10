package org.gooru.nucleus.gateway.bootstrap;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish on 4/12/15.
 */
public class ServerVerticle extends AbstractVerticle {

  static final Logger LOG = LoggerFactory.getLogger(ServerVerticle.class);

  @Override
  public void start() throws Exception {

    LOG.info("Starting ServerVerticle...");
    final HttpServer httpServer = vertx.createHttpServer();

    final Router router = Router.router(vertx);

    initializeRoutes(router);

    // If the port is not present in configuration then we end up
    // throwing as we are casting it to int. This is what we want.
    final int port = config().getInteger(ConfigConstants.HTTP_PORT);
    LOG.info("Http server starting on port {}", port);
    httpServer.requestHandler(router::accept).listen(port, result -> {
      if (result.succeeded()) {
        LOG.info("HTTP Server started successfully");
      } else {
        // Can't do much here, Need to Abort. However, trying to exit may have us blocked on other threads that we may have spawned, so we need to use
        // brute force here
        LOG.error("Not able to start HTTP Server", result.cause());
        Runtime.getRuntime().halt(1);
      }
    });

  }

  private void initializeRoutes(Router router) {

    EventBus eb = vertx.eventBus();

    router.route("/").handler(routingContext -> {
      eb.send(MessagebusEndpoints.MBEP_RESOURCE, "ping!", reply -> {
        if (reply.succeeded()) {
          routingContext.response().end(reply.result().body().toString());
        } else {
          LOG.info("No reply");
        }
      });
    });
  }


}
