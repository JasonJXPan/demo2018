package com.pjx.demo2018.po;

import java.util.Date;

/**
 * Created by juqi on 18/11/19.
 */
public class PurchPo {
    private String id;
    private Date overdue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOverdue() {
        return overdue;
    }

    public void setOverdue(Date overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "PurchPo{" +
                "id='" + id + '\'' +
                ", overdue=" + overdue +
                '}';
    }
}
