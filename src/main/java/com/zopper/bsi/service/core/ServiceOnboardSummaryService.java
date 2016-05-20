package com.zopper.bsi.service.core;

import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.response.OrderData;

public interface ServiceOnboardSummaryService {
	
	void save(OrderData orderData) throws Exception;
	
	ServiceOnboardSummary getByOrderId(Long orderId) throws Exception;

}
