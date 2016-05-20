package com.zopper.bsi.enums;

public enum RequestType {
	
	DEMO(1, "Demo"), 
	INSTALLATION(2, "Installation"), 
	REPAIR(3, "Repair"), 
	REPLACE(4, "Replace");
	
	private RequestType(int key, String value) {
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
	
	public RequestType getByKey(int key) {
		for(RequestType requestType: values()) {
			if(requestType.getKey() == key) {
				return requestType;
			}
		}
		return null;
	}

}
