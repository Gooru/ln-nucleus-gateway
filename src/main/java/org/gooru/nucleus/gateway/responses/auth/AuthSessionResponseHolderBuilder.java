package org.gooru.nucleus.gateway.responses.auth;

import io.vertx.core.eventbus.Message;

public final class AuthSessionResponseHolderBuilder {

  public static AuthSessionResponseHolder build(Message<Object> message) {
    return new AuthSessionMessageBusJsonResponseHolder(message);
  }

  private AuthSessionResponseHolderBuilder() {
    throw new AssertionError();
  }
}
