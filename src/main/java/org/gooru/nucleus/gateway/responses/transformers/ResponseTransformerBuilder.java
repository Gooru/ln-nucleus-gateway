package org.gooru.nucleus.gateway.responses.transformers;

import org.gooru.nucleus.gateway.exceptions.HttpResponseWrapperException;

import io.vertx.core.eventbus.Message;

public final class ResponseTransformerBuilder {

    public static ResponseTransformer build(Message<Object> message) {
        return new HttpResponseTransformer(message);
    }

    public static ResponseTransformer buildHttpResponseWrapperExceptionBuild(HttpResponseWrapperException ex) {
        return new HttpResponseWrapperExceptionTransformer(ex);
    }

    private ResponseTransformerBuilder() {
        throw new AssertionError();
    }
}
