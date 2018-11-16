package com.pjx.demo2018.dailytest.mtlorder.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by juqi on 18/11/15.
 */
public class OrderOverdueCompensateRule implements Serializable {

    private static final long serialVersionUID = -3519447714238782083L;
    private Date delimitDateFrom;
    private Date delimitDateEnd;
    private List<OrderOverdueCompensateRuleDetailDTO> ruleDetails;

    public Date getDelimitDateFrom() {
        return delimitDateFrom;
    }

    public void setDelimitDateFrom(Date delimitDateFrom) {
        this.delimitDateFrom = delimitDateFrom;
    }

    public Date getDelimitDateEnd() {
        return delimitDateEnd;
    }

    public void setDelimitDateEnd(Date delimitDateEnd) {
        this.delimitDateEnd = delimitDateEnd;
    }

    public List<OrderOverdueCompensateRuleDetailDTO> getRuleDetails() {
        return ruleDetails;
    }

    public void setRuleDetails(List<OrderOverdueCompensateRuleDetailDTO> ruleDetails) {
        this.ruleDetails = ruleDetails;
    }

    @Override
    public String toString() {
        return "OrderOverdueCompensateRule{" +
                "delimitDateFrom=" + delimitDateFrom +
                ", delimitDateEnd=" + delimitDateEnd +
                ", ruleDetails=" + ruleDetails +
                '}';
    }
}
