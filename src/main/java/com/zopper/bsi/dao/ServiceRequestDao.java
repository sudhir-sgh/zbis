package com.zopper.bsi.dao;

import org.springframework.data.repository.CrudRepository;

import com.zopper.bsi.models.ServiceRequest;

public interface ServiceRequestDao extends CrudRepository<ServiceRequest, Long>, ServiceRequestDaoCustom {

	ServiceRequest findByReferenceNumber(String referenceNumber);
	
}
