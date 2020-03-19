package com.pjx.demo2018.dailytest;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2020/3/17
 */
public class MyShow {

    private String showOID;
    private String venueName;
    private String address;
    private boolean isPermanent;

    public String getShowOID() {
        return this.showOID;
    }

    public void setShowOID(String showOID) {
        this.showOID = showOID;
    }

    public String getVenueName() {
        return this.venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public boolean getIsPermanent() {
        return this.isPermanent;
    }

    public void setIsPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    /** @deprecated */
    @Deprecated
    public boolean isPermanent() {
        return this.isPermanent;
    }

    @Override
    public String toString() {
        return "MyShow{" +
                "showOID='" + showOID + '\'' +
                ", venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                ", isPermanent=" + isPermanent +
                '}';
    }
}
