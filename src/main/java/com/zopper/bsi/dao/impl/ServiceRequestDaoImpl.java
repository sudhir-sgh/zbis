package com.zopper.bsi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.zopper.bsi.dao.ServiceRequestDaoCustom;
import com.zopper.bsi.enums.OrderBy;
import com.zopper.bsi.enums.StatusCode;
import com.zopper.bsi.models.ServiceRequest;
import com.zopper.bsi.request.Criteria;

public class ServiceRequestDaoImpl implements ServiceRequestDaoCustom {
	
	private @Autowired EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequest> getAllServiceRequests(Criteria criteria) {
		System.out.println("\n\n**********ServiceRequestDaoImpl.getAllServiceRequests() called**********\n\n");
		
		boolean includeBrandFilter = criteria.getBrandIds() != null && !criteria.getBrandIds().isEmpty();
		boolean includeRequestTypeFilter = criteria.getRequestType() != null;
		boolean includeRequestSourceFilter = criteria.getRequestSource() != null;
		boolean includeRequestStatusFilter = criteria.getRequestStatus() != null;
		boolean includeSortByFilter = !StringUtils.isEmpty(criteria.getSortBy());
		boolean includeOrderByFilter = criteria.getOrderBy() != null;
		boolean includeTimeStartFilter = criteria.getTimeStart() != null && !NumberUtils.LONG_ZERO.equals(criteria.getTimeStart());
		boolean includeTimeEndFilter = criteria.getTimeEnd() != null && !NumberUtils.LONG_ZERO.equals(criteria.getTimeEnd());
		int page = criteria.getPage() != null && !NumberUtils.INTEGER_ZERO.equals(criteria.getPage())? criteria.getPage() : 1;
		int count = criteria.getCount() != null && !NumberUtils.INTEGER_ZERO.equals(criteria.getCount())? criteria.getCount() : 15;
		
		String queryString = "FROM ServiceRequest"
				+ " WHERE statusCode = :statusCode";
		
		StringBuilder condition = new StringBuilder();
		if(includeBrandFilter) {
			condition.append(" AND brandId IN (:brandIds)");
		}
		if(includeRequestTypeFilter) {
			condition.append(" AND requestType = :requestType");
		}
		if(includeRequestSourceFilter) {
			condition.append(" AND requestSource = :requestSource");
		}
		if(includeRequestStatusFilter) {
			condition.append(" AND requestStatus = :requestStatus");
		}
		
		queryString += condition.toString();
		queryString += " GROUP BY id";
		// sortBy filter should be included in last
		if(includeSortByFilter) {
			queryString += " ORDER BY createdAt";
			queryString += " " + (includeOrderByFilter? criteria.getOrderBy() : OrderBy.DESC);
		}
		Query query = entityManager.createQuery(queryString);
		query.setParameter("statusCode", StatusCode.ACTIVE.getKey());
		if(includeBrandFilter) {
			query.setParameter("brandIds", criteria.getBrandIds());
		}
		if(includeRequestTypeFilter) {
			query.setParameter("requestType", criteria.getRequestType());
		}
		if(includeRequestSourceFilter) {
			query.setParameter("requestSource", criteria.getRequestSource());
		}
		if(includeRequestStatusFilter) {
			query.setParameter("requestStatus", criteria.getRequestStatus());
		}
		
		query.setFirstResult((page - 1) * count);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
