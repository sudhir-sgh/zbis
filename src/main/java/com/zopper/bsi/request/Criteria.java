package com.zopper.bsi.request;

import java.util.List;

import com.zopper.bsi.enums.OrderBy;
import com.zopper.bsi.enums.RequestSource;
import com.zopper.bsi.enums.RequestStatus;
import com.zopper.bsi.enums.RequestType;

/**
 * Created by sudhir on 23/5/16.
 */
public class Criteria {

	private Integer page;   // default 1
	private Integer count;  // default 15

	private List<String> brandIds;  // can be provide more then one brand or null..

    private OrderBy orderBy;
    private String sortBy;

    private Long timeStart;
    private Long timeEnd;

    private RequestStatus requestStatus;
    private RequestType requestType;
    private RequestSource requestSource;
    
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<String> getBrandIds() {
		return brandIds;
	}
	public void setBrandIds(List<String> brandIds) {
		this.brandIds = brandIds;
	}
	public OrderBy getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Long getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Long timeStart) {
		this.timeStart = timeStart;
	}
	public Long getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Long timeEnd) {
		this.timeEnd = timeEnd;
	}
	public RequestStatus getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	public RequestSource getRequestSource() {
		return requestSource;
	}
	public void setRequestSource(RequestSource requestSource) {
		this.requestSource = requestSource;
	}

}
