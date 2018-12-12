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
import org.gooru.nucleus.gateway.routes.utils.DeliveryOptionsBuilder;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RouteCourseMapConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteCourseMapConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();
    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_COURSE_MAP_COURSE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_COURSEMAP_COURSE_GET)
              .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_CONTENT_MAP,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_COURSE_MAP_UNIT).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSEMAP_UNIT_GET)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId);
      eb.send(MessagebusEndpoints.MBEP_CONTENT_MAP,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_COURSE_MAP_LESSON).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_COURSEMAP_LESSON_GET)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_CONTENT_MAP,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });


  }
}
