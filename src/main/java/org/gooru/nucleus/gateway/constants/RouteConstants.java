package org.gooru.nucleus.gateway.constants;

/**
 * Created by ashish on 4/12/15.
 */
public final class RouteConstants {

  public static final String API_AUTH_ROUTE = "/api/nucleus/*";
  // Helper: Entity Id constants
  public static final String ID_RESOURCE = "resourceId";
  public static final String ID_QUESTION = "questionId";
  public static final String ID_ASSESSMENT = "assessmentId";
  public static final String ID_COLLECTION = "collectionId";
  public static final String ID_COURSE = "courseId";
  public static final String ID_UNIT = "unitId";
  public static final String ID_LESSON = "lessonId";
  public static final String ID_CLASS = "classId";
  public static final String ID_TX_SUBJECT = "subjectId";
  public static final String ID_TX_DOMAIN = "domainId";
  public static final String ID_TX_COURSE = "courseId";
  public static final String ID_TX_STANDARD_FRAMEWORK = "standardFrameworkId";
  public static final String ID_TX_CODE = "codeId";
  public static final String ID_COUNTRY = "countryId";
  public static final String ID_USER = "userId";

  // Helper: Operations
  private static final String OP_ORDER = "order";
  private static final String OP_LOOKUP = "lookups";
  private static final String OP_MEMBER = "members";
  private static final String OP_INVITE = "invites";
  private static final String OP_AUTH = "authorization";
  private static final String OP_DEMOGRAPHICS = "demographics";
  private static final String OP_FOLLOW = "follow";
  private static final String OP_UNFOLLOW = "unfollow";
  private static final String OP_FOLLOWERS = "followers";
  private static final String OP_FOLLOWINGS = "followings";
  private static final String OP_SEARCH = "search";

  // Request Params
  public static final String PARAM_PREVIEW = "preview";

  // Misc helpers
  private static final String RES_EDUCATIONAL_USE = "educational-use";
  private static final String RES_DOK = "dok";
  private static final String RES_ACCESS_HAZARDS = "access-hazards";
  private static final String RES_READING_LEVELS = "reading-levels";
  private static final String RES_ADS = "ads";
  private static final String RES_MEDIA_FEATURES = "media-features";
  private static final String RES_CEN21SKILLS = "21-century-skills";
  private static final String RES_GRADES = "grades";
  private static final String RES_MOMENTS = "moments";
  private static final String RES_AUDIENCE = "audience";
  private static final String RES_COUNTRIES = "countries";
  private static final String RES_STATES = "states";
  private static final String RES_SCHOOLDISTRICTS = "school-districts";
  private static final String RES_SCHOOLS = "schools";
  private static final String RES_TX_STANDARD_FRAMEWORK = "standard-frameworks";
  private static final String SEP = "/";
  private static final String COLON = ":";
  // Helper constants
  private static final String API_VERSION = "v1";
  private static final String API_BASE_ROUTE = "/api/nucleus/" + API_VERSION + '/';
  // Helper: Entity name constants
  private static final String ENTITY_RESOURCES = "resources";
  private static final String ENTITY_QUESTIONS = "questions";
  private static final String ENTITY_ASSESSMENTS = "assessments";
  private static final String ENTITY_COLLECTIONS = "collections";
  private static final String ENTITY_COURSES = "courses";
  private static final String ENTITY_UNITS = "units";
  private static final String ENTITY_LESSONS = "lessons";
  private static final String ENTITY_CLASSES = "classes";
  private static final String ENTITY_COLLABORATORS = "collaborators";
  private static final String ENTITY_TAXONOMY = "taxonomy";
  private static final String ENTITY_TX_SUBJECT = "subjects";
  private static final String ENTITY_TX_COURSE = "courses";
  private static final String ENTITY_TX_DOMAIN = "domains";
  private static final String ENTITY_TX_CODES = "codes";
  private static final String ENTITY_COPIER = "copier";
  private static final String ENTITY_PROFILES = "profiles";

  // Actual End Point Constants: Note that constant values may be duplicated but
  // we are going to have individual constant values to work with for each
  // point instead of reusing the same

  // List Subjects in Taxonomy = /api/nucleus/{version}/taxonomy/subjects
  public static final String EP_SUBJECTS_LIST = API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + ENTITY_TX_SUBJECT;
  // List Courses in Taxonomy =
  // /api/nucleus/{version}/taxonomy/subjects/{subject-id}/courses
  public static final String EP_COURSES_LIST_BY_SUBJECT =
    API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + ENTITY_TX_SUBJECT + SEP + COLON + ID_TX_SUBJECT + SEP + ENTITY_TX_COURSE;
  // List Domains in Taxonomy =
  // /api/nucleus/{version}/taxonomy/subjects/{subject-id}/courses/{course-id}/domains
  public static final String EP_DOMAINS_LIST_BY_COURSE =
    API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + ENTITY_TX_SUBJECT + SEP + COLON + ID_TX_SUBJECT + SEP + ENTITY_TX_COURSE + SEP + COLON + ID_TX_COURSE +
      SEP + ENTITY_TX_DOMAIN;
  // List Codes for Domains in Taxonomy =
  // /api/nucleus/{version}/taxonomy/subjects/{subject-id}/courses/{course-id}/domains/{domain-id}/codes
  public static final String EP_STANDARDS_LIST_BY_DOMAINS =
    API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + ENTITY_TX_SUBJECT + SEP + COLON + ID_TX_SUBJECT + SEP + ENTITY_TX_COURSE + SEP + COLON + ID_TX_COURSE +
      SEP + ENTITY_TX_DOMAIN + SEP + COLON + ID_TX_DOMAIN + SEP + ENTITY_TX_CODES;
  // List Standards Frameworks =
  // /api/nucleus/{version}/taxonomy/standard-frameworks
  public static final String EP_STANDARDS_FRAMEWORK_LIST = API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + RES_TX_STANDARD_FRAMEWORK;

  // List Root codes =
  // /api/nucleus/{version}/taxonomy/standard-frameworks/{standard-framework-id}/codes
  public static final String EP_ROOT_CODES_LIST =
    API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + RES_TX_STANDARD_FRAMEWORK + SEP + COLON + ID_TX_STANDARD_FRAMEWORK + SEP + ENTITY_TX_CODES;

  // List Sub codes =
  // /api/nucleus/{version}/taxonomy/standard-frameworks/{standard-framework-id}/codes/{code-id}/codes
  public static final String EP_SUB_CODES_LIST =
    API_BASE_ROUTE + ENTITY_TAXONOMY + SEP + RES_TX_STANDARD_FRAMEWORK + SEP + COLON + ID_TX_STANDARD_FRAMEWORK + SEP + ENTITY_TX_CODES + SEP +
      COLON + ID_TX_CODE + SEP + ENTITY_TX_CODES;

  /*
   * External authorization end point to validate the authorization, if needed.
   * GET /api/nucleus/{version}/authorization
   */
  public static final String EP_EXERNAL_AUTH = API_BASE_ROUTE + OP_AUTH;

  /*
   * STATIC LOOKUPS
   */
  // List Depth of Knowledge = /api/nucleus/{version}/lookup/dok
  public static final String EP_DOK_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_DOK;
  // List Educational Use = /api/nucleus/{version}/lookups/educational-use
  public static final String EP_EDUCATIONAL_USE_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_EDUCATIONAL_USE;
  // List Access Hazards = /api/nucleus/{version}/lookups/access-hazards
  public static final String EP_ACCESS_HAZARDS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_ACCESS_HAZARDS;
  // List Reading Levels = /api/nucleus/{version}/lookups/reading-levels
  public static final String EP_READING_LEVELS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_READING_LEVELS;
  // List Advertisement Status in Content = /api/nucleus/{version}/lookups/ads
  public static final String EP_AD_STATUS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_ADS;
  // List Media Features = /api/nucleus/{version}/lookups/media-features
  public static final String EP_MEDIA_FEATURES_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_MEDIA_FEATURES;
  // List 21st Century Skills =
  // /api/nucleus/{version}/lookups/21-century-skills
  public static final String EP_21_CENTURY_SKILLS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_CEN21SKILLS;
  // List Grades = /api/nucleus/{version}/lookups/grades
  public static final String EP_GRADES_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_GRADES;
  // List moments of learning = /api.nucleus/{version}/lookup/moments
  public static final String EP_MOMENTS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_MOMENTS;
  // List Audience = /api/nucleus/{version}/lookups/audience
  public static final String EP_AUDIENCE_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_AUDIENCE;
  // List Countries = /api/nucleus/lookups/countries?keyword=ind
  public static final String EP_COUNTRIES_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_COUNTRIES;
  // List States = /api/nucleus/lookups/countries/{country-id}/states?keyword=ma
  public static final String EP_STATES_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_COUNTRIES + SEP + COLON + ID_COUNTRY + SEP + RES_STATES;
  // List Schooldistricts = /api/nucleus/lookups/school-districts?keyword=ru
  public static final String EP_SCHOOLDISTRICTS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_SCHOOLDISTRICTS;
  // List Schools = /api/nucleus/lookups/schools?keyword=jo(&school_district_id
  // as optional)
  public static final String EP_SCHOOLS_LIST = API_BASE_ROUTE + OP_LOOKUP + SEP + RES_SCHOOLS;
  /*
   * RESOURCE
   */
  // Get Resource By Id = /api/nucleus/{version}/resources/{resource-id}
  public static final String EP_RESOURCE_GET = API_BASE_ROUTE + ENTITY_RESOURCES + SEP + COLON + ID_RESOURCE;
  // Delete Resource By Id = /api/nucleus/{version}/resources/{resource-id}
  public static final String EP_RESOURCE_DELETE = API_BASE_ROUTE + ENTITY_RESOURCES + SEP + COLON + ID_RESOURCE;
  // Update an existing Resource =
  // /api/nucleus/{version}/resources/{resource-id}
  public static final String EP_RESOURCE_UPDATE = API_BASE_ROUTE + ENTITY_RESOURCES + SEP + COLON + ID_RESOURCE;
  // Create a new Resource = /api/nucleus/{version}/resources
  public static final String EP_RESOURCE_CREATE = API_BASE_ROUTE + ENTITY_RESOURCES;
  /*
   * QUESTION
   */
  // Get Question By Id = /api/nucleus/{version}/questions/{question-id}
  public static final String EP_QUESTION_GET = API_BASE_ROUTE + ENTITY_QUESTIONS + SEP + COLON + ID_QUESTION;
  // Delete question = /api/nucleus/{version}/questions/{question-id}
  public static final String EP_QUESTION_DELETE = API_BASE_ROUTE + ENTITY_QUESTIONS + SEP + COLON + ID_QUESTION;
  // Update an existing Question =
  // /api/nucleus/{version}/questions/{question-id}
  public static final String EP_QUESTION_UPDATE = API_BASE_ROUTE + ENTITY_QUESTIONS + SEP + COLON + ID_QUESTION;
  // Create a new Question = /api/nucleus/{version}/questions
  public static final String EP_QUESTION_CREATE = API_BASE_ROUTE + ENTITY_QUESTIONS;
  /*
   * ASSESSMENT
   */
  // Get an Assessment by Id =
  // /api/nucleus/{version}/assessments/{assessment-id}
  public static final String EP_ASSESSMENT_GET = API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT;
  // Update an Existing Assessment =
  // /api/nucleus/{version}/assessments/{assessment-id}
  public static final String EP_ASSESSMENT_UPDATE = API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT;
  // Delete an Assessment = /api/nucleus/{version}/assessments/{assessment-id}
  public static final String EP_ASSESSMENT_DELETE = API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT;
  // Add an Existing Unassigned Question to Assessment =
  // /api/nucleus/{version}/assessments/{assessment-id}/questions
  public static final String EP_ASSESSMENT_QUESTION_ADD = API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT + SEP + ENTITY_QUESTIONS;
  // Reorder Questions in Assessments =
  // /api/nucleus/{version}/assessments/{assessment-id}/questions/order
  public static final String EP_ASSESSMENT_QUESTION_REORDER =
    API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT + SEP + ENTITY_QUESTIONS + SEP + OP_ORDER;
  // Update the List of Collaborators for an Assessment =
  // /api/nucleus/{version}/assessments/{assessment-id}/collaborators
  public static final String EP_ASSESSMENT_COLLABORATORS_UPDATE =
    API_BASE_ROUTE + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT + SEP + ENTITY_COLLABORATORS;
  // Create a New Assessment = /api/nucleus/{version}/assessments
  public static final String EP_ASSESSMENT_CREATE = API_BASE_ROUTE + ENTITY_ASSESSMENTS;
  /*
   * COLLECTION
   */
  // Get a Collection based on Id =
  // /api/nucleus/{version}/collections/{collection-id}
  public static final String EP_COLLECTION_GET = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION;
  // Update an Existing Collection =
  // /api/nucleus/{version}/collections/{collection-id}
  public static final String EP_COLLECTION_UPDATE = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION;
  // Delete a Collection = /api/nucleus/{version}/collections/{collection-id}
  public static final String EP_COLLECTION_DELETE = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION;
  // Add an existing Question to Collection =
  // /api/nucleus/{version}/collections/{collection-id}/questions
  public static final String EP_COLLECTION_QUESTION_ADD = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION + SEP + ENTITY_QUESTIONS;
  // Add an existing Resource to Collection =
  // /api/nucleus/{version}/collections/{collection-id}/resources
  public static final String EP_COLLECTION_RESOURCE_ADD = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION + SEP + ENTITY_RESOURCES;
  // Reorder Resources/Questions in Existing Collection =
  // /api/nucleus/{version}/collections/{collection-id}/order
  public static final String EP_COLLECTION_CONTENT_REORDER = API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION + SEP + OP_ORDER;
  // Update the List of Collaborators for a Collection =
  // /api/nucleus/{version}/collections/{collection-id}/collaborators
  public static final String EP_COLLECTION_COLLABORATORS_UPDATE =
    API_BASE_ROUTE + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION + SEP + ENTITY_COLLABORATORS;
  // Create a New Collection = /api/nucleus/{version}/collections
  public static final String EP_COLLECTION_CREATE = API_BASE_ROUTE + ENTITY_COLLECTIONS;
  /*
   * COURSES UNITS LESSONS
   */
  // Create a New Course = /api/nucleus/{version}/courses
  public static final String EP_COURSE_CREATE = API_BASE_ROUTE + ENTITY_COURSES;

  // Update Existing Course = /api/nucleus/{version}/courses/{course-id}
  public static final String EP_COURSE_UPDATE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE;
  // Fetch a Course by Id = /api/nucleus/{version}/courses/{course-id}
  public static final String EP_COURSE_GET = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE;
  // Delete Course = /api/nucleus/{version}/courses/{course-id}
  public static final String EP_COURSE_DELETE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE;
  // Reorder Units in Existing Course =
  // /api/nucleus/{version}/courses/{course-id}/order
  public static final String EP_COURSE_CONTENT_REORDER = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + OP_ORDER;
  // Update the List of Collaborators for a Course =
  // /api/nucleus/{version}/courses/{course-id}/collaborators
  public static final String EP_COURSE_COLLABORATOR_UPDATE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_COLLABORATORS;
  // Move an existing unit to existing course
  // PUT /api/nucleus/{version}/courses/{course-id}/units
  public static final String EP_COURSE_MOVE_UNIT = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS;

  // Create a new Unit = /api/nucleus/{version}/courses/{course-id}/units
  public static final String EP_UNIT_CREATE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS;
  // Update Existing Unit =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}
  public static final String EP_UNIT_UPDATE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT;
  // Fetch a Unit by Id =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}
  public static final String EP_UNIT_GET = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT;
  // Delete Unit = /api/nucleus/{version}/courses/{course-id}/units/{unit-id}
  public static final String EP_UNIT_DELETE = API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT;
  // Reorder Lessons in Existing Unit =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/order/
  public static final String EP_UNIT_CONTENT_REORDER =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + OP_ORDER;
  // Move an existing lesson to existing Course/Unit
  // PUT /api/nucleus/v1/courses/:courseId/units/:unitId/lessons
  public static final String EP_UNIT_MOVE_LESSON =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS;

  // Create a new Lesson =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/lessons
  public static final String EP_LESSON_CREATE =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS;
  // Update Existing Lesson =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/lessons/{lesson-id}
  public static final String EP_LESSON_UPDATE =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS + SEP + COLON +
      ID_LESSON;
  // Fetch a Lesson by Id =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/lessons/{lesson-id}
  public static final String EP_LESSON_GET =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS + SEP + COLON +
      ID_LESSON;
  // Delete Lesson =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/lessons/{lesson-id}
  public static final String EP_LESSON_DELETE =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS + SEP + COLON +
      ID_LESSON;
  // Reorder Collections/Assessments in Existing Lesson =
  // /api/nucleus/{version}/courses/{course-id}/units/{unit-id}/lessons/{lesson-id}/order/
  public static final String EP_LESSON_CONTENT_REORDER =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS + SEP + COLON +
      ID_LESSON + SEP + OP_ORDER;
  // Move existing collection/assessment into existing CUL
  // /api/nucleus/v1/courses/:courseId/units/:unitId/lessons/:lessonId/collections
  public static final String EP_LESSON_MOVE_COLLECTION =
    API_BASE_ROUTE + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP + ENTITY_LESSONS + SEP + COLON +
      ID_LESSON + SEP + ENTITY_COLLECTIONS;

  /*
   * CLASSES
   */
  // Create a class = /api/nucleus/{version}/classes
  public static final String EP_CLASS_CREATE = API_BASE_ROUTE + ENTITY_CLASSES;
  // Delete a Class = /api/nucleus/{version}/classes/{class-id}
  public static final String EP_CLASS_DELETE = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS;
  // Update a Class = /api/nucleus/{version}/classes/{class-id}
  public static final String EP_CLASS_UPDATE = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS;
  // Retrieve a specific Class by the Class Code =
  // /api/nucleus/{version}/classes/{classId}
  public static final String EP_CLASS_GET = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS;
  // List members of a Class (joined or pending) =
  // /api/nucleus/{version}/classes/{class-id}/members
  public static final String EP_CLASS_MEMBERS_GET = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + OP_MEMBER;
  // Update the List of Collaborators for a Class
  // /api/nucleus/{version}/classes/{class-id}/collaborators
  public static final String EP_CLASS_COLLABORATOR_UPDATE = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + ENTITY_COLLABORATORS;
  // Fetch All Classes - for User (active and archived along with course
  // association information) =
  // /api/nucleus/{version}/classes
  public static final String EP_CLASS_LIST = API_BASE_ROUTE + ENTITY_CLASSES;
  // Fetch All Classes assigned to a specific Course =
  // /api/nucleus/{version}/classes/courses/{course-id}
  public static final String EP_CLASSES_FOR_COURSE = API_BASE_ROUTE + ENTITY_CLASSES + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE;
  // Join a Class = /api/nucleus/{version}/classes/{class-id}/members
  public static final String EP_CLASS_JOIN = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + OP_MEMBER;
  // Invite to a Class = /api/nucleus/{version}/classes/{class-id}/invites
  public static final String EP_CLASS_JOIN_INVITE = API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + OP_INVITE;
  // Associate a Course with the Class =
  // /api/nucleus/{version}/classes/{class-id}/courses/{courseId} with an empty
  // payload
  public static final String EP_CLASS_COURSE_ATTACH =
    API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE;

  // FIXME: 7/2/16 Following needs to be reviewed and confirmed before
  // implementing
  // Fetch published status for content of a Course associated with a specific
  // Class = /api/nucleus/{version}/classes/{class-id}/courses/{course-id}
  public static final String EP_CLASS_COURSE_CONTENT_VISIBILITY =
    API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE;
  // Fetch All Classes for which the specified Content is not Visible =
  // /api/nucleus/{version}/classes?content-id={content-id}
  public static final String EP_CLASSES_CONTENT_IS_INVISIBLE = API_BASE_ROUTE + ENTITY_CLASSES;
  // Publish a specific Collection/Assessment to a multiple Classes =
  // /api/nucleus/{version}/classes
  public static final String EP_CLASSES_CONTENT_PUBLISH = API_BASE_ROUTE + ENTITY_CLASSES;
  // Publish content of a Course to a specific Class =
  // /api/nucleus/{version}/classes/{class-id}/courses/{course-id}
  public static final String EP_CLASS_CONTENT_PUBLISH =
    API_BASE_ROUTE + ENTITY_CLASSES + SEP + COLON + ID_CLASS + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE;

  // COPIER
  public static final String EP_RESOURCE_COPY = API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_RESOURCES + SEP + COLON + ID_RESOURCE;
  public static final String EP_QUESTION_COPY = API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_QUESTIONS + SEP + COLON + ID_QUESTION;
  public static final String EP_COLLECTION_COPY = API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_COLLECTIONS + SEP + COLON + ID_COLLECTION;
  public static final String EP_ASSESSMENT_COPY = API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_ASSESSMENTS + SEP + COLON + ID_ASSESSMENT;
  public static final String EP_COURSE_COPY = API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE;

  public static final String EP_UNIT_COPY =
    API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT;
  public static final String EP_LESSON_COPY =
    API_BASE_ROUTE + ENTITY_COPIER + SEP + ENTITY_COURSES + SEP + COLON + ID_COURSE + SEP + ENTITY_UNITS + SEP + COLON + ID_UNIT + SEP +
      ENTITY_LESSONS + SEP + COLON + ID_LESSON;

  //PROFILES
  // /api/nucleus/{version}/profiles/{user-id}/courses
  public static final String EP_PROFILE_COURSE_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_COURSES;
  public static final String EP_PROFILE_COLLECTION_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_COLLECTIONS;
  public static final String EP_PROFILE_ASSESSMENT_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_ASSESSMENTS;
  public static final String EP_PROFILE_RESOURCE_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_RESOURCES;
  public static final String EP_PROFILE_QUESTION_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_QUESTIONS;
  public static final String EP_PROFILE_DEMOGRAPHIC_GET = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + OP_DEMOGRAPHICS;
  public static final String EP_PROFILE_FOLLOW = API_BASE_ROUTE + ENTITY_PROFILES + SEP + OP_FOLLOW;
  public static final String EP_PROFILE_UNFOLLOW = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + OP_UNFOLLOW;
  public static final String EP_PROFILE_FOLLOWERS_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + OP_FOLLOWERS;
  public static final String EP_PROFILE_FOLLOWINGS_LIST = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + OP_FOLLOWINGS;
  public static final String EP_PROFILE_COLLECTION_SEARCH = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_COLLECTIONS + SEP + OP_SEARCH;
  public static final String EP_PROFILE_ASSESSMENT_SEARCH = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_ASSESSMENTS + SEP + OP_SEARCH;
  public static final String EP_PROFILE_RESOURCE_SEARCH = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_RESOURCES + SEP + OP_SEARCH;
  public static final String EP_PROFILE_QUESTION_SEARCH = API_BASE_ROUTE + ENTITY_PROFILES + SEP + COLON + ID_USER + SEP + ENTITY_QUESTIONS  + SEP + OP_SEARCH;

  private RouteConstants() {
    throw new AssertionError();
  }

}
