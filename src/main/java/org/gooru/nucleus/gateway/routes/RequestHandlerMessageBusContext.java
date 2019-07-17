package org.gooru.nucleus.gateway.routes;

import io.vertx.core.eventbus.EventBus;
import org.slf4j.Logger;

/**
 * @author ashish.
 */

public class RequestHandlerMessageBusContext {

  private final EventBus eb;
  private final String messageBusEndpoint;
  private final long mbusTimeout;
  private final Logger LOGGER;


  public RequestHandlerMessageBusContext(EventBus eb, String messageBusEndpoint, long mbusTimeout,
      Logger logger) {
    this.eb = eb;
    this.messageBusEndpoint = messageBusEndpoint;
    this.mbusTimeout = mbusTimeout;
    LOGGER = logger;
  }

  public EventBus getEb() {
    return eb;
  }

  public long getMbusTimeout() {
    return mbusTimeout;
  }

  public Logger getLOGGER() {
    return LOGGER;
  }

  public String getMessageBusEndpoint() {
    return messageBusEndpoint;
  }
}
