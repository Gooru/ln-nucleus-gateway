package org.gooru.nucleus.gateway.responses.auth;

import io.vertx.core.json.JsonObject;

public interface AuthPrefsResponseHolder extends AuthResponseHolder {
  JsonObject getPreferences();
}
