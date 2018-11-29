package org.gooru.nucleus.gateway.responses.transformers;

import io.vertx.core.eventbus.Message;
import org.gooru.nucleus.gateway.exceptions.HttpResponseWrapperException;

public final class ResponseTransformerBuilder {

  public static ResponseTransformer build(Message<Object> message) {
    return new HttpResponseTransformer(message);
  }

  public static ResponseTransformer buildHttpResponseWrapperExceptionBuild(
      HttpResponseWrapperException ex) {
    return new HttpResponseWrapperExceptionTransformer(ex);
  }

  private ResponseTransformerBuilder() {
    throw new AssertionError();
  }
}
