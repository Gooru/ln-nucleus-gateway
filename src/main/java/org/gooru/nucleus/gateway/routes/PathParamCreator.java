package org.gooru.nucleus.gateway.routes;

import io.vertx.ext.web.RoutingContext;
import java.util.Map;

/**
 * @author ashish.
 */

public interface PathParamCreator {

  Map<String, String> getHeadersFromPathParams(RoutingContext routingContext, String op);

}
