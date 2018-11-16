package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by juqi on 18/10/15.
 */
public class LogicTest {
    @Test
    public void test1(){
        BigDecimal originalPrice = new BigDecimal(120);
        int qty = 2;
        BigDecimal seatPlanPrice = originalPrice.multiply(BigDecimal.valueOf(qty));
        BigDecimal guaranteeFee = new BigDecimal(0.0);
        BigDecimal price = new BigDecimal(308);
        if (-1 != price.compareTo(seatPlanPrice)) {
            guaranteeFee = price.subtract(seatPlanPrice);// 交易保障费
        } else {
            seatPlanPrice = price;
        }
        System.out.println(guaranteeFee);
        System.out.println(seatPlanPrice);

    }
}
