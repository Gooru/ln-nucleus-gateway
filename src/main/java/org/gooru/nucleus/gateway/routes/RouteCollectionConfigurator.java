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
class RouteCollectionConfigurator implements RouteConfigurator {


  private static final Logger LOGGER = LoggerFactory.getLogger(RouteCollectionConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
    router.put(RouteConstants.EP_COLLECTION_CONTENT_REORDER).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_CONTENT_REORDER)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });


    router.put(RouteConstants.EP_COLLECTION_COLLABORATORS_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
        MessageConstants.MSG_OP_COLLECTION_COLLABORATOR_UPDATE).addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.put(RouteConstants.EP_COLLECTION_QUESTION_ADD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_QUESTION_ADD)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.put(RouteConstants.EP_COLLECTION_RESOURCE_ADD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_RESOURCE_ADD)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.put(RouteConstants.EP_COLLECTION_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_UPDATE)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.delete(RouteConstants.EP_COLLECTION_DELETE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_DELETE)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.get(RouteConstants.EP_COLLECTION_GET).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_GET)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.post(RouteConstants.EP_COLLECTION_CREATE).handler(routingContext -> {
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_CREATE);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });


  }

}
