package com.zopper.bsi.models.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.zopper.bsi.models.ServiceOnboardItem;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.response.Item;
import com.zopper.bsi.response.OrderData;

@Component
public class ServiceOnboardSummaryMapper {
	
	public ServiceOnboardSummary from(OrderData orderData) throws Exception {
		ServiceOnboardSummary serviceOnboardSummary = new ServiceOnboardSummary();
		serviceOnboardSummary.setDateOfSale(orderData.getCreatedAt());
		serviceOnboardSummary.setCustomerName(orderData.getRecipientName());
		serviceOnboardSummary.setCustomerMobile(orderData.getContactNo());
		serviceOnboardSummary.setCustomerEmail(orderData.getRecipientEmail());
		serviceOnboardSummary.setCustomerAddressLine1(orderData.getAddress());
		serviceOnboardSummary.setCustomerAddressLine2(null); // addressLine2 or area
		serviceOnboardSummary.setCustomerAddressCity(orderData.getCity());
		serviceOnboardSummary.setCustomerAddressState(orderData.getState());
		serviceOnboardSummary.setCustomerAddressLandmark(null);
		serviceOnboardSummary.setCustomerAddressPincode(orderData.getPincode());
		serviceOnboardSummary.setCustomerId(orderData.getUserId());
		serviceOnboardSummary.setOrderId(orderData.getOrderId());
		
		Set<ServiceOnboardItem> serviceOnboardItems = new HashSet<>();
		for(Item item: orderData.getItems()) {
			ServiceOnboardItem serviceOnboardItem = new ServiceOnboardItem();
			serviceOnboardItem.setOrderItemId(item.getId());
			serviceOnboardItem.setProductName(item.getProductTitle());
			serviceOnboardItem.setQuantity(item.getQuantity());
			serviceOnboardItem.setOrderItemTotal(item.getOrderItemTotal());
			serviceOnboardItem.setFulfilledStoreId(item.getFulfilledStoreId());
			serviceOnboardItem.setServiceOnboardSummary(serviceOnboardSummary);
			serviceOnboardItems.add(serviceOnboardItem);
		}
		serviceOnboardSummary.setServiceOnboardItems(serviceOnboardItems);
		return serviceOnboardSummary;
	}

}
