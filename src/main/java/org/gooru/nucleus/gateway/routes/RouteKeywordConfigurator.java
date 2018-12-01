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

public class RouteKeywordConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteKeywordConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    //Get keywords for the particular course.
    router.get(RouteConstants.EP_COURSE_KEYWORD).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      LOGGER.debug("Getting keyword for course");
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COURSE_KEYWORD_GET)
              .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    //Get keywords for the particular resource.
    router.get(RouteConstants.EP_RESOURCE_KEYWORD).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      LOGGER.debug("Getting keyword for resource");
      LOGGER.debug("Routing resource ID : " + resourceId);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_RESOURCE_KEYWORD_GET)
              .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    //Get keywords for the particular collection.
    router.get(RouteConstants.EP_COLLECTION_KEYWORD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      LOGGER.debug("Getting keyword for collection");
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_COLLECTION_KEYWORD_GET)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_RESOURCE_KEYWORD).handler(routingContext -> {
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_RESOURCE_KEYWORD_UPDATE)
              .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_COURSE_KEYWORD).handler(routingContext -> {
      String courseId = routingContext.request().getParam(RouteConstants.ID_COURSE);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_COURSE_KEYWORD_UPDATE)
              .addHeader(RouteConstants.ID_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_COLLECTION_KEYWORD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_COLLECTION_KEYWORD_UPDATE)
              .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.put(RouteConstants.EP_RESOURCE_KEYWORD_BULK_UPDATE).handler(routingContext -> {
      DeliveryOptions options =
          DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
              .setSendTimeout(mbusTimeout * 1000)
              .addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_RESOURCE_KEYWORD_UPDATE)
              .addHeader(MessageConstants.MSG_HEADER_BULK_UPDATE, String.valueOf(Boolean.TRUE));
      eb.send(MessagebusEndpoints.MBEP_KEYWORD,
          new RouteRequestUtility().getBodyForMessage(routingContext),
          options,
          reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

  }

}
