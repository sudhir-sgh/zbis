package com.zopper.bsi.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "brand_service_request")
public class ServiceRequest extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8647014155575488587L;

	String date_of_request;
	
	Short request_type; //installation/demo/repair/replace
	
	Short request_source; //mobile/usd ?
	
	Short brand_id;
	
	//brand_request_id
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_SERVICE_ONBOARD_DATA_ID")
	ServiceOnboardSummary serviceOnboardSummary;
}
