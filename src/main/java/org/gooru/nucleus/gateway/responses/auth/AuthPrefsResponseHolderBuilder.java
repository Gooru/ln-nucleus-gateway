package org.gooru.nucleus.gateway.responses.auth;

import io.vertx.core.eventbus.Message;

public class AuthPrefsResponseHolderBuilder {
  private final Message<Object> message;

  public AuthPrefsResponseHolderBuilder(Message<Object> message) {
    this.message = message;
  }

  public AuthPrefsResponseHolder build() {
    return new AuthPrefsMessageBusJsonResponseHolder(message);
  }
}
