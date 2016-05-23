package com.zopper.bsi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zopper.bsi.utils.AppConstants;

import java.lang.reflect.Modifier;

/**
 * Created by sudhir on 23/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class APIResponse {
	
	private Integer status;
	private String message;
	private Object response;
	private ErrorReponse error;
	
	public APIResponse() {
	}
	
	public APIResponse(ErrorReponse error) {
		this.error = error;
		this.status = AppConstants.API.STATUS.ERROR.value;
	}
	
	public APIResponse(Object response) {
		this.response = response;
		this.status = AppConstants.API.STATUS.SUCCESS.value;
	}
	
	public APIResponse(Object response, AppConstants.API.STATUS status, String message) {
		this.response = response;
		this.status = status.value;
		this.message =  message;
	}

	public APIResponse(Object response, String message) {
		this.response = response;
		this.status = AppConstants.API.STATUS.SUCCESS.value;
		this.message =  message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public ErrorReponse getError() {
		return error;
	}

	public void setError(ErrorReponse error) {
		this.error = error;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("APIResponse [status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", response=");
		builder.append(response);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public String toJsonIncludeTransient() {
		Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC).create();
		return gson.toJson(this);
	}

}
