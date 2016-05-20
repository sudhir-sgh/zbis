package com.zopper.bsi.response;

public class BrandServiceResponse {
	
	private Long orderId;
	
	private String referenceNumber;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrandServiceResponse [orderId=");
		builder.append(orderId);
		builder.append(", referenceNumber=");
		builder.append(referenceNumber);
		builder.append("]");
		return builder.toString();
	}

}
