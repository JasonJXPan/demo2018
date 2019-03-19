package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.juqitech.service.utils.BigDecimalUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

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
        BigDecimal bigDecimal1 = new BigDecimal(10.5D);
        System.out.println(bigDecimal1.toString());
    }

    @Test
    public void test4() {
        System.out.println(Math.random());
        BigDecimal successRate = add(new BigDecimal("85.00"), Math.random() * 10 % 2);
        System.out.println(round(successRate, 2));
    }
    public static BigDecimal add(Number v1, Number v2) {
        BigDecimal b1 = new BigDecimal(v1==null?"0":v1+"");
        BigDecimal b2 = new BigDecimal(v2==null?"0":v2+"");
        return b1.add(b2);
    }
    public static BigDecimal round(BigDecimal v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(

                    "The scale must be a positive integer or zero");
        }
        BigDecimal one = new BigDecimal("1");
        return v.divide(one, scale, BigDecimal.ROUND_FLOOR);
    }

    @Test
    public void test10(){
        BigDecimal bigDecimal = new BigDecimal("11.1");
        System.out.println(bigDecimal);
        System.out.println(round(bigDecimal, 0));
    }

    @Test
    public void test5() {
        System.out.println((Math.random() * 10 ));
        System.out.println(Math.random() );
        BigDecimal RATE_A = new BigDecimal("15.00");
        BigDecimal result = RATE_A.add(new BigDecimal(Math.random()));
        System.out.println(result);
        BigDecimal RATE_B = new BigDecimal("80.00");
        BigDecimal result1 = RATE_B.add(new BigDecimal(Math.random() * 10 ));
        System.out.println(result1);
        System.out.println(""+true);
    }

    @Test
    public void test6() {
        BigDecimal bigDecimal = new BigDecimal("0.5");
        BigDecimal bigDecimal1 = new BigDecimal("10");
        BigDecimal[] bigDecimals = bigDecimal.divideAndRemainder(bigDecimal1);
        for (BigDecimal a : bigDecimals) {
            System.out.println(a);
            System.out.println(a.compareTo(BigDecimal.ZERO)==0);
        }
    }
    @Test
    public void test7() {
        BigDecimal bigDecimal = new BigDecimal("2");
        BigDecimal bigDecimal1 = new BigDecimal("5");
        BigDecimal bigDecimal2 = new BigDecimal("8");
        BigDecimal multiply = bigDecimal1.subtract(bigDecimal).multiply(bigDecimal2);
        System.out.println(multiply);

    }

    @Test
    public void test8() {
//        BigDecimal bigDecimal = new BigDecimal("10.1");
//        BigDecimal bigDecimal = new BigDecimal("10.5");
        BigDecimal bigDecimal = new BigDecimal("10.01");
        System.out.println(BigDecimalUtil.round(bigDecimal, 0));
    }

    @Test
    public void test13() {
        int x = 18;
        System.out.println((x<<2));
    }

    @Test
    public void test14() {
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecimal1 = new BigDecimal("15");
        System.out.println(BigDecimalUtil.div(bigDecimal, bigDecimal1).setScale(2, BigDecimal.ROUND_FLOOR));
        BigDecimal min = new BigDecimal("0.10");
        BigDecimal max = new BigDecimal("0.50");
        BigDecimal subtract = max.subtract(min);
        System.out.println(subtract);
        int i1 = subtract.multiply(new BigDecimal("100")).intValue();
        System.out.println(i1);
        int i = new Random().nextInt(0);
        System.out.println(i + 10);
    }
    @Test
    public void test15() {
        String x = "123";
//        Temp temp = JSON.parseObject(x, Temp.class);
        Temp temp = new Temp();
        temp.setA("a");
        String stringVal = JSON.toJSONString(temp);
        System.out.println(stringVal);
    }

    @Test
    public void test16() {
        BigDecimal bigDecimal = new BigDecimal("-100.23");
        System.out.println(bigDecimal.toString());
        StringBuilder priceItemValDisplayBuilder = new StringBuilder();
        System.out.println(priceItemValDisplayBuilder.toString());

    }
}
class Temp {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "a='" + a + '\'' +
                '}';
    }
}
