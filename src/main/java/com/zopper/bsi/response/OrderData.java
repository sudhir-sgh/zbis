
package com.zopper.bsi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderData extends USDSeviceApiResponse{

    @JsonProperty("payment_failed")
    private boolean paymentFailed;
    @JsonProperty("is_cod")
    private boolean isCod;
    @JsonProperty("payment_status")
    private String paymentStatus;
    @JsonProperty("fuzzy_resolved_by_timestamp")
    private String fuzzyResolvedByTimestamp;
    @JsonProperty("pincode")
    private String pincode;
    @JsonProperty("is_manual_intervention_required")
    private String isManualInterventionRequired;
    @JsonProperty("registered_email")
    private String registeredEmail;
    @JsonProperty("recipient_email")
    private String recipientEmail;
    @JsonProperty("lng")
    private double lng;
    @JsonProperty("region_id")
    private long regionId;
    @JsonProperty("city")
    private String city;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("order_type")
    private long orderType;
    @JsonProperty("is_confirmed")
    private boolean isConfirmed;
    @JsonProperty("customer_order_status")
    private String customerOrderStatus;
    @JsonProperty("wallet_discount")
    private long walletDiscount;
    @JsonProperty("fuzzy_resolved_by")
    private String fuzzyResolvedBy;
    @JsonProperty("state")
    private String state;
    @JsonProperty("pg")
    private String pg;
    @JsonProperty("order_cnf_or_rej_by_time")
    private String orderCnfOrRejByTime;
    @JsonProperty("order_id")
    private long orderId;
    @JsonProperty("recipient_name")
    private String recipientName;
    @JsonProperty("contact_no")
    private String contactNo;
    @JsonProperty("order_cnf_or_rej_by")
    private String orderCnfOrRejBy;
    @JsonProperty("address")
    private String address;
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("customer_acceptance_time")
    private String customerAcceptanceTime;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("coupon_code")
    private String couponCode;
    @JsonProperty("payment_type")
    private String paymentType;

    public boolean isPaymentFailed() {
        return paymentFailed;
    }

    public void setPaymentFailed(boolean paymentFailed) {
        this.paymentFailed = paymentFailed;
    }

    public boolean isCod() {
        return isCod;
    }

    public void setCod(boolean cod) {
        isCod = cod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getFuzzyResolvedByTimestamp() {
        return fuzzyResolvedByTimestamp;
    }

    public void setFuzzyResolvedByTimestamp(String fuzzyResolvedByTimestamp) {
        this.fuzzyResolvedByTimestamp = fuzzyResolvedByTimestamp;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getIsManualInterventionRequired() {
        return isManualInterventionRequired;
    }

    public void setIsManualInterventionRequired(String isManualInterventionRequired) {
        this.isManualInterventionRequired = isManualInterventionRequired;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrderType() {
        return orderType;
    }

    public void setOrderType(long orderType) {
        this.orderType = orderType;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getCustomerOrderStatus() {
        return customerOrderStatus;
    }

    public void setCustomerOrderStatus(String customerOrderStatus) {
        this.customerOrderStatus = customerOrderStatus;
    }

    public long getWalletDiscount() {
        return walletDiscount;
    }

    public void setWalletDiscount(long walletDiscount) {
        this.walletDiscount = walletDiscount;
    }

    public String getFuzzyResolvedBy() {
        return fuzzyResolvedBy;
    }

    public void setFuzzyResolvedBy(String fuzzyResolvedBy) {
        this.fuzzyResolvedBy = fuzzyResolvedBy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getOrderCnfOrRejByTime() {
        return orderCnfOrRejByTime;
    }

    public void setOrderCnfOrRejByTime(String orderCnfOrRejByTime) {
        this.orderCnfOrRejByTime = orderCnfOrRejByTime;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getOrderCnfOrRejBy() {
        return orderCnfOrRejBy;
    }

    public void setOrderCnfOrRejBy(String orderCnfOrRejBy) {
        this.orderCnfOrRejBy = orderCnfOrRejBy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCustomerAcceptanceTime() {
        return customerAcceptanceTime;
    }

    public void setCustomerAcceptanceTime(String customerAcceptanceTime) {
        this.customerAcceptanceTime = customerAcceptanceTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
