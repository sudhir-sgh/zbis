package com.zopper.bsi.request;

import com.zopper.bsi.enums.RequestInternalStatus;
import com.zopper.bsi.models.BaseModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by sudhir on 24/5/16.
 */
public class CCWorkLogRequest extends BaseModel{

    @NotNull
    Long serviceRequestId;

    @NotEmpty
    String remarks;

    RequestInternalStatus oldWorkFlowStatus;
    RequestInternalStatus newWorkFlowStatus;

    @NotNull
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
