package com.pjx.demo2018.dailytest.domain;

/**
 * Created by juqi on 18/7/27.
 */
public class UserClientInfo {
    private String clientOID;
    private String userOID;
    private String userSource;

    public UserClientInfo(String clientOID, String userOID, String userSource) {
        this.clientOID = clientOID;
        this.userOID = userOID;
        this.userSource = userSource;
    }

    public UserClientInfo(){}
    public String getClientOID() {
        return clientOID;
    }

    public void setClientOID(String clientOID) {
        this.clientOID = clientOID;
    }

    public String getUserOID() {
        return userOID;
    }

    public void setUserOID(String userOID) {
        this.userOID = userOID;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    @Override
    public String toString() {
        return "UserClientInfo{" +
                "clientOID='" + clientOID + '\'' +
                ", userOID='" + userOID + '\'' +
                ", userSource='" + userSource + '\'' +
                '}';
    }
}
