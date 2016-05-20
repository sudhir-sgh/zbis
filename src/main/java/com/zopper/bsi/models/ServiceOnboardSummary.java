package com.zopper.bsi.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand_service_onboard_summary")
public class ServiceOnboardSummary extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4200547870873335122L;

	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@Column(name = "DATE_OF_SALE")
	private String dateOfSale;
	
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_MOBILE")
	private String customerMobile;
	
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	
	@Column(name = "CUSTOMER_ADDRESS_LINE1")
	private String customerAddressLine1;
	
	@Column(name = "CUSTOMER_ADDRESS_LINE2")
	private String customerAddressLine2; // addressLine2 or area
	
	@Column(name = "CUSTOMER_ADDRESS_CITY")
	private String customerAddressCity;
	
	@Column(name = "CUSTOMER_ADDRESS_STATE")
	private String customerAddressState;
	
	@Column(name = "CUSTOMER_ADDRESS_LANDMARK")
	private String customerAddressLandmark;
	
	@Column(name = "CUSTOMER_ADDRESS_PINCODE")
	private String customerAddressPincode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceOnboardSummary", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ServiceOnboardItem> serviceOnboardItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddressLine1() {
		return customerAddressLine1;
	}

	public void setCustomerAddressLine1(String customerAddressLine1) {
		this.customerAddressLine1 = customerAddressLine1;
	}

	public String getCustomerAddressLine2() {
		return customerAddressLine2;
	}

	public void setCustomerAddressLine2(String customerAddressLine2) {
		this.customerAddressLine2 = customerAddressLine2;
	}

	public String getCustomerAddressCity() {
		return customerAddressCity;
	}

	public void setCustomerAddressCity(String customerAddressCity) {
		this.customerAddressCity = customerAddressCity;
	}

	public String getCustomerAddressState() {
		return customerAddressState;
	}

	public void setCustomerAddressState(String customerAddressState) {
		this.customerAddressState = customerAddressState;
	}

	public String getCustomerAddressLandmark() {
		return customerAddressLandmark;
	}

	public void setCustomerAddressLandmark(String customerAddressLandmark) {
		this.customerAddressLandmark = customerAddressLandmark;
	}

	public String getCustomerAddressPincode() {
		return customerAddressPincode;
	}

	public void setCustomerAddressPincode(String customerAddressPincode) {
		this.customerAddressPincode = customerAddressPincode;
	}

	public Set<ServiceOnboardItem> getServiceOnboardItems() {
		return serviceOnboardItems;
	}

	public void setServiceOnboardItems(Set<ServiceOnboardItem> serviceOnboardItems) {
		this.serviceOnboardItems = serviceOnboardItems;
	}
	
}
