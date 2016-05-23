package com.zopper.bsi.dao;

import java.util.List;

import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;

public interface ServiceRequestDaoCustom {
	
	List<ServiceRequest> getAllServiceRequests(Criteria criteria);

}
