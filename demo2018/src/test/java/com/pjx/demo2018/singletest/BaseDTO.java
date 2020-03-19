package com.pjx.demo2018.singletest;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael.Zhong on 2018/4/18.
 */
public class BaseDTO implements Serializable {

    protected String id;

    protected Date createTime;

    protected Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
