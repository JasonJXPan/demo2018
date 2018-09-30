package com.pjx.demo2018.dailytest.domain;

import java.util.Date;

/**
 * Created by juqi on 18/9/29.
 */
public class JsonRootBean {
    private String venueLat;
    private String venueLng;
    private String venueContact;
    private String sellerPhone;
    private String params;
    private String template;
    private String showName;
    private Date showTime;
    private String address;
    private String venueName;
    private String orderStatus;
    private String showOID;
    private boolean isPermanent;
    private Date firstShowTime;
    private Date lastShowTime;
    private String verifyCode;
    private String buyerPhone;
    private String orderOID;
    private String dispatchStatus;
    private String purchaseOrderOID;
    private int originalPrice;
    private int qty;
    private String seatPlanUnit;
    private String ticketForm;
    public void setVenueLat(String venueLat) {
        this.venueLat = venueLat;
    }
    public String getVenueLat() {
        return venueLat;
    }

    public void setVenueLng(String venueLng) {
        this.venueLng = venueLng;
    }
    public String getVenueLng() {
        return venueLng;
    }

    public void setVenueContact(String venueContact) {
        this.venueContact = venueContact;
    }
    public String getVenueContact() {
        return venueContact;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }
    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setParams(String params) {
        this.params = params;
    }
    public String getParams() {
        return params;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
    public String getTemplate() {
        return template;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }
    public String getShowName() {
        return showName;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }
    public Date getShowTime() {
        return showTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    public String getVenueName() {
        return venueName;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setShowOID(String showOID) {
        this.showOID = showOID;
    }
    public String getShowOID() {
        return showOID;
    }

    public void setIsPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }
    public boolean getIsPermanent() {
        return isPermanent;
    }

    public void setFirstShowTime(Date firstShowTime) {
        this.firstShowTime = firstShowTime;
    }
    public Date getFirstShowTime() {
        return firstShowTime;
    }

    public void setLastShowTime(Date lastShowTime) {
        this.lastShowTime = lastShowTime;
    }
    public Date getLastShowTime() {
        return lastShowTime;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }
    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setOrderOID(String orderOID) {
        this.orderOID = orderOID;
    }
    public String getOrderOID() {
        return orderOID;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }
    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setPurchaseOrderOID(String purchaseOrderOID) {
        this.purchaseOrderOID = purchaseOrderOID;
    }
    public String getPurchaseOrderOID() {
        return purchaseOrderOID;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }
    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getQty() {
        return qty;
    }

    public void setSeatPlanUnit(String seatPlanUnit) {
        this.seatPlanUnit = seatPlanUnit;
    }
    public String getSeatPlanUnit() {
        return seatPlanUnit;
    }

    public void setTicketForm(String ticketForm) {
        this.ticketForm = ticketForm;
    }
    public String getTicketForm() {
        return ticketForm;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "venueLat='" + venueLat + '\'' +
                ", venueLng='" + venueLng + '\'' +
                ", venueContact='" + venueContact + '\'' +
                ", sellerPhone='" + sellerPhone + '\'' +
                ", params='" + params + '\'' +
                ", template='" + template + '\'' +
                ", showName='" + showName + '\'' +
                ", showTime=" + showTime +
                ", address='" + address + '\'' +
                ", venueName='" + venueName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", showOID='" + showOID + '\'' +
                ", isPermanent=" + isPermanent +
                ", firstShowTime=" + firstShowTime +
                ", lastShowTime=" + lastShowTime +
                ", verifyCode='" + verifyCode + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", orderOID='" + orderOID + '\'' +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", purchaseOrderOID='" + purchaseOrderOID + '\'' +
                ", originalPrice=" + originalPrice +
                ", qty=" + qty +
                ", seatPlanUnit='" + seatPlanUnit + '\'' +
                ", ticketForm='" + ticketForm + '\'' +
                '}';
    }
}
