package org.gooru.nucleus.gateway.responses.auth;

/**
 * This package contains handlers to handle the response coming onto message bus from auth module.
 * The auth module may return success in which case the request is sent downstream to get handled
 * or it may return a failure in which case the response will be returned to client about being
 * unauthorized. 
 * The auth response, if failed would either not contain message success header or it will contain
 * header without success value. If successful, the response should contain userId and user preferences
 * of taxonomy. The user id, if anonymous is used to filter out any write operation, which is PUT, POST 
 * etc. The anonymous user is allowed to do GET operations. 
 * In future, there is a possibility that we may provide a registry here which can map permissibility 
 * of operation with respect to token coming auth module.
 */