package org.gooru.nucleus.gateway.routes;

import org.gooru.nucleus.gateway.constants.ConfigConstants;
import org.gooru.nucleus.gateway.constants.MessageConstants;
import org.gooru.nucleus.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.gateway.constants.RouteConstants;
import org.gooru.nucleus.gateway.routes.utils.DeliveryOptionsBuilder;
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
        router.get(RouteConstants.EP_CODE).handler(this::getCode);
        router.post(RouteConstants.EP_CROSSWALK_CODES_FW).handler(this::getCrosswalkFWCodes);
        router.post(RouteConstants.EP_CROSSWALK_CODES_GDFW).handler(this::getCrosswalkGDFWCodes);
        router.get(RouteConstants.EP_STANDARD_FW_LIST).handler(this::getTaxonomyFrameworks);
        router.get(RouteConstants.EP_LEARNER_CLASSIFICATION_LIST).handler(this::getTaxonomyLearnerClassification);
    }

    private void getSubjects(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_SUBJECTS_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getCourses(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final String standardFrameworkId = routingContext.request().getParam(RouteConstants.ID_TX_STANDARD_FRAMEWORK);
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_COURSES_GET)
                .addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
                .addHeader(RouteConstants.ID_TX_STANDARD_FRAMEWORK, standardFrameworkId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getDomains(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
        final String standardFrameworkId = routingContext.request().getParam(RouteConstants.ID_TX_STANDARD_FRAMEWORK);
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_DOMAINS_GET)
                .addHeader(RouteConstants.ID_TX_COURSE, courseId).addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
                .addHeader(RouteConstants.ID_TX_STANDARD_FRAMEWORK, standardFrameworkId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getDomainCodes(RoutingContext routingContext) {
        final String subjectId = routingContext.request().getParam(RouteConstants.ID_TX_SUBJECT);
        final String courseId = routingContext.request().getParam(RouteConstants.ID_TX_COURSE);
        final String domainId = routingContext.request().getParam(RouteConstants.ID_TX_DOMAIN);
        final String standardFrameworkId = routingContext.request().getParam(RouteConstants.ID_TX_STANDARD_FRAMEWORK);
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_DOMAIN_CODES_GET)
                .addHeader(RouteConstants.ID_TX_DOMAIN, domainId).addHeader(RouteConstants.ID_TX_SUBJECT, subjectId)
                .addHeader(RouteConstants.ID_TX_COURSE, courseId)
                .addHeader(RouteConstants.ID_TX_STANDARD_FRAMEWORK, standardFrameworkId);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }

    private void getCode(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_CODES_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
    
    private void getCrosswalkFWCodes(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_CROSSWALK_FW_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
    
    private void getCrosswalkGDFWCodes(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_CROSSWALK_GDFW_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
    
    private void getTaxonomyFrameworks(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_FRAMEWORKS_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
    
    private void getTaxonomyLearnerClassification(RoutingContext routingContext) {
        final DeliveryOptions options =
            DeliveryOptionsBuilder.buildWithApiVersion(routingContext).setSendTimeout(mbusTimeout)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_TAXONOMY_LEARNER_CLASSIFICATIONS_GET);
        eb.send(MessagebusEndpoints.MBEP_TAXONOMY, new RouteRequestUtility().getBodyForMessage(routingContext), options,
            reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));
    }
}
