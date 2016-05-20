package com.zopper.bsi.request;

import javax.validation.constraints.NotNull;

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
	private Long brandId;
	
	@NotNull
	private Long orderId;
	
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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

}
