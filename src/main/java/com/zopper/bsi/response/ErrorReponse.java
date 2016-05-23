package com.zopper.bsi.response;

/**
 * Created by sudhir on 23/5/16.
 */
public class ErrorReponse {

	private String code;

	private String message;

	private String stacktrace;

	private Object errors;	// list of error object

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public ErrorReponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorReponse(String code, Object errorObj) {
		super();
		this.code = code;
		this.errors = errorObj;
	}

	public ErrorReponse(String code, String message, String stacktrace) {
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

}
