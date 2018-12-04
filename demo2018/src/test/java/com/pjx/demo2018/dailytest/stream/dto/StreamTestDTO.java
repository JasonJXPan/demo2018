package com.pjx.demo2018.dailytest.stream.dto;

import com.pjx.demo2018.dailytest.stream.po.StreamTestPO;

import java.io.Serializable;

/**
 * Created by juqi on 18/11/26.
 */
public class StreamTestDTO implements Serializable {

    private static final long serialVersionUID = 7761346416789930369L;
    private String orderId;
    private String showId;

    public StreamTestDTO(){}

    public StreamTestDTO(StreamTestPO po) {
        this.orderId = po.getOrderId();
        this.showId = po.getShowId();
    }

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
        return "StreamTestDTO{" +
                "orderId='" + orderId + '\'' +
                ", showId='" + showId + '\'' +
                '}';
    }
}
