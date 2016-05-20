package com.zopper.bsi.service.core.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zopper.bsi.dao.ServiceOnboardSummaryDAO;
import com.zopper.bsi.models.ServiceOnboardSummary;
import com.zopper.bsi.models.mapper.ServiceOnboardSummaryMapper;
import com.zopper.bsi.response.OrderData;
import com.zopper.bsi.service.core.ServiceOnboardSummaryService;

@Service
public class ServiceOnboardSummaryServiceImpl implements ServiceOnboardSummaryService {
	
	Logger logger  = Logger.getLogger(ServiceOnboardSummaryServiceImpl.class);
	
	private @Autowired ServiceOnboardSummaryDAO serviceOnboardSummaryDAO;
	private @Autowired ServiceOnboardSummaryMapper serviceOnboardSummaryMapper;

	@Override
	@Transactional
	public Long save(OrderData orderData) throws Exception {
		ServiceOnboardSummary serviceOnboardSummary = serviceOnboardSummaryMapper.from(orderData);
		serviceOnboardSummaryDAO.save(serviceOnboardSummary);
		return serviceOnboardSummary.getId();
	}

	@Override
	@Transactional
	public ServiceOnboardSummary getByOrderId(Long orderId) throws Exception {
		return serviceOnboardSummaryDAO.findByOrderId(orderId);
	}

}
