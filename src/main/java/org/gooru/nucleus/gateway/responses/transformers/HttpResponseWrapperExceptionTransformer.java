package org.gooru.nucleus.gateway.responses.transformers;

import io.vertx.core.json.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.gooru.nucleus.gateway.exceptions.HttpResponseWrapperException;

/**
 * @author ashish on 27/12/16.
 */
public final class HttpResponseWrapperExceptionTransformer implements ResponseTransformer {

  private final HttpResponseWrapperException ex;

  HttpResponseWrapperExceptionTransformer(HttpResponseWrapperException ex) {
    this.ex = ex;
  }

  @Override
  public void transform() {
    // no op
  }

  @Override
  public JsonObject transformedBody() {
    return ex.getBody();
  }

  @Override
  public Map<String, String> transformedHeaders() {
    return new HashMap<>(1);
  }

  @Override
  public int transformedStatus() {
    return ex.getStatus();
  }
}
