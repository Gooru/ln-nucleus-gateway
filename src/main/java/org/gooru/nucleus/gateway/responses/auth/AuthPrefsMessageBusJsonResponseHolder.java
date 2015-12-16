package org.gooru.nucleus.gateway.responses.auth;

import org.gooru.nucleus.gateway.constants.MessageConstants;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

class AuthPrefsMessageBusJsonResponseHolder implements AuthPrefsResponseHolder {

  private Message<Object> message;
  private boolean isAuthorized = false;
  
  @Override
  public boolean isAuthorized() {
    return isAuthorized;
  }

  @Override
  public JsonObject getPreferences() {
    if (!isAuthorized) {      
      return null;
    }
    // TODO: Move hard coded strings out
    JsonObject jsonObject = (JsonObject)message.body();
    return jsonObject.getJsonObject("prefs");
  }

  public AuthPrefsMessageBusJsonResponseHolder(Message<Object> message) {
    this.message = message;
    if (message == null) {
      isAuthorized = false;
    } else {
      
      String result = message.headers().get(MessageConstants.MSG_OP_STATUS);
      if (result != null && result.equalsIgnoreCase(MessageConstants.MSG_OP_STATUS_SUCCESS)) {
        isAuthorized =  true;
      }
    }
  }
  
}
