package org.gooru.nucleus.gateway.responses.auth;

public interface AuthResponseHolder {

  boolean isAuthorized();

  boolean isAnonymous();

  String getUser();
}
