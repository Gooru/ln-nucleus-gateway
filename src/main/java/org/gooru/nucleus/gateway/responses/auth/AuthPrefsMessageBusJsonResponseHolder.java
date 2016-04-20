package org.gooru.nucleus.gateway.responses.auth;

import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

class AuthPrefsMessageBusJsonResponseHolder implements AuthPrefsResponseHolder {

    private static final Logger LOG = LoggerFactory.getLogger(AuthPrefsResponseHolder.class);
    private final Message<Object> message;
    private boolean isAuthorized = false;

    public AuthPrefsMessageBusJsonResponseHolder(Message<Object> message) {
        this.message = message;
        if (message != null) {
            LOG.debug("Received response from Auth End point : {}", message.body().toString());
            if (!(message.body() instanceof JsonObject)) {
                LOG.error("Message body is NOT JsonObject");
                throw new IllegalArgumentException("Message body should be initialized with JsonObject");
            }
            String result = message.headers().get(MessageConstants.MSG_OP_STATUS);
            LOG.debug("Received header from Auth response : {}", result);
            if (result != null && result.equalsIgnoreCase(MessageConstants.MSG_OP_STATUS_SUCCESS)) {
                isAuthorized = true;
            }
        }
    }

    @Override
    public boolean isAuthorized() {
        return isAuthorized;
    }

    @Override
    public JsonObject getPreferences() {
        if (!isAuthorized) {
            return null;
        }
        JsonObject jsonObject = (JsonObject) message.body();
        return jsonObject.getJsonObject(MessageConstants.MSG_KEY_PREFS);

    }

    @Override
    public boolean isAnonymous() {
        JsonObject jsonObject = (JsonObject) message.body();
        String userId = jsonObject.getString(MessageConstants.MSG_USER_ID);
        return !(userId != null && !userId.isEmpty() && !userId.equalsIgnoreCase(MessageConstants.MSG_USER_ANONYMOUS));
    }

    @Override
    public String getUser() {
        JsonObject jsonObject = (JsonObject) message.body();
        return jsonObject.getString(MessageConstants.MSG_USER_ID);
    }
}
