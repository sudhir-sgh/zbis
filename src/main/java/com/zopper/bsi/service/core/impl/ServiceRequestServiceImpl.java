package com.zopper.bsi.service.core.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zopper.bsi.dao.ServiceRequestDao;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;
import com.zopper.bsi.service.core.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {
	
	private @Autowired ServiceRequestDao serviceRequestDao;

	@Transactional
	@Override
	public ServiceRequest getByReferenceNumber(String referenceNumber) throws Exception {
		return serviceRequestDao.findByReferenceNumber(referenceNumber);
	}

	@Transactional
	@Override
	public List<ServiceRequest> getAllServiceRequests(Criteria criteria) throws Exception {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getAllServiceRequests(criteria);
		return serviceRequests;
	}

}
