package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
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
 * Created by ashish on 28/1/16.
 */
class RouteCopierConfigurator implements RouteConfigurator {

  private EventBus eb = null;
  private long mbusTimeout;
  private static final Logger LOG = LoggerFactory
      .getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    eb = vertx.eventBus();
    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
    router.post(RouteConstants.EP_RESOURCE_COPY).handler(this::resourceCopy);
    router.post(RouteConstants.EP_QUESTION_COPY).handler(this::questionCopy);
    router.post(RouteConstants.EP_COLLECTION_COPY).handler(this::collectionCopy);
    router.post(RouteConstants.EP_ASSESSMENT_COPY).handler(this::assessmentCopy);
    router.post(RouteConstants.EP_COURSE_COPY).handler(this::courseCopy);
    router.post(RouteConstants.EP_UNIT_COPY).handler(this::unitCopy);
    router.post(RouteConstants.EP_LESSON_COPY).handler(this::lessonCopy);
    router.post(RouteConstants.EP_RUBRIC_COPY).handler(this::rubricCopy);
    router.post(RouteConstants.EP_OFFLINE_ACTIVITIES_COPY).handler(this::offlineActivityCopy);

  }

  private void resourceCopy(RoutingContext routingContext) {
    String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RESOURCE_COPY)
        .addHeader(RouteConstants.ID_RESOURCE, resourceId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void questionCopy(RoutingContext routingContext) {
    String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_QUESTION_COPY)
        .addHeader(RouteConstants.ID_QUESTION, questionId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void collectionCopy(RoutingContext routingContext) {
    String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_COPY)
        .addHeader(RouteConstants.ID_COLLECTION, collectionId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void assessmentCopy(RoutingContext routingContext) {
    String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_ASSESSMENT_COPY)
        .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void courseCopy(RoutingContext routingContext) {
    String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_COPY)
        .addHeader(RouteConstants.ID_COURSE, courseId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void unitCopy(RoutingContext routingContext) {
    String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
    String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_UNIT_COPY)
        .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void lessonCopy(RoutingContext routingContext) {
    String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
    String unitId = routingContext.request().getParam(RouteConstants.ID_UNIT);
    String lessonId = routingContext.request().getParam(RouteConstants.ID_LESSON);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_LESSON_COPY)
        .addHeader(RouteConstants.ID_COURSE, courseId).addHeader(RouteConstants.ID_UNIT, unitId)
        .addHeader(RouteConstants.ID_LESSON, lessonId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }

  private void rubricCopy(RoutingContext routingContext) {
    String rubricId = routingContext.request().getParam(RouteConstants.ID_RUBRIC);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RUBRIC_COPY)
        .addHeader(RouteConstants.ID_RUBRIC, rubricId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }
  
  private void offlineActivityCopy(RoutingContext routingContext) {
    String offlineAcitivityId = routingContext.request().getParam(RouteConstants.ID_OFFLINE_ACTIVITY);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_OA_COPY)
        .addHeader(RouteConstants.ID_OFFLINE_ACTIVITY, offlineAcitivityId);
    eb.send(MessagebusEndpoints.MBEP_COPIER,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
  }
}
