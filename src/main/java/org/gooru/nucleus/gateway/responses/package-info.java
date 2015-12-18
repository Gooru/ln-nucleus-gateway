package org.gooru.nucleus.gateway.responses;

/**
 * This package contains the machinery required to deal with the responses. There are two different kind of responses:
 * 1. The responses which are coming from Message Bus which are to be used to continue the flow of program
 * 2. The responses which are coming from Message Bus which are to be used to send out HTTP response
 * The message bus response is always going to contain a header named MessageConstants.MSG_OP_STATUS. The value of
 * MessageConstants.MSG_OP_STATUS_SUCCESS would imply that the operation is successful. Else the operation has failed.
 * 
 * The individual response type formats should be present in there own package-info file.
 * 
 */