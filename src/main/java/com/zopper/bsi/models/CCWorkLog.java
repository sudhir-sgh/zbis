package com.zopper.bsi.models;

import com.zopper.bsi.enums.RequestInternalStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sudhir on 24/5/16.
 */
@Entity
@Table(name = "log_customer_care_work")
public class CCWorkLog extends BaseModel{

    public CCWorkLog() {
    }

    public CCWorkLog(Long serviceRequestId, String remarks, RequestInternalStatus oldWorkFlowStatus, RequestInternalStatus newWorkFlowStatus, String usdUser) {
        this.serviceRequestId = serviceRequestId;
        this.remarks = remarks;
        this.oldWorkFlowStatus = oldWorkFlowStatus;
        this.newWorkFlowStatus = newWorkFlowStatus;
        this.usdUser = usdUser;
    }

    @Column(name = "SERVICE_REQUEST_ID")
    Long serviceRequestId;

    @Column(name = "REMARKS", columnDefinition = "TEXT")
    String remarks;

    @Column(name = "OLD_STATUS")
    RequestInternalStatus oldWorkFlowStatus;

    @Column(name = "NEW_STATUS")
    RequestInternalStatus newWorkFlowStatus;

    @Column(name = "LOGGED_USD_USER")
    String usdUser;

    public Long getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Long serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public RequestInternalStatus getOldWorkFlowStatus() {
        return oldWorkFlowStatus;
    }

    public void setOldWorkFlowStatus(RequestInternalStatus oldWorkFlowStatus) {
        this.oldWorkFlowStatus = oldWorkFlowStatus;
    }

    public RequestInternalStatus getNewWorkFlowStatus() {
        return newWorkFlowStatus;
    }

    public void setNewWorkFlowStatus(RequestInternalStatus newWorkFlowStatus) {
        this.newWorkFlowStatus = newWorkFlowStatus;
    }

    public String getUsdUser() {
        return usdUser;
    }

    public void setUsdUser(String usdUser) {
        this.usdUser = usdUser;
    }
}
