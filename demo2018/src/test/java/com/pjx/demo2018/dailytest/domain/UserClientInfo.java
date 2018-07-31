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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserClientInfo that = (UserClientInfo) o;

        if (clientOID != null ? !clientOID.equals(that.clientOID) : that.clientOID != null) return false;
        if (userOID != null ? !userOID.equals(that.userOID) : that.userOID != null) return false;
        return userSource != null ? userSource.equals(that.userSource) : that.userSource == null;
    }

    @Override
    public int hashCode() {
        int result = clientOID != null ? clientOID.hashCode() : 0;
        result = 31 * result + (userOID != null ? userOID.hashCode() : 0);
        result = 31 * result + (userSource != null ? userSource.hashCode() : 0);
        return result;
    }
}
