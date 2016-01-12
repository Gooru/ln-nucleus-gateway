package org.gooru.nucleus.gateway.routes.utils;

import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.ext.web.RoutingContext;
import org.gooru.nucleus.gateway.responses.writers.ResponseWriterBuilder;
import org.slf4j.Logger;

/**
 * Created by ashish on 30/12/15.
 */
public class RouteResponseUtility {


  public void responseHandler(final RoutingContext routingContext, final AsyncResult<Message<Object>> reply,
                              final Logger LOG) {
    if (reply.succeeded()) {
      new ResponseWriterBuilder(routingContext, reply).build().writeResponse();
    } else {
      LOG.error("Not able to send message", reply.cause());
      routingContext.response().setStatusCode(500).end();
    }
  }
}
