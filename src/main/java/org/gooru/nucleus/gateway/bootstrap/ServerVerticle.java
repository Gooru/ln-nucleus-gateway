package org.gooru.nucleus.gateway.bootstrap;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.dropwizard.MetricsService;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish on 4/12/15.
 * Starts the HTTP gateway for nucleus.
 * 
 * This class is the HTTP gateway for nucleus. It starts HTTP server on port specified in configuration file, registers the routes and corresponding 
 * handlers. One interesting thing it does is to have a timer thread which keeps on publishing the metrics snapshot to event bus.
 */
public class ServerVerticle extends AbstractVerticle {

  static final Logger LOG = LoggerFactory.getLogger(ServerVerticle.class);

  @Override
  public void start() throws Exception {

    LOG.info("Starting ServerVerticle...");
    final HttpServer httpServer = vertx.createHttpServer();

    final MetricsService metricsService = MetricsService.create(vertx);
    final Router router = Router.router(vertx);

    initializeRoutes(router, metricsService);
    final int metricsPeriodicity = config().getInteger(ConfigConstants.METRICS_PERIODICITY);
    initializeMetrics(metricsService, metricsPeriodicity);

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

  private void initializeMetrics(MetricsService metricsService, int periodInSeconds) {
    // Send a metrics events as per period defined, once we convert it to milliseconds
    
    vertx.setPeriodic(periodInSeconds*1000, t -> {
      JsonObject metrics = metricsService.getMetricsSnapshot(vertx);
      vertx.eventBus().publish("metrics", metrics);
    });
  }

  private void initializeRoutes(Router router, MetricsService metricsService) {

    EventBus eb = vertx.eventBus();

    intializeInternalRoutes(router, metricsService);
    
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

  private void intializeInternalRoutes(Router router, MetricsService metricsService) {
    router.route("/banner").handler(routingContext -> {
      JsonObject result = new JsonObject().put("Organisation", "gooru.org").put("Product", "nucleus").put("purpose", "api")
        .put("mission", "Honor the human right to education");
      routingContext.response().end(result.toString());
    });
    
    router.route("/metrics").handler(routingContext -> {
      JsonObject ebMetrics = metricsService.getMetricsSnapshot(vertx);
      routingContext.response().end(ebMetrics.toString());
    });
  }


}
