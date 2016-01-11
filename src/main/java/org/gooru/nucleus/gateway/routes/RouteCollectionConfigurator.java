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
public class RouteCollectionConfigurator implements RouteConfigurator {


  static final Logger LOGGER = LoggerFactory.getLogger("org.gooru.nucleus.gateway.bootstrap.ServerVerticle");

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_COLLECTION_GET).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_GET)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.post(RouteConstants.EP_COLLECTION_CREATE).handler(routingContext -> {
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_CREATE);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.put(RouteConstants.EP_COLLECTION_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_UPDATE)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });
    });

    router.delete(RouteConstants.EP_COLLECTION_DELETE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_DELETE)
                             .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.post(RouteConstants.EP_COLLECTION_QUESTION_ADD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_QUESTION_ADD)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.delete(RouteConstants.EP_COLLECTION_QUESTION_REMOVE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_QUESTION_REMOVE)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId)
                                                     .addHeader(RouteConstants.ID_QUESTION, questionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.put(RouteConstants.EP_COLLECTION_QUESTION_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      String questionId = routingContext.request().getParam(RouteConstants.ID_QUESTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_QUESTION_UPDATE)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId)
                                                     .addHeader(RouteConstants.ID_QUESTION, questionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });
    router.put(RouteConstants.EP_COLLECTION_QUESTION_COPY).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_QUESTION_COPY)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.post(RouteConstants.EP_COLLECTION_RESOURCE_ADD).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_RESOURCE_ADD)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.delete(RouteConstants.EP_COLLECTION_RESOURCE_REMOVE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_RESOURCE_REMOVE)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId)
                                                     .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.put(RouteConstants.EP_COLLECTION_RESOURCE_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      String resourceId = routingContext.request().getParam(RouteConstants.ID_RESOURCE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_RESOURCE_UPDATE)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId)
                                                     .addHeader(RouteConstants.ID_RESOURCE, resourceId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });


    router.put(RouteConstants.EP_COLLECTION_RESOURCE_COPY).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_RESOURCE_COPY)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });


    router.put(RouteConstants.EP_COLLECTION_CONTENT_REORDER).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_CONTENT_REORDER)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.put(RouteConstants.EP_COLLECTION_COLLABORATORS_UPDATE).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
        MessageConstants.MSG_OP_COLLECTION_COLLABORATOR_UPDATE)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });

    router.get(RouteConstants.EP_COLLECTION_COLLABORATORS_GET).handler(routingContext -> {
      String collectionId = routingContext.request().getParam(RouteConstants.ID_COLLECTION);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_COLLECTION_COLLABORATOR_GET)
                                                     .addHeader(RouteConstants.ID_COLLECTION, collectionId);
      eb.send(MessagebusEndpoints.MBEP_COLLECTION, new RouteRequestUtility().getBodyForMessage(routingContext), options, reply -> {
        new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER);
      });

    });


  }

}