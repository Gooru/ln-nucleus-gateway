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

public class RouteWatsonConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteWatsonConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eb = vertx.eventBus();
  
    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
    
    //Get Watson tags for the particular course.
    router.get(RouteConstants.EP_WATSON_COURSE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      LOGGER.info("Getting course");
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_COURSE_GET)
        .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
        options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    //Get Watson tags for the particular resource.
    router.get(RouteConstants.EP_WATSON_RESOURCE).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      LOGGER.info("Getting resource");
      LOGGER.info("Routing resource ID : " + resourceId);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_RESOURCE_GET)
        .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
        options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    //Get Watson tags for the particular collection.
    router.get(RouteConstants.EP_WATSON_COLLECTION).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      LOGGER.info("Getting collection");
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_COLLECTION_GET)
        .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
        options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
    
    router.put(RouteConstants.EP_WATSON_RESOURCE).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_RESOURCE_UPDATE)
          .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
          options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  });
    
    router.put(RouteConstants.EP_WATSON_COURSE).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_COURSE_UPDATE)
          .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
          options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  });
    
    router.put(RouteConstants.EP_WATSON_COLLECTION).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
          .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_WATSON_COLLECTION_UPDATE)
          .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_WATSON, new RouteRequestUtility().getBodyForMessage(routingContext),
          options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  });
    
  }
  
}
