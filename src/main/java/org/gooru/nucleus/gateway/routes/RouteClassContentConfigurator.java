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

class RouteClassContentConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteClassContentConfigurator.class);
  private static final String CLASS_CONTENT_ID = "classContentId";


  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();
    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.put(RouteConstants.EP_CLASS_CONTENT_USERS_ADD).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String classContentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_USERS_ADD)
          .addHeader(RouteConstants.ID_CLASS, classId).addHeader(CLASS_CONTENT_ID, classContentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_CONTENT_USERS_LIST).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String classContentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_USERS_LIST)
          .addHeader(RouteConstants.ID_CLASS, classId).addHeader(CLASS_CONTENT_ID, classContentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_CONTENT_ENABLE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_ENABLE)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_CONTENT_SCHEDULE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_SCHEDULE)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.delete(RouteConstants.EP_CLASS_CONTENT_DELETE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_DELETE)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_CONTENT_MASTERY_ACCRUAL_UPDATE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_MASTERY_ACCRUAL_UPDATE)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_CLASS_CONTENT_COMPLETION).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_COMPLETION)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.post(RouteConstants.EP_CLASS_CONTENT_CREATE).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_CLASS_CONTENT_ADD)
          .addHeader(RouteConstants.ID_CLASS, classId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_CLASS_CONTENT_LIST_UNSCHEDULED)
        .handler(routingContext -> this.listRoutingContextHandler(routingContext, eb, mbusTimeout,
            MessageConstants.MSG_OP_CLASS_CONTENT_LIST_UNSCHEDULED));

    router.get(RouteConstants.EP_CLASS_CONTENT_LIST_OFFLINE_ACTIVE)
        .handler(routingContext -> this.listRoutingContextHandler(routingContext, eb, mbusTimeout,
            MessageConstants.MSG_OP_CLASS_CONTENT_LIST_OFFLINE_ACTIVE));

    router.get(RouteConstants.EP_CLASS_CONTENT_LIST_OFFLINE_COMPLETED)
        .handler(routingContext -> this.listRoutingContextHandler(routingContext, eb, mbusTimeout,
            MessageConstants.MSG_OP_CLASS_CONTENT_LIST_OFFLINE_COMPLETED));

    router.get(RouteConstants.EP_CLASS_CONTENT_LIST_ONLINE_SCHEDULED)
        .handler(routingContext -> this.listRoutingContextHandler(routingContext, eb, mbusTimeout,
            MessageConstants.MSG_OP_CLASS_CONTENT_LIST_ONLINE_SCHEDULED));

    router.get(RouteConstants.EP_CLASS_CONTENT_LIST_SCHEDULED)
        .handler(routingContext -> this.listRoutingContextHandler(routingContext, eb, mbusTimeout,
            MessageConstants.MSG_OP_CLASS_CONTENT_LIST_SCHEDULED));

    router.put(RouteConstants.EP_CLASS_CONTENT_MEETING_SETUP).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_SETUP_MEETING)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.delete(RouteConstants.EP_CLASS_CONTENT_MEETING_CANCEL).handler(routingContext -> {
      String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
      String contentId = routingContext.request().getParam(RouteConstants.ID_CONTENT);
      DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
          .setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_CLASS_CONTENT_CANCEL_MEETING)
          .addHeader(RouteConstants.ID_CLASS, classId)
          .addHeader(RouteConstants.ID_CONTENT, contentId);
      eb.send(MessagebusEndpoints.MBEP_CLASS,
          new RouteRequestUtility().getBodyForMessage(routingContext), options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

  }

  private void listRoutingContextHandler(RoutingContext routingContext, EventBus eb,
      long mbusTimeout, String msgOp) {
    String classId = routingContext.request().getParam(RouteConstants.ID_CLASS);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, msgOp)
        .addHeader(RouteConstants.ID_CLASS, classId);
    eb.send(MessagebusEndpoints.MBEP_CLASS,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

}
