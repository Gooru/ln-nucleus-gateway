package org.gooru.nucleus.gateway.constants;

public class MessageConstants {

  public static final String MSG_HEADER_OP = "mb.operation";
  public static final String MSG_HEADER_TOKEN = "session.token";
  public static final String MSG_OP_AUTH_WITH_PREFS = "auth.with.prefs";
  public static final String MSG_OP_STATUS = "mb.operation.status";
  public static final String MSG_KEY_PREFS = "prefs";
  public static final String MSG_OP_STATUS_SUCCESS = "success";
  public static final String MSG_OP_STATUS_ERROR = "error";
  public static final String MSG_OP_STATUS_VALIDATION_ERROR = "error.validation";
  public static final String MSG_USER_ANONYMOUS = "anonymous";
  public static final String MSG_USER_ID = "userId";
  public static final String MSG_HTTP_STATUS = "http.status";
  public static final String MSG_HTTP_BODY = "http.body";
  public static final String MSG_HTTP_RESPONSE = "http.response";
  public static final String MSG_HTTP_ERROR = "http.error";
  public static final String MSG_HTTP_VALIDATION_ERROR = "http.validation.error";
  public static final String MSG_HTTP_HEADERS = "http.headers";

  // Operation names: Also need to be updated in corresponding handlers

  // Resource operations
  public static final String MSG_OP_RES_GET = "resource.get";
  public static final String MSG_OP_RES_CREATE = "resource.create";
  public static final String MSG_OP_RES_UPDATE = "resource.update";

  // Lookup Operations
  public static final String MSG_OP_LKUP_ACCESS_HAZARDS = "access.hazards";
  public static final String MSG_OP_LKUP_EDU_USE = "educational.use";
  public static final String MSG_OP_LKUP_READ_LEVEL = "reading.level";
  public static final String MSG_OP_LKUP_AD_STATUS = "ad.status";
  public static final String MSG_OP_LKUP_MEDIA_FEATURES = "media.features";
  public static final String MSG_OP_LKUP_GRADE = "grades";
  public static final String MSG_OP_LKUP_21_CEN_SKILLS = "21.cen.skills";
  public static final String MSG_OP_LKUP_AUDIENCE = "audience";
  public static final String MSG_OP_LKUP_MOMENTS = "moments";
  public static final String MSG_OP_LKUP_DOK = "dok";
  // Assessment Operations
  public static final String MSG_OP_ASSESSMENT_GET = "assessment.get";
  public static final String MSG_OP_ASSESSMENT_CREATE = "assessment.create";
  public static final String MSG_OP_ASSESSMENT_UPDATE = "assessment.update";
  public static final String MSG_OP_ASSESSMENT_DELETE = "assessment.delete";
  public static final String MSG_OP_ASSESSMENT_COLLABORATOR_GET = "assessment.collaborator.get";
  public static final String MSG_OP_ASSESSMENT_COLLABORATOR_UPDATE = "assessment.collaborator.update";
  public static final String MSG_OP_ASSESSMENT_QUESTION_REMOVE = "assessment.question.remove";
  public static final String MSG_OP_ASSESSMENT_QUESTION_UPDATE = "assessment.question.update";
  public static final String MSG_OP_ASSESSMENT_QUESTION_ADD = "assessment.question.add";
  public static final String MSG_OP_ASSESSMENT_QUESTION_REORDER = "assessment.question.reorder";
  public static final String MSG_OP_ASSESSMENT_QUESTION_COPY = "assessment.question.copy";
  // Collection Operations
  public static final String MSG_OP_COLLECTION_GET = "collection.get";
  public static final String MSG_OP_COLLECTION_CREATE = "collection.create";
  public static final String MSG_OP_COLLECTION_UPDATE = "collection.update";
  public static final String MSG_OP_COLLECTION_DELETE = "collection.delete";
  public static final String MSG_OP_COLLECTION_COLLABORATOR_GET = "collection.collaborator.get.";
  public static final String MSG_OP_COLLECTION_COLLABORATOR_UPDATE = "collection..collaborator.update";
  public static final String MSG_OP_COLLECTION_QUESTION_REMOVE = "collection.question.remove";
  public static final String MSG_OP_COLLECTION_QUESTION_ADD = "collection.question.add";
  public static final String MSG_OP_COLLECTION_QUESTION_UPDATE = "collection.question.update";
  public static final String MSG_OP_COLLECTION_QUESTION_COPY = "collection.question.copy";
  public static final String MSG_OP_COLLECTION_CONTENT_REORDER = "collection.question.reorder";
  public static final String MSG_OP_COLLECTION_RESOURCE_UPDATE = "collection.resource.update";
  public static final String MSG_OP_COLLECTION_RESOURCE_COPY = "collection.resource.copy";
  public static final String MSG_OP_COLLECTION_RESOURCE_REMOVE = "collection.resource.remove";
  public static final String MSG_OP_COLLECTION_RESOURCE_ADD = "collection.resource.add";
  // Question Operations
  public static final String MSG_OP_QUESTION_GET = "question.get";
  public static final String MSG_OP_QUESTION_CREATE = "question.create";
  public static final String MSG_OP_QUESTION_UPDATE = "question.update";
  // Course Operations
  public static final String MSG_OP_COURSE_GET = "course.get";
  public static final String MSG_OP_COURSE_CREATE = "course.create";
  public static final String MSG_OP_COURSE_UPDATE = "course.update";
  public static final String MSG_OP_COURSE_DELETE = "course.delete";
  public static final String MSG_OP_COURSE_COLLABORATOR_GET = "course.collaborator.get";
  public static final String MSG_OP_COURSE_COLLABORATOR_UPDATE = "course.collaborator.update";
  public static final String MSG_OP_COURSE_CONTENT_REORDER = "course.content.reorder";
  public static final String MSG_OP_COURSE_COPY = "course.copy";
  public static final String MSG_OP_UNIT_GET = "unit.get";
  public static final String MSG_OP_UNIT_CREATE = "unit.create";
  public static final String MSG_OP_UNIT_UPDATE = "unit.update";
  public static final String MSG_OP_UNIT_DELETE = "unit.delete";
  public static final String MSG_OP_UNIT_CONTENT_REORDER = "unit.content.reorder";
  public static final String MSG_OP_UNIT_COPY = "unit.copy";
  public static final String MSG_OP_LESSON_GET = "lesson.get";
  public static final String MSG_OP_LESSON_CREATE = "lesson.create";
  public static final String MSG_OP_LESSON_UPDATE = "lesson.update";
  public static final String MSG_OP_LESSON_DELETE = "lesson.delete";
  public static final String MSG_OP_LESSON_CONTENT_REORDER = "lesson.content.reorder";
  public static final String MSG_OP_LESSON_COPY = "lesson.copy";

}