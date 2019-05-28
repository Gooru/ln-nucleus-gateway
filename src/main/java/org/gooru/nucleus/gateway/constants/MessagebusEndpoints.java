package org.gooru.nucleus.gateway.constants;

/**
 * Created by ashish on 4/12/15. It contains the definition for the "Message Bus End Points" which
 * are addresses on which the consumers are listening. Note that these definitions are for gateway,
 * and each end point would be defined in their own component as well. This means that if there is
 * any change here, there must be a corresponding change in the consumer as well.
 */
public final class MessagebusEndpoints {

  public static final String MBEP_RESOURCE = "org.gooru.nucleus.message.bus.resource";
  public static final String MBEP_QUESTION = "org.gooru.nucleus.message.bus.question";
  public static final String MBEP_ASSESSMENT = "org.gooru.nucleus.message.bus.assessment";
  public static final String MBEP_COLLECTION = "org.gooru.nucleus.message.bus.collection";
  public static final String MBEP_COURSE = "org.gooru.nucleus.message.bus.course";
  public static final String MBEP_CLASS = "org.gooru.nucleus.message.bus.class";
  public static final String MBEP_AUTH = "org.gooru.nucleus.message.bus.auth";
  public static final String MBEP_TAXONOMY = "org.gooru.nucleus.message.bus.taxonomy";
  public static final String MBEP_LOOKUP = "org.gooru.nucleus.message.bus.lookup";
  public static final String MBEP_EVENT = "org.gooru.nucleus.message.bus.publisher.event";
  public static final String MBEP_COPIER = "org.gooru.nucleus.message.bus.copier";
  public static final String MBEP_CONTENT_MAP = "org.gooru.nucleus.message.bus.content.map";
  public static final String MBEP_RBAC = "org.gooru.nucleus.message.bus.rbac";

  public static final String MBEP_PROFILE = "org.gooru.nucleus.message.bus.profile";
  public static final String MBEP_LIBRARY = "org.gooru.nucleus.message.bus.library";
  public static final String MBEP_METRICS = "org.gooru.nucleus.message.bus.metrics";


  private MessagebusEndpoints() {
    throw new AssertionError();
  }
}
