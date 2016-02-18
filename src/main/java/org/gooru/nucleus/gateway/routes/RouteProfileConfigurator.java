package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by ashish on 28/1/16.
 */
class RouteProfileConfigurator implements RouteConfigurator {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(RouteProfileConfigurator.class);
  
  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();
    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
    
    router.get(RouteConstants.EP_PROFILE_COURSE_LIST).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_LIST_COURSES)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.get(RouteConstants.EP_PROFILE_COLLECTION_LIST).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_LIST_COLLECTOIONS)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.get(RouteConstants.EP_PROFILE_ASSESSMENT_LIST).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_LIST_ASSESSMENTS)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.get(RouteConstants.EP_PROFILE_RESOURCE_LIST).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_LIST_RESOURCES)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.get(RouteConstants.EP_PROFILE_QUESTION_LIST).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_LIST_QUESTIONS)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.get(RouteConstants.EP_PROFILE_DEMOGRAPHIC_GET).handler(routingContext -> {
      String userId = routingContext.request().getParam(RouteConstants.ID_USER);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROFILE_GET_DEMOGRAPHICS)
                                                     .addHeader(RouteConstants.ID_USER, userId);
      if(routingContext.request().params().contains(RouteConstants.PARAM_PREVIEW)) {
        options.addHeader(RouteConstants.PARAM_PREVIEW, routingContext.request().getParam(RouteConstants.PARAM_PREVIEW));
      }
      eb.send(MessagebusEndpoints.MBEP_PROFILE, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
  }
}
