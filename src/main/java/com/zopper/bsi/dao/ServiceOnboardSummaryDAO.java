package com.zopper.bsi.dao;

import org.springframework.data.repository.CrudRepository;

import com.zopper.bsi.models.ServiceOnboardSummary;

public interface ServiceOnboardSummaryDAO extends CrudRepository<ServiceOnboardSummary, Long> {
	
	ServiceOnboardSummary findByOrderId(Long orderId);

}
