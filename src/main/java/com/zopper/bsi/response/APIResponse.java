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
	
	private Integer st;
	private ErrorReponse er;
	private Object rs;
	private String msg;
	
	public APIResponse() {
	}
	
	public APIResponse(ErrorReponse er) {
		this.er = er;
		this.st = AppConstants.API.STATUS.ERROR.value;
	}
	
	public APIResponse(Object rs) {
		this.rs = rs;
		this.st = AppConstants.API.STATUS.SUCCESS.value;
	}
	
	public APIResponse(Object rs, AppConstants.API.STATUS status, String msg) {
		this.rs = rs;
		this.st = status.value;
		this.msg =  msg;
	}

	public APIResponse(Object rs, String msg) {
		this.rs = rs;
		this.st = AppConstants.API.STATUS.SUCCESS.value;
		this.msg =  msg;
	}

	public Integer getSt() {
		return st;
	}
	public void setSt(Integer st) {
		this.st = st;
	}
	public ErrorReponse getEr() {
		return er;
	}
	public void setEr(ErrorReponse er) {
		this.er = er;
	}
	public Object getRs() {
		return rs;
	}
	public void setRs(Object rs) {
		this.rs = rs;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "APIResponse [st=" + st + ", er=" + er + ", rs=" + rs + ", msg="
				+ msg + ", getSt()=" + getSt() + ", getEr()=" + getEr()
				+ ", getRs()=" + getRs() + ", getMsg()=" + getMsg()
				+ ", toJson()=" + toJson() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
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
