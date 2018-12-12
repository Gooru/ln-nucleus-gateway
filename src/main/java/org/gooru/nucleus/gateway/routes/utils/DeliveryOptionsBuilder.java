package org.gooru.nucleus.gateway.routes.utils;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.ext.web.RoutingContext;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.RouteConstants;

/**
 * @author ashish on 27/12/16.
 */
public final class DeliveryOptionsBuilder {

  private DeliveryOptionsBuilder() {
    throw new AssertionError();
  }

  public static DeliveryOptions buildWithApiVersion(RoutingContext context) {
    final String apiVersion = context.request().getParam(RouteConstants.API_VERSION);
    VersionValidatorUtility.validateVersion(apiVersion);
    return new DeliveryOptions().addHeader(MessageConstants.MSG_API_VERSION, apiVersion);
  }
}
