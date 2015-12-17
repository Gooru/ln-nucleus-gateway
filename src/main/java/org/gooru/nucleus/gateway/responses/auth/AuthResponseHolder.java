package org.gooru.nucleus.gateway.responses.auth;

public interface AuthResponseHolder {
  public boolean isAuthorized();
  public boolean isAnonymous();
}
