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


class RouteTaxonomyConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteTaxonomyConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_STANDARDS_LIST_BY_DOMAINS).handler(routingContext -> {
      String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
      String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
      String domainId = routingContext.request().getParam(RouteConstants.ID_TX_DOMAIN);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_STANDARDS_GET)
                                                     .addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
                                                     .addHeader(RouteConstants.ID_TX_COURSE, courseId)
                                                     .addHeader(RouteConstants.ID_TX_DOMAIN, domainId);
      eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_DOMAINS_LIST_BY_COURSE).handler(routingContext -> {
      String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
      String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_DOMAINS_GET)
                                                     .addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
                                                     .addHeader(RouteConstants.ID_TX_COURSE, courseId);
      eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.get(RouteConstants.EP_COURSES_LIST_BY_SUBJECT).handler(routingContext -> {
      String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_COURSES_GET)
                                                     .addHeader(RouteConstants.ID_TX_SUBJECT, subjectId);
      eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });


    router.get(RouteConstants.EP_SUBJECTS_LIST).handler(routingContext -> {
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_SUBJECTS_GET);
      eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });
  }
}
