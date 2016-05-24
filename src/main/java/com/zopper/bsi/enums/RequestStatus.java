package com.zopper.bsi.enums;
/**
 * Created by sudhir on 24/5/16.
 */
public enum RequestStatus {

	REQUEST_CREATED(1, "Request create from customer"),
	REQUEST_ACCEPTED(2, "Service request accepted"),
	REQUEST_CANCELLED(3, "Request failed"),
	REQUEST_INITIATED_TO_BRAND(4, "Service request initiated"),
	PROCESSING_ACCEPTED_BY_BRAND(5, "Service request processing"),
	PROCESSING_DENIED_BY_BRAND(6, "Service request denied"),
	PROCESSING_COMPLETED_BY_BRAND(5, "Service completed"),
	CLOSED(5, "Request Closed"),
	RE_OPENED(5, "Request reopened");

	private RequestStatus(int key, String value) {
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
	
	public RequestStatus getByKey(int key) {
		for(RequestStatus requestType: values()) {
			if(requestType.getKey() == key) {
				return requestType;
			}
		}
		return null;
	}

}
