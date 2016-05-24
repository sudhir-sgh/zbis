package com.zopper.bsi.enums;
/**
 * Created by sudhir on 24/5/16.
 */
public enum RequestStatus {

	REQUEST_CREATED(1, "New request"),
	PENDING_INFORMATION(2, "More information required"),
	PROCESSING(4, "Processing"),
	CANCELLED(5, "Request Cancelled"),
	CLOSED(6, "Request Closed"),
	RE_OPENED(7, "Request reopened");

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
