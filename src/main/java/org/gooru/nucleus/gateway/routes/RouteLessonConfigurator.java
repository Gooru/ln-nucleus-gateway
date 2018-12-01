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

/**
 * Created by ashish on 11/1/16.
 */
class RouteLessonConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteLessonConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.put(RouteConstants.EP_LESSON_CONTENT_REORDER).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);

      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_LESSON_CONTENT_REORDER)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_LESSON_MOVE_COLLECTION).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_LESSON_MOVE_COLLECTION)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_LESSON_GET).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_GET)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_LESSON_UPDATE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_UPDATE)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.delete(RouteConstants.EP_LESSON_DELETE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_DELETE)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.delete(RouteConstants.EP_LESSON_REMOVE_COLLECTION).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
      String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_LESSON_REMOVE_COLLECTION)
              .addHeader(RouteConstants.ID_COURSE, courseId)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_LESSON, lessonId)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.post(RouteConstants.EP_LESSON_CREATE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);

      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_CREATE)
              .addHeader(RouteConstants.ID_UNIT, unitId)
              .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_COURSE,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

  }
}
