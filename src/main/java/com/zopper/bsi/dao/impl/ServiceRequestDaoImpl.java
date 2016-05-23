package com.zopper.bsi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.zopper.bsi.dao.ServiceRequestDaoCustom;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;

public class ServiceRequestDaoImpl implements ServiceRequestDaoCustom {
	
	private @Autowired EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequest> getAllServiceRequests(Criteria criteria) {
		System.out.println("\n\n**********ServiceRequestDaoImpl.getAllServiceRequests() called**********\n\n");
		String hqlQuery = "FROM ServiceRequest ";
		Query query = entityManager.createQuery(hqlQuery);
		return query.getResultList();
	}

}
