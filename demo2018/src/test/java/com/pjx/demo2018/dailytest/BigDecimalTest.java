package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by juqi on 18/9/6.
 */
public class BigDecimalTest {
    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal(0);
        BigDecimal bigDecimal1 = new BigDecimal(10);
        BigDecimal bigDecimal1_1 = new BigDecimal(6);
        BigDecimal bigDecimal2 = bigDecimal.add(bigDecimal1);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
        bigDecimal2 = bigDecimal1.subtract(bigDecimal1_1);
        System.out.println(bigDecimal2);
    }

    @Test
    public void test2() {
        BigDecimal bigDecimal1 = new BigDecimal(10L);
        BigDecimal bigDecimal2 = null;
        bigDecimal2 = bigDecimal1.add(bigDecimal2);
        System.out.println(bigDecimal2);
    }

    @Test
    public void test3() {
        BigDecimal bigDecimal1 = new BigDecimal(10L);

    }
}
