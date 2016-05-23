package com.zopper.bsi.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zopper.bsi.dao.ServiceRequestDaoCustom;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;

public class ServiceRequestDaoImpl implements ServiceRequestDaoCustom {
	
	//private @Autowired HibernateTemplate hibernateTemplate;

	@Override
	public List<ServiceRequest> getAllServiceRequests(Criteria criteria) {
		System.out.println("\n\n**********ServiceRequestDaoImpl.getAllServiceRequests() called**********\n\n");
		/*return hibernateTemplate.execute(new HibernateCallback<List<ServiceRequest>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<ServiceRequest> doInHibernate(Session session) throws HibernateException {
				String hqlQuery = "FROM ServiceRequest ";
				Query query = session.createQuery(hqlQuery);
				return query.list();
			}
		});*/
		return null;
	}

}
