package org.gooru.nucleus.gateway.constants;

public final class MessageConstants {

  public static final String MSG_HEADER_OP = "mb.operation";
  public static final String MSG_API_VERSION = "api.version";
  public static final String MSG_HEADER_TOKEN = "session.token";
  public static final String MSG_OP_AUTH = "auth";
  public static final String MSG_OP_STATUS = "mb.operation.status";
  public static final String MSG_KEY_SESSION = "session";
  public static final String MSG_OP_STATUS_SUCCESS = "success";
  public static final String MSG_OP_STATUS_ERROR = "error";
  public static final String MSG_OP_STATUS_VALIDATION_ERROR = "error.validation";
  public static final String MSG_USER_ANONYMOUS = "anonymous";
  public static final String MSG_USER_ID = "user_id";
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
  public static final String MSG_OP_RES_DELETE = "resource.delete";

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
  public static final String MSG_OP_LKUP_COUNTRIES = "countries";
  public static final String MSG_OP_LKUP_STATES = "states";
  public static final String MSG_OP_LKUP_SCHOOLDISTRICTS = "school-districts";
  public static final String MSG_OP_LKUP_SCHOOLS = "schools";
  public static final String MSG_OP_LKUP_LICENSES = "licenses";
  public static final String MSG_OP_LKUP_LANGUAGES = "languages";
  public static final String MSG_OP_LKUP_APIKEY_CONFIG = "apikey.config";


  // Assessment Operations
  public static final String MSG_OP_ASSESSMENT_GET = "assessment.get";
  public static final String MSG_OP_ASSESSMENT_CREATE = "assessment.create";
  public static final String MSG_OP_ASSESSMENT_UPDATE = "assessment.update";
  public static final String MSG_OP_ASSESSMENT_DELETE = "assessment.delete";
  public static final String MSG_OP_ASSESSMENT_COLLABORATOR_UPDATE = "assessment.collaborator.update";
  public static final String MSG_OP_ASSESSMENT_MASTERY_ACCRUAL_GET = "assessment.mastery-accrual.get";
  public static final String MSG_OP_ASSESSMENT_QUESTION_ADD = "assessment.question.add";
  public static final String MSG_OP_ASSESSMENT_QUESTION_REORDER = "assessment.content.reorder";
  // External Assessment Operations
  public static final String MSG_OP_EXT_ASSESSMENT_GET = "ext.assessment.get";
  public static final String MSG_OP_EXT_ASSESSMENT_CREATE = "ext.assessment.create";
  public static final String MSG_OP_EXT_ASSESSMENT_UPDATE = "ext.assessment.update";
  public static final String MSG_OP_EXT_ASSESSMENT_DELETE = "ext.assessment.delete";

  // Collection Operations
  public static final String MSG_OP_COLLECTION_GET = "collection.get";
  public static final String MSG_OP_COLLECTION_CREATE = "collection.create";
  public static final String MSG_OP_COLLECTION_UPDATE = "collection.update";
  public static final String MSG_OP_COLLECTION_DELETE = "collection.delete";
  public static final String MSG_OP_COLLECTION_COLLABORATOR_UPDATE = "collection.collaborator.update";
  public static final String MSG_OP_COLLECTION_QUESTION_ADD = "collection.question.add";
  public static final String MSG_OP_COLLECTION_CONTENT_REORDER = "collection.content.reorder";
  public static final String MSG_OP_COLLECTION_RESOURCE_ADD = "collection.resource.add";

  // External Collection Operations
  public static final String MSG_OP_EXT_COLLECTION_GET = "ext.collection.get";
  public static final String MSG_OP_EXT_COLLECTION_CREATE = "ext.collection.create";
  public static final String MSG_OP_EXT_COLLECTION_UPDATE = "ext.collection.update";
  public static final String MSG_OP_EXT_COLLECTION_DELETE = "ext.collection.delete";

  // Question Operations
  public static final String MSG_OP_QUESTION_GET = "question.get";
  public static final String MSG_OP_QUESTION_CREATE = "question.create";
  public static final String MSG_OP_QUESTION_UPDATE = "question.update";
  public static final String MSG_OP_QUESTION_DELETE = "question.delete";
  public static final String MSG_OP_QUESTION_GET_BULK = "bulk.question.get";
  public static final String MSG_OP_QUESTION_SCORE_UPDATE = "question.score.update";

  // Rubric Operations
  public static final String MSG_OP_RUBRIC_GET = "rubric.get";
  public static final String MSG_OP_RUBRIC_CREATE = "rubric.create";
  public static final String MSG_OP_RUBRIC_UPDATE = "rubric.update";
  public static final String MSG_OP_RUBRIC_DELETE = "rubric.delete";
  public static final String MSG_OP_QUESTION_RUBRIC_ASSOCIATE = "question.rubirc.association";

  // Course Operations
  public static final String MSG_OP_COURSE_LIST_GET = "course.list.get";
  public static final String MSG_OP_COURSE_GET = "course.get";
  public static final String MSG_OP_COURSE_MS_GET = "course.ms.get";
  public static final String MSG_OP_COURSE_MS_MILESTONE_GET = "course.ms.milestone.get";
  public static final String MSG_OP_COURSE_CREATE = "course.create";
  public static final String MSG_OP_COURSE_UPDATE = "course.update";
  public static final String MSG_OP_COURSE_DELETE = "course.delete";
  public static final String MSG_OP_COURSE_COLLABORATOR_UPDATE = "course.collaborator.update";
  public static final String MSG_OP_COURSE_CONTENT_REORDER = "course.content.reorder";
  public static final String MSG_OP_COURSE_MOVE_UNIT = "course.move.unit";
  public static final String MSG_OP_COURSE_REORDER = "course.reorder";
  public static final String MSG_OP_COURSE_RESOURCES_GET = "course.resources.get";
  public static final String MSG_OP_COURSE_ASSESSMENTS_GET = "course.assessments.get";
  public static final String MSG_OP_COURSE_COLLECTIONS_GET = "course.collections.get";
  public static final String MSG_OP_UNIT_GET = "unit.get";
  public static final String MSG_OP_UNIT_CREATE = "unit.create";
  public static final String MSG_OP_UNIT_UPDATE = "unit.update";
  public static final String MSG_OP_UNIT_DELETE = "unit.delete";
  public static final String MSG_OP_UNIT_CONTENT_REORDER = "unit.content.reorder";
  public static final String MSG_OP_UNIT_MOVE_LESSON = "unit.move.lesson";
  public static final String MSG_OP_LESSON_GET = "lesson.get";
  public static final String MSG_OP_LESSON_CREATE = "lesson.create";
  public static final String MSG_OP_LESSON_UPDATE = "lesson.update";
  public static final String MSG_OP_LESSON_DELETE = "lesson.delete";
  public static final String MSG_OP_LESSON_CONTENT_REORDER = "lesson.content.reorder";
  public static final String MSG_OP_LESSON_MOVE_COLLECTION = "lesson.move.collection";
  public static final String MSG_OP_LESSON_REMOVE_COLLECTION = "lesson.remove.collection";

  // Taxonomy Lookup Operations

  // Operation names: Also need to be updated in corresponding handlers
  public static final String MSG_OP_TAXONOMY_SUBJECTS_GET = "taxonomy.subjects.get";
  public static final String MSG_OP_TAXONOMY_SUBJECTS_FETCH = "taxonomy.subjects.fetch";
  public static final String MSG_OP_TAXONOMY_COURSES_GET = "taxonomy.courses.get";
  public static final String MSG_OP_TAXONOMY_DOMAINS_GET = "taxonomy.domains.get";
  public static final String MSG_OP_TAXONOMY_DOMAIN_CODES_GET = "taxonomy.domain.codes.get";
  public static final String MSG_OP_TAXONOMY_CODES_GET = "taxonomy.codes.get";
  public static final String MSG_OP_TAXONOMY_CROSSWALK_GDFW_GET = "taxonomy.crosswalk.gdfw.get";
  public static final String MSG_OP_TAXONOMY_CROSSWALK_FW_GET = "taxonomy.crosswalk.fw.get";
  public static final String MSG_OP_TAXONOMY_FRAMEWORKS_GET = "taxonomy.frameworks.get";
  public static final String MSG_OP_TAXONOMY_SUBJECT_CLASSIFICATIONS_GET = "taxonomy.subject.classifications.get";
  public static final String MSG_OP_TAXONOMY_FRAMEWORKS_SUBJECTS_LIST = "taxonomy.frameworks.subjects.list";

  // Class operations
  public static final String MSG_OP_CLASS_CREATE = "class.create";
  public static final String MSG_OP_CLASS_UPDATE = "class.update";
  public static final String MSG_OP_CLASS_DELETE = "class.delete";
  public static final String MSG_OP_CLASS_GET = "class.get";
  public static final String MSG_OP_CLASS_MEMBERS_GET = "class.members.get";
  public static final String MSG_OP_CLASS_MEMBERS_ACTIVATE = "class.members.activate";
  public static final String MSG_OP_CLASS_MEMBERS_DEACTIVATE = "class.members.deactivate";
  public static final String MSG_OP_CLASS_COLLABORATORS_UPDATE = "class.collaborators.update";
  public static final String MSG_OP_CLASS_LIST = "class.list";
  public static final String MSG_OP_CLASS_LIST_FOR_COURSE = "class.list.for.course";
  public static final String MSG_OP_CLASS_JOIN = "class.join";
  public static final String MSG_OP_CLASS_INVITE = "class.invite.user";
  public static final String MSG_OP_CLASS_COURSE_ASSOCIATION = "class.course.association";
  public static final String MSG_OP_CLASS_SET_CONTENT_VISIBILITY = "class.content.visibility.set";
  public static final String MSG_OP_CLASS_GET_CONTENT_VISIBILITY_STATS = "class.content.visibility.stats.get";
  public static final String MSG_OP_CLASS_GET_CONTENT_VISIBILITY = "class.content.visibility.get";
  public static final String MSG_OP_CLASS_INVITE_REMOVE = "class.invite.user.remove";
  public static final String MSG_OP_CLASS_REMOVE_STUDENT = "class.join.removal";
  public static final String MSG_OP_CLASS_ARCHIVE = "class.archive";
  public static final String MSG_OP_CLASS_REROUTE_SETTINGS_UPDATE = "class.reroute.settings.update";
  public static final String MSG_OP_CLASS_MEMBERS_REROUTE_SETTINGS_UPDATE = "class.members.reroute.settings.update";
  public static final String MSG_OP_CLASS_LPBASELINE_TRIGGER = "class.lb.baseline.trigger";
  public static final String MSG_OP_CLASS_LPBASELINE_STUDENT_TRIGGER = "class.lb.baseline.student.trigger";
  public static final String MSG_OP_CLASS_PREFERENCE_UPDATE = "class.preference.update";
  public static final String MSG_OP_CLASS_LANGUAGE_UPDATE = "class.language.update";

  // Copier Operations
  public static final String MSG_OP_RESOURCE_COPY = "resource.copy";
  public static final String MSG_OP_QUESTION_COPY = "question.copy";
  public static final String MSG_OP_COLLECTION_COPY = "collection.copy";
  public static final String MSG_OP_ASSESSMENT_COPY = "assessment.copy";
  public static final String MSG_OP_COURSE_COPY = "course.copy";
  public static final String MSG_OP_UNIT_COPY = "unit.copy";
  public static final String MSG_OP_LESSON_COPY = "lesson.copy";
  public static final String MSG_OP_RUBRIC_COPY = "rubric.copy";

  // Profile Operations
  public static final String MSG_OP_PROFILE_COURSE_LIST = "profile.course.list";
  public static final String MSG_OP_PROFILE_COLLECTION_LIST = "profile.collection.list";
  public static final String MSG_OP_PROFILE_ASSESSMENT_LIST = "profile.assessment.list";
  public static final String MSG_OP_PROFILE_RESOURCE_LIST = "profile.resource.list";
  public static final String MSG_OP_PROFILE_QUESTION_LIST = "profile.question.list";
  public static final String MSG_OP_PROFILE_RUBRIC_LIST = "profile.rubric.list";
  public static final String MSG_OP_PROFILE_DEMOGRAPHICS_GET = "profile.demographics.get";
  public static final String MSG_OP_PROFILE_FOLLOW = "profile.follow";
  public static final String MSG_OP_PROFILE_UNFOLLOW = "profile.unfollow";
  public static final String MSG_OP_PROFILE_NETWORK_GET = "profile.network.get";
  public static final String MSG_OP_PROFILE_SEARCH = "profile.search";
  public static final String MSG_OP_PROFILE_PREFERENCE_GET = "profile.preference.get";
  public static final String MSG_OP_PROFILE_PREFERENCE_UPDATE = "profile.preference.update";
  public static final String MSG_OP_PROFILE_STATE_UPDATE = "profile.state.update";
  public static final String MSG_OP_PROFILE_OFFLINE_ACTIVITES_LIST = "profile.offline.activities.list";

  // Content map Operations
  public static final String MSG_OP_BOOKMARK_CREATE = "bookmark.create";
  public static final String MSG_OP_BOOKMARK_DELETE = "bookmark.delete";
  public static final String MSG_OP_BOOKMARK_LIST = "bookmark.list";

  public static final String MSG_OP_COURSEMAP_COURSE_GET = "coursemap.course.get";
  public static final String MSG_OP_COURSEMAP_UNIT_GET = "coursemap.unit.get";
  public static final String MSG_OP_COURSEMAP_LESSON_GET = "coursemap.lesson.get";

  public static final String MSG_OP_CLASS_CONTENT_ADD = "class.content.add";
  public static final String MSG_OP_CLASS_CONTENT_LIST_UNSCHEDULED = "class.content.list.unscheduled";
  public static final String MSG_OP_CLASS_CONTENT_LIST_OFFLINE_COMPLETED = "class.content.list.offline.completed";
  public static final String MSG_OP_CLASS_CONTENT_LIST_OFFLINE_ACTIVE = "class.content.list.offline.active";
  public static final String MSG_OP_CLASS_CONTENT_LIST_ONLINE_SCHEDULED = "class.content.list.online.scheduled";
  public static final String MSG_OP_CLASS_CONTENT_ENABLE = "class.content.enable";
  public static final String MSG_OP_CLASS_CONTENT_SCHEDULE = "class.content.schedule";
  public static final String MSG_OP_CLASS_CONTENT_DELETE = "class.content.delete";
  public static final String MSG_OP_CLASS_CONTENT_USERS_ADD = "class.content.users.add";
  public static final String MSG_OP_CLASS_CONTENT_USERS_LIST = "class.content.users.list";
  public static final String MSG_OP_CLASS_CONTENT_MASTERY_ACCRUAL_UPDATE = "class.content.mastery.accrual.update";
  public static final String MSG_OP_CLASS_CONTENT_COMPLETION = "class.content.completion";

  // Event Operations
  public static final String MSG_OP_EVENT_PUBLISH = "event.publish";
  public static final String MSG_OP_EVENT_PROCESS = "event.process";

  //Request Processing LOG constants
  public static final String MSG_OP_AUTH_TIME = "processing.time.auth";
  public static final String MSG_OP_HANDLER_START = "start.time.handler";

  public static final String MSG_OP_FIREBASE_JWT_CREATION = "firebase.jwt";

  // Library Operations
  public static final String MSG_OP_LIBRARY_GET = "library.get";
  public static final String MSG_OP_LIBRARIES_GET = "libraries.get";
  public static final String MSG_OP_LIBRARY_CONTENTS_GET = "library.contents.get";

  // RBAC Operations
  public static final String MSG_OP_RBAC_ROLE_CREATE = "rbac.role.create";
  public static final String MSG_OP_RBAC_ROLE_UPDATE = "rbac.role.update";
  public static final String MSG_OP_RBAC_ROLE_LIST = "rbac.role.list";
  public static final String MSG_OP_RBAC_ROLE_GET = "rbac.role.get";
  public static final String MSG_OP_RBAC_ROLE_DELETE = "rbac.role.delete";
  public static final String MSG_OP_RBAC_ROLE_ASSIGN = "rbac.role.assign";
  public static final String MSG_OP_RBAC_ROLE_REVOKE = "rbac.role.revoke";
  public static final String MSG_OP_RBAC_PERMISSION_LIST = "rbac.permission.list";

  private MessageConstants() {
    throw new AssertionError();
  }
}
