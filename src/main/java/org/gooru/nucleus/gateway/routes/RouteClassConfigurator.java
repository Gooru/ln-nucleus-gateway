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
class RouteClassConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_CLASSES_FOR_COURSE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_LIST_FOR_COURSE)
                             .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_JOIN_INVITE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_INVITE)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_COURSE_ATTACH).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_COURSE_ASSOCIATION)
                                                     .addHeader(RouteConstants.ID_CLASS, classId).addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_MEMBERS_GET).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_MEMBERS_GET)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_JOIN).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_JOIN)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_COLLABORATOR_UPDATE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_COLLABORATORS_UPDATE)
                                                     .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_UPDATE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_UPDATE)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });


    router.delete(RouteConstants.EP_CLASS_DELETE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_DELETE)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_GET).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_GET)
                             .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.post(RouteConstants.EP_CLASS_CREATE).handler(routingContext -> {
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CREATE);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_LIST).handler(routingContext -> {
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_LIST);
      eb.send(MessagebusEndpoints.MBEP_CLASS, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });


  }
}
