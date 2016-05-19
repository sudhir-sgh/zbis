package com.zopper.bsi.models;

import com.zopper.bsi.enums.StatusCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Generic columns for all table
 * @author sudhir
 *
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	protected Long id;// auto generated

	@Column(name = "CREATED_AT")
	protected Long createdAt;// time in milliseconds

	@Column(name = "CREATED_BY")
	protected Long createdBy;// holds user id

	@Column(name = "LAST_UPDATED_AT")
	protected Long lastUpdatedAt;
	
	@Column(name = "LAST_UPDATED_BY")
	protected Long lastUpdatedBy;

	@Column(name = "STATUS_CODE")
	protected int statusCode;// soft delete
	
	@Transient
    private String createdAtStr;

	@Transient
    private String lastUpdatedAtStr;

	public BaseModel() 
	{
		super();
		if(id == null) {
			this.createdAt = System.currentTimeMillis();
			//this.createdBy = LoggedInUserDetails.getUserId();
			this.statusCode = StatusCode.ACTIVE.getKey();
		}
		this.lastUpdatedAt = System.currentTimeMillis();
		//this.lastUpdatedBy = LoggedInUserDetails.getUserId();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Long lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedAt=" + lastUpdatedAt
				+ ", statusCode=" + statusCode + "]";
	}
		
}