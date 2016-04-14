package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

class RouteTaxonomyConfigurator implements RouteConfigurator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteTaxonomyConfigurator.class);
    private EventBus eb = null;
    private long mbusTimeout = 30000L;

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
        eb = vertx.eventBus();
        router.get(RouteConstants.EP_SUBJECTS_LIST).handler(this::getSubjects);
        router.get(RouteConstants.EP_COURSES_LIST_BY_SUBJECT).handler(this::getCourses);
        router.get(RouteConstants.EP_DOMAINS_LIST_BY_COURSE).handler(this::getDomains);
        router.get(RouteConstants.EP_STANDARDS_LIST_BY_DOMAINS).handler(this::getDomainCodes);
        router.get(RouteConstants.EP_STANDARDS_FRAMEWORK_LIST).handler(this::getStandardFrameworks);
        router.get(RouteConstants.EP_ROOT_CODES_LIST).handler(this::getTaxonomyRootCodes);
        router.get(RouteConstants.EP_SUB_CODES_LIST).handler(this::getTaxonomySubtreeCodes);
    }

    private void getSubjects(RoutingContext routingContext) {
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_SUBJECTS_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getCourses(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_COURSES_GET)
            .addHeader(RouteConstants.ID_TX_SUBJECT, subjectId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getDomains(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_DOMAINS_GET)
            .addHeader(RouteConstants.ID_TX_COURSE, courseId).addHeader(RouteConstants.ID_TX_SUBJECT, subjectId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getDomainCodes(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
        final String domainId = routingContext.request().getParam(RouteConstants.ID_TX_DOMAIN);
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_DOMAIN_CODES_GET)
            .addHeader(RouteConstants.ID_TX_DOMAIN, domainId).addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
            .addHeader(RouteConstants.ID_TX_COURSE, courseId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getStandardFrameworks(RoutingContext routingContext) {
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_STANDARD_FRAMEWORKS_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getTaxonomyRootCodes(RoutingContext routingContext) {
        final String standardFrameworkId = routingContext.request().getParam(RouteConstants.ID_TX_STANDARD_FRAMEWORK);
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_ROOT_CODES_GET)
            .addHeader(RouteConstants.ID_TX_STANDARD_FRAMEWORK, standardFrameworkId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getTaxonomySubtreeCodes(RoutingContext routingContext) {
        final String standardFrameworkId = routingContext.request().getParam(RouteConstants.ID_TX_STANDARD_FRAMEWORK);
        final String codeId = routingContext.request().getParam(RouteConstants.ID_TX_CODE);
        final DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout)
            .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_SUBTREE_CODES_GET)
            .addHeader(RouteConstants.ID_TX_CODE, codeId)
            .addHeader(RouteConstants.ID_TX_STANDARD_FRAMEWORK, standardFrameworkId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
}
