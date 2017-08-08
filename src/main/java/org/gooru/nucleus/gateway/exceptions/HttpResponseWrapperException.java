package org.gooru.nucleus.gateway.exceptions;

import org.gooru.nucleus.gateway.constants.HttpConstants;

import io.vertx.core.json.JsonObject;

/**
 * @author ashish on 27/12/16.
 */
public final class HttpResponseWrapperException extends RuntimeException {
    private final HttpConstants.HttpStatus status;
    private final JsonObject payload;

    public HttpResponseWrapperException(HttpConstants.HttpStatus status, JsonObject payload) {
        this.status = status;
        this.payload = payload;
    }

    public HttpResponseWrapperException(HttpConstants.HttpStatus status, String message) {
        this.status = status;
        this.payload = new JsonObject().put("message", message);
    }

    public int getStatus() {
        return this.status.getCode();
    }

    public JsonObject getBody() {
        return this.payload;
    }
}
