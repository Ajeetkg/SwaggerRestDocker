package com.illumina.util;

/**
 * Created by agupta2 on 10/30/15.
 */
public class Constants {
    public static final String ONT = "ont";
    public static final String ONTOLOGY = "ontology";
    public static final String SLASH = "/";
    public static final String COMMA = ",";

    public static final String GET="GET";
    public static final String POST="POST";
    public static final String PUT="PUT";
    public static final String DELETE="DELETE";

    public static class Boolean
    {

        public static final String TRUE = "true";

        public static final String FALSE = "false";
    }

    public static class ServiceResponse
    {
        public static final String STATUS = "status";

        public static final String SUCCESS_CODE = "200 OK";

        public static final String BAD_REQUEST = "400 Bad Request";

        public static final String INTERNAL_SERVER_ERROR = "500 Internal Server Error";

        public static final String DATA_SYNC_ERROR = "501 Data Sync Error";

        public static final String SUCCESSFUL_CREATION_CODE = "201 Created";

        public static final String RESOURCE_NOT_FOUND_CODE = "404 Not Found";

        public static final String OBJECT_NOT_FOUND_CODE = "404 Requested Object Not Available";

        public static final String OBJECT_ALREADY_PRESENT_CODE = "409 Conflict. Requested Object is already Available";

        public static final String NO_CONTENT_CODE = "204 No Content";

        public static final String ERROR_CODE = "errorCode";

        public static final String VALIDATION_ERRORS = "validationErrors";

        public static final String MESSAGE = "message";

        public static final String STACKTRACE = "stacktrace";

        public static final String LIST = "list";

        public static final String ENTITY = "entity";

        public static final String UN_AUTHORIZED = "401 Unauthorized";

        public static final String FORBIDDEN_REQUEST = "403 Forbidden. Not an authorized operation";

        public static final String NOT_ACCEPTABLE = "406 Not Acceptable";

        public static final String PRE_CONDITION_FAILED = "412 Precondition Failed";

    }
}
