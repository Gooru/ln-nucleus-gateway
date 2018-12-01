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
 * @author szgooru Created On 29-Oct-2018
 */
public class RouteRbacConfigurator implements RouteConfigurator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RouteRbacConfigurator.class);
  private EventBus eb = null;
  private long mbusTimeout = 30000L;

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
    eb = vertx.eventBus();

    router.post(RouteConstants.EP_RBAC_ROLE_CREATE).handler(this::createRole);
    router.put(RouteConstants.EP_RBAC_ROLE_UPDATE).handler(this::updateRole);
    router.get(RouteConstants.EP_RBAC_ROLE_LIST).handler(this::listRoles);
    router.get(RouteConstants.EP_RBAC_ROLE_GET).handler(this::getRole);
    router.delete(RouteConstants.EP_RBAC_ROLE_DELETE).handler(this::deleteRole);
    router.put(RouteConstants.EP_RBAC_ROLE_ASSIGN).handler(this::assignRole);
    router.put(RouteConstants.EP_RBAC_ROLE_REVOKE).handler(this::revokeRole);
    router.get(RouteConstants.EP_RBAC_PERMISSION_LIST).handler(this::listPermissions);
  }

  private void createRole(RoutingContext routingContext) {
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_CREATE);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void updateRole(RoutingContext routingContext) {
    String roleId = routingContext.request().getParam(RouteConstants.ID_ROLE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_UPDATE)
        .addHeader(RouteConstants.ID_ROLE, roleId);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void listRoles(RoutingContext routingContext) {
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_LIST);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void getRole(RoutingContext routingContext) {
    String roleId = routingContext.request().getParam(RouteConstants.ID_ROLE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_GET)
        .addHeader(RouteConstants.ID_ROLE, roleId);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void deleteRole(RoutingContext routingContext) {
    String roleId = routingContext.request().getParam(RouteConstants.ID_ROLE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_DELETE)
        .addHeader(RouteConstants.ID_ROLE, roleId);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void assignRole(RoutingContext routingContext) {
    String roleId = routingContext.request().getParam(RouteConstants.ID_ROLE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_ASSIGN)
        .addHeader(RouteConstants.ID_ROLE, roleId);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void revokeRole(RoutingContext routingContext) {
    String roleId = routingContext.request().getParam(RouteConstants.ID_ROLE);
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_ROLE_REVOKE)
        .addHeader(RouteConstants.ID_ROLE, roleId);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

  private void listPermissions(RoutingContext routingContext) {
    DeliveryOptions options = DeliveryOptionsBuilder.buildWithApiVersion(routingContext)
        .setSendTimeout(mbusTimeout * 1000)
        .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_RBAC_PERMISSION_LIST);
    eb.send(MessagebusEndpoints.MBEP_RBAC,
        new RouteRequestUtility().getBodyForMessage(routingContext), options,
        reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
  }

}
