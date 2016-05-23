package com.zopper.bsi.enums;

public enum OrderBy {
	
	ASC(1, "Ascending"), DESC(2, "Descending");
	
	private OrderBy(int key, String value) {
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
	
	public OrderBy getByKey(int key) {
		for(OrderBy orderBy: values()) {
			if(orderBy.getKey() == key) {
				return orderBy;
			}
		}
		return null;
	}

}
