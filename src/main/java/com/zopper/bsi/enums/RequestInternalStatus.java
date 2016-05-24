package com.zopper.bsi.enums;
/**
 * Created by sudhir on 24/5/16.
 */
public enum RequestInternalStatus {

	REQUEST_CREATED(1, "Request create from customer"),
	REQUEST_ACCEPTED(2, "Service request accepted"),
	REQUEST_CANCELLED(3, "Request Cancelled By Zopper"),
	REQUEST_CANCELLED_BY_USER(3, "Request Cancelled By User"),
	REQUEST_INITIATED_TO_BRAND(4, "Service request initiated"),
	PROCESSING_ACCEPTED_BY_BRAND(5, "Service request processing"),
	PROCESSING_DENIED_BY_BRAND(6, "Service request denied"),
	PROCESSING_COMPLETED_BY_BRAND(7, "Service completed"),
	CLOSED(8, "Request Closed"),
	RE_OPENED(9, "Request reopened");

	private RequestInternalStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	private int key;

	private String value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public RequestInternalStatus getByKey(int key) {
		for(RequestInternalStatus requestType: values()) {
			if(requestType.getKey() == key) {
				return requestType;
			}
		}
		return null;
	}

}
