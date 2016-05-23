package com.zopper.bsi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "brand_service_onboard_item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceOnboardItem extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5233982049693719582L;

	@Column(name = "ORDER_ITEM_ID")
	private Long orderItemId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_QTY")
	private Long quantity;
	
	@Column(name = "PRODUCT_SALES_PRICE")
	private Long orderItemTotal; // sales_price
	
	@Column(name = "FULLFILLED_STORE_ID")
	private Long fulfilledStoreId; // Dealer/Store/Purchase_from
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_SERVICE_ONBOARD_SUMMARY_ID")
	@JsonBackReference
	private ServiceOnboardSummary serviceOnboardSummary;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getOrderItemTotal() {
		return orderItemTotal;
	}

	public void setOrderItemTotal(Long orderItemTotal) {
		this.orderItemTotal = orderItemTotal;
	}

	public Long getFulfilledStoreId() {
		return fulfilledStoreId;
	}

	public void setFulfilledStoreId(Long fulfilledStoreId) {
		this.fulfilledStoreId = fulfilledStoreId;
	}

	public ServiceOnboardSummary getServiceOnboardSummary() {
		return serviceOnboardSummary;
	}

	public void setServiceOnboardSummary(ServiceOnboardSummary serviceOnboardSummary) {
		this.serviceOnboardSummary = serviceOnboardSummary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOnboardItem other = (ServiceOnboardItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
