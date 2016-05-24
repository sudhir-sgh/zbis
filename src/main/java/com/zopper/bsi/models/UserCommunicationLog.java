package com.zopper.bsi.models;

import com.zopper.bsi.enums.RequestStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sudhir on 24/5/16.
 */
@Entity
@Table(name = "log_user_communication")
public class UserCommunicationLog extends BaseModel{

    public UserCommunicationLog() {
    }

    @Column(name = "SERVICE_REQUEST_ID")
    Long serviceRequestId;

    @Column(name = "REMARKS", columnDefinition = "TEXT")
    String remarks;

    @Column(name = "OLD_STATUS")
    RequestStatus oldStatus;

    @Column(name = "NEW_STATUS")
    RequestStatus newStatus;

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

    public RequestStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(RequestStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public RequestStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(RequestStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getUsdUser() {
        return usdUser;
    }

    public void setUsdUser(String usdUser) {
        this.usdUser = usdUser;
    }
}
