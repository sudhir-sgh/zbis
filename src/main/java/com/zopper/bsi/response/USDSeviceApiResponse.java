package com.zopper.bsi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by sudhir on 20/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class USDSeviceApiResponse {

    String exception;
    String message;
    Object errors;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("exception", exception)
                .append("message", message)
                .append("errors", errors)
                .toString();
    }
}
