package com.pjx.demo2018.po;

import java.io.Serializable;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/6
 */
public class UserIPPO implements Serializable {
    private static final long serialVersionUID = -5183502307799056169L;

    private String userIpid;
    private String ip;
    private String userId;

    public String getUserIpid() {
        return userIpid;
    }

    public void setUserIpid(String userIpid) {
        this.userIpid = userIpid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
