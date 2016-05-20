package com.zopper.bsi.enums;

public enum RequestSource {
	
	MOBILE(1, "Mobile"), USD(2, "USD");
	
	private RequestSource(int key, String value) {
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
	
	public RequestSource getByKey(int key) {
		for(RequestSource requestSource: values()) {
			if(requestSource.getKey() == key) {
				return requestSource;
			}
		}
		return null;
	}

}
