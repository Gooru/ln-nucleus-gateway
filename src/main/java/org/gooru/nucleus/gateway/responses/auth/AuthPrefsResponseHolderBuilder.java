package org.gooru.nucleus.gateway.responses.auth;

import io.vertx.core.eventbus.Message;

public final class AuthPrefsResponseHolderBuilder {

  public static AuthPrefsResponseHolder build(Message<Object> message) {
    return new AuthPrefsMessageBusJsonResponseHolder(message);
  }

  private AuthPrefsResponseHolderBuilder() {
    throw new AssertionError();
  }
}
