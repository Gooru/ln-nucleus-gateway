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
 * Created by ashish on 25/3/16.
 */
public class RouteAssessmentExternalConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteAssessmentExternalConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    final EventBus eb = vertx.eventBus();

    final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);

    router.get(RouteConstants.EP_ASSESSMENT_EX_GET).handler(routingContext -> {
      String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
      DeliveryOptions options =
        new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EXT_ASSESSMENT_GET)
                             .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
      eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.put(RouteConstants.EP_ASSESSMENT_EX_UPDATE).handler(routingContext -> {
      String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EXT_ASSESSMENT_UPDATE)
                                                     .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
      eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    });

    router.delete(RouteConstants.EP_ASSESSMENT_EX_DELETE).handler(routingContext -> {
      String assessmentId = routingContext.request().getParam(RouteConstants.ID_ASSESSMENT);
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EXT_ASSESSMENT_DELETE)
                                                     .addHeader(RouteConstants.ID_ASSESSMENT, assessmentId);
      eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });

    router.post(RouteConstants.EP_ASSESSMENT_EX_CREATE).handler(routingContext -> {
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                                                     .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_EXT_ASSESSMENT_CREATE);
      eb.send(MessagebusEndpoints.MBEP_ASSESSMENT, new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));

    });


  }
}
