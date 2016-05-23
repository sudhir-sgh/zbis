package com.zopper.bsi.config.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sudhir on 18/9/15.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class APIException extends Exception {

    private String code;

    private String message;

    private String stacktrace;

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public APIException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public APIException(String code, String message, String stacktrace) {
        this(code,message);
        this.stacktrace = stacktrace;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @JsonIgnore
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @JsonIgnore
    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

}
