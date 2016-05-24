package com.zopper.bsi.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zopper.bsi.enums.RequestSource;
import com.zopper.bsi.enums.RequestType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandServiceRequest {
	
	@NotNull
	private RequestType requestType;
	
	@NotNull
	private RequestSource requestSource;
	
	@NotNull
	private String brandId;
	
	@NotNull
	private Long orderId;
	
	@JsonIgnore
	private String referenceNumber;
	
	// Brand - IFB
	private String alternatePhoneNumber;
	
	// Brand - Godrej
	private String serialNumber;
	
	private String defectDetails;

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestSource getRequestSource() {
		return requestSource;
	}

	public void setRequestSource(RequestSource requestSource) {
		this.requestSource = requestSource;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

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

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDefectDetails() {
		return defectDetails;
	}

	public void setDefectDetails(String defectDetails) {
		this.defectDetails = defectDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrandServiceRequest [requestType=");
		builder.append(requestType);
		builder.append(", requestSource=");
		builder.append(requestSource);
		builder.append(", brandId=");
		builder.append(brandId);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", alternatePhoneNumber=");
		builder.append(alternatePhoneNumber);
		builder.append(", serialNumber=");
		builder.append(serialNumber);
		builder.append(", defectDetails=");
		builder.append(defectDetails);
		builder.append("]");
		return builder.toString();
	} 

}
