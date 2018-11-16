package com.pjx.demo2018.dailytest.mtlorder.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by juqi on 18/11/15.
 */
public class OrderOverdueCompensateRuleDetailDTO implements Serializable {

    private static final long serialVersionUID = 4304987180205854759L;
    /**
     * 规则内基础赔付金额
     */
    private BigDecimal amount;
    /**
     * 规则内最小逾期天数
     */
    private Long minDays;
    /**
     * 规则内最大逾期天数
     */
    private Long maxDays;
    /**
     * 规则内天数步进  如果为0 说明不需要步进
     */
    private BigDecimal daysStep;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getMinDays() {
        return minDays;
    }

    public void setMinDays(Long minDays) {
        this.minDays = minDays;
    }

    public Long getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(Long maxDays) {
        this.maxDays = maxDays;
    }

    public BigDecimal getDaysStep() {
        return daysStep;
    }

    public void setDaysStep(BigDecimal daysStep) {
        this.daysStep = daysStep;
    }

    @Override
    public String toString() {
        return "OrderOverdueCompensateRuleDetailDTO{" +
                "amount=" + amount +
                ", minDays=" + minDays +
                ", maxDays=" + maxDays +
                ", daysStep=" + daysStep +
                '}';
    }
}