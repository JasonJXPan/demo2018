package com.pjx.demo2018.dailytest.mtlorder.dto;

import java.sql.Timestamp;

/**
 * Created by juqi on 18/11/15.
 */
public class OverdueCompensateTransfer {

    private Long overdue_time_gap;
    private Timestamp overdue_timestamp;

    public Long getOverdue_time_gap() {
        return overdue_time_gap;
    }

    public void setOverdue_time_gap(Long overdue_time_gap) {
        this.overdue_time_gap = overdue_time_gap;
    }

    public Timestamp getOverdue_timestamp() {
        return overdue_timestamp;
    }

    public void setOverdue_timestamp(Timestamp overdue_timestamp) {
        this.overdue_timestamp = overdue_timestamp;
    }
}
