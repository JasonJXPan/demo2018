package com.pjx.demo2018.dailytest.stream.po;

import java.io.Serializable;

/**
 * Created by juqi on 18/11/26.
 */
public class StreamTestPO implements Serializable {

    private static final long serialVersionUID = -5409729576808096749L;
    private String orderId;
    private String showId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    @Override
    public String toString() {
        return "StreamTestPO{" +
                "orderId='" + orderId + '\'' +
                ", showId='" + showId + '\'' +
                '}';
    }
}
