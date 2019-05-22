package org.gooru.nucleus.gateway.routes;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashish.
 */
class RouteOfflineActivityConfigurator implements RouteConfigurator, PathParamCreator {

  private static final String OA_ID = ":oaId";
  private static final String OA_TASK_ID = ":oaTaskId";
  private static final String OA_REF_ID = ":oaRefId";
  private static final String OA_RUBRIC_ID = ":oaRubricId";
  private static final String OA_TASK_SUBMISSION_ID = ":oaTaskSubmissionId";

  private static final String MSG_OP_OA_GET_SUMMARY = "oa.get.summary";
  private static final String MSG_OP_OA_GET_DETAIL = "oa.get.detail";
  private static final String MSG_OP_OA_CREATE = "oa.create";
  private static final String MSG_OP_OA_UPDATE = "oa.update";
  private static final String MSG_OP_OA_DELETE = "oa.delete";
  private static final String MSG_OP_OA_COLLABORATOR_UPDATE = "oa.collaborator.update";
  private static final String MSG_OP_OA_TASK_CREATE = "oa.task.create";
  private static final String MSG_OP_OA_TASK_DELETE = "oa.task.delete";
  private static final String MSG_OP_OA_TASK_UPDATE = "oa.task.update";
  private static final String MSG_OP_OA_TASK_SUBMISSION_CREATE = "oa.task.submission.create";
  private static final String MSG_OP_OA_TASK_SUBMISSION_DELETE = "oa.task.submission.delete";
  private static final String MSG_OP_OA_REF_DELETE = "oa.ref.delete";
  private static final String MSG_OP_OA_REF_CREATE = "oa.ref.create";
  private static final String MSG_OP_OA_TEACHER_RUBRIC_ASSOCIATE = "oa.rubric.teacher.add";
  private static final String MSG_OP_OA_STUDENT_RUBRIC_ASSOCIATE = "oa.rubric.student.add";


  private static final String EP_OA_CREATE = RouteConstants.API_BASE_ROUTE + "oa";
  private static final String EP_OA_UPDATE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID;
  private static final String EP_OA_COLLABORATORS_UPDATE =
      RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID + "/collaborators";
  private static final String EP_OA_DELETE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID;
  private static final String EP_OA_FETCH_SUMMARY = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/summary";
  private static final String EP_OA_FETCH_DETAIL = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/detail";
  private static final String EP_OA_TASK_CREATE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/tasks";
  private static final String EP_OA_TASK_DELETE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/tasks/" + OA_TASK_ID;
  private static final String EP_OA_TASK_UPDATE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/tasks/" + OA_TASK_ID;
  private static final String EP_OA_TASK_SUBMISSION_CREATE =
      RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
          + "/tasks/" + OA_TASK_ID + "/submissions";
  private static final String EP_OA_TASK_SUBMISSION_DELETE =
      RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
          + "/tasks/" + OA_TASK_ID + "/submissions/" + OA_TASK_SUBMISSION_ID;
  private static final String EP_OA_REFERENCE_CREATE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/references";
  private static final String EP_OA_REFERENCE_DELETE = RouteConstants.API_BASE_ROUTE + "oa/" + OA_ID
      + "/references/" + OA_REF_ID;
  private static final String EP_OA_TEACHER_RUBRIC_ASSOCIATE = RouteConstants.API_BASE_ROUTE + "oa/"
      + OA_ID + "/rubric/" + OA_RUBRIC_ID + "/teacher";
  private static final String EP_OA_STUDENT_RUBRIC_ASSOCIATE = RouteConstants.API_BASE_ROUTE + "oa/"
      + OA_ID + "/rubric/" + OA_RUBRIC_ID + "/student";


  private static final Logger LOGGER = LoggerFactory
      .getLogger(RouteOfflineActivityConfigurator.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {

    final EventBus eventBus = vertx.eventBus();
    final long eventBusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L);
    final RequestHandlerMessageBusContext context = new RequestHandlerMessageBusContext(eventBus,
        MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, eventBusTimeout, LOGGER);

    router.post(EP_OA_CREATE).handler(new RequestHandler(MSG_OP_OA_CREATE, context, this));
    router.put(EP_OA_UPDATE).handler(new RequestHandler(MSG_OP_OA_UPDATE, context, this));
    router.get(EP_OA_FETCH_SUMMARY)
        .handler(new RequestHandler(MSG_OP_OA_GET_SUMMARY, context, this));
    router.get(EP_OA_FETCH_DETAIL).handler(new RequestHandler(MSG_OP_OA_GET_DETAIL, context, this));
    router.put(EP_OA_COLLABORATORS_UPDATE)
        .handler(new RequestHandler(MSG_OP_OA_COLLABORATOR_UPDATE, context, this));
    router.delete(EP_OA_DELETE).handler(new RequestHandler(MSG_OP_OA_DELETE, context, this));
    router.post(EP_OA_TASK_CREATE)
        .handler(new RequestHandler(MSG_OP_OA_TASK_CREATE, context, this));
    router.put(EP_OA_TASK_UPDATE).handler(new RequestHandler(MSG_OP_OA_TASK_UPDATE, context, this));
    router.delete(EP_OA_TASK_DELETE)
        .handler(new RequestHandler(MSG_OP_OA_TASK_DELETE, context, this));
    router.post(EP_OA_TASK_SUBMISSION_CREATE)
        .handler(new RequestHandler(MSG_OP_OA_TASK_SUBMISSION_CREATE, context, this));
    router.delete(EP_OA_TASK_SUBMISSION_DELETE)
        .handler(new RequestHandler(MSG_OP_OA_TASK_SUBMISSION_DELETE, context, this));
    router.post(EP_OA_REFERENCE_CREATE)
        .handler(new RequestHandler(MSG_OP_OA_REF_CREATE, context, this));
    router.delete(EP_OA_REFERENCE_DELETE)
        .handler(new RequestHandler(MSG_OP_OA_REF_DELETE, context, this));
    router.put(EP_OA_TEACHER_RUBRIC_ASSOCIATE)
        .handler(new RequestHandler(MSG_OP_OA_TEACHER_RUBRIC_ASSOCIATE, context, this));
    router.put(EP_OA_STUDENT_RUBRIC_ASSOCIATE)
        .handler(new RequestHandler(MSG_OP_OA_STUDENT_RUBRIC_ASSOCIATE, context, this));

  }

  @Override
  public Map<String, String> getHeadersFromPathParams(RoutingContext routingContext, String op) {
    switch (op) {
      case MSG_OP_OA_CREATE:
        return Collections.emptyMap();
      case MSG_OP_OA_UPDATE:
      case MSG_OP_OA_GET_SUMMARY:
      case MSG_OP_OA_GET_DETAIL:
      case MSG_OP_OA_COLLABORATOR_UPDATE:
      case MSG_OP_OA_DELETE:
      case MSG_OP_OA_TASK_CREATE:
      case MSG_OP_OA_REF_CREATE:
        return headersWithOA(routingContext);
      case MSG_OP_OA_TASK_UPDATE:
      case MSG_OP_OA_TASK_DELETE:
      case MSG_OP_OA_TASK_SUBMISSION_CREATE:
        return headersWithOaAndTask(routingContext);
      case MSG_OP_OA_TASK_SUBMISSION_DELETE:
        return headersWithOaTaskSubmission(routingContext);
      case MSG_OP_OA_REF_DELETE:
        return headersWithOAAndRef(routingContext);
      case MSG_OP_OA_TEACHER_RUBRIC_ASSOCIATE:
      case MSG_OP_OA_STUDENT_RUBRIC_ASSOCIATE:
        return headersWithOAAndRubric(routingContext);
    }
    return Collections.emptyMap();
  }

  private Map<String, String> headersWithOaTaskSubmission(RoutingContext routingContext) {
    Map<String, String> result = new HashMap<>(1);
    String oaId = routingContext.request().getParam("oaId");
    String oaTaskId = routingContext.request().getParam("oaTaskId");
    String oaTaskSubmissionId = routingContext.request().getParam("oaTaskSubmissionId");
    result.put("oaId", oaId);
    result.put("oaTaskId", oaTaskId);
    result.put("oaTaskSubmissionId", oaTaskSubmissionId);
    return result;
  }

  private Map<String, String> headersWithOAAndRubric(RoutingContext routingContext) {
    Map<String, String> result = new HashMap<>(2);
    String oaId = routingContext.request().getParam("oaId");
    String rubricId = routingContext.request().getParam("oaRubricId");
    result.put("oaId", oaId);
    result.put("oaRubricId", rubricId);
    return result;
  }

  private Map<String, String> headersWithOAAndRef(RoutingContext routingContext) {
    Map<String, String> result = new HashMap<>(2);
    String oaId = routingContext.request().getParam("oaId");
    String oaRefId = routingContext.request().getParam("oaRefId");
    result.put("oaId", oaId);
    result.put("oaRefId", oaRefId);
    return result;
  }

  private Map<String, String> headersWithOaAndTask(RoutingContext routingContext) {
    Map<String, String> result = new HashMap<>(1);
    String oaId = routingContext.request().getParam("oaId");
    String oaTaskId = routingContext.request().getParam("oaTaskId");
    result.put("oaId", oaId);
    result.put("oaTaskId", oaTaskId);
    return result;
  }

  private Map<String, String> headersWithOA(RoutingContext routingContext) {
    Map<String, String> result = new HashMap<>(1);
    String oaId = routingContext.request().getParam("oaId");
    result.put("oaId", oaId);
    return result;
  }
}
