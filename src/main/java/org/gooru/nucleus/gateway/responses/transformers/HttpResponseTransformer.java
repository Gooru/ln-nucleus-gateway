package org.gooru.nucleus.gateway.responses.transformers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

class HttpResponseTransformer implements ResponseTransformer {

  static final Logger LOG = LoggerFactory.getLogger(ResponseTransformer.class);
  private Message<Object> message;
  private boolean transformed = false;

  public HttpResponseTransformer(Message<Object> message) {
    this.message = message;
    if (!(message.body() instanceof JsonObject)) {
      LOG.error("Message body should be JsonObject");
      throw new IllegalArgumentException("Message body should be JsonObject");
    }
  }
  
  @Override
  public void transform() {
    // TODO Auto-generated method stub
    if (!this.transformed) {
      
      this.transformed = true;
    }
  }

  @Override
  public JsonObject transformedBody() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Map<String, String> transformedHeaders() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int transformedStatus() {
    // TODO Auto-generated method stub
    return 0;
  }



}
