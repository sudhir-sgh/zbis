package com.zopper.bsi.service.core.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zopper.bsi.dao.ServiceRequestDao;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.service.core.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {
	
	private @Autowired ServiceRequestDao serviceRequestDao;

	@Override
	@Transactional
	public Iterable<ServiceRequest> getAllServiceRequests() throws Exception {
		return serviceRequestDao.findAll();
	}

	@Override
	@Transactional
	public ServiceRequest getByReferenceNumber(String referenceNumber) throws Exception {
		return serviceRequestDao.findByReferenceNumber(referenceNumber);
	}

}
