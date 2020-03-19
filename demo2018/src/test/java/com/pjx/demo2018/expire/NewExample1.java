package com.pjx.demo2018.expire;

import org.junit.Test;

import java.math.BigDecimal;

public class NewExample1 {

    @Test
    public void testte() {
        System.out.println(new BigDecimal("0.01"));
        System.out.println(new BigDecimal(0.01));
        Double d = 0.01;
        System.out.println(new BigDecimal(d.toString()));
        System.out.println(new BigDecimal(Double.toString(d)));

    }

    @Test
    public void test() {

//        1. 用户在交易下单购买时包含了A，B，C三款产品，个数不限；
//        A、B、C各自的单价是 unitPrice ；由于存在一定的满减活动或者加价的购买行为，
//        最终付款的总价是 totalAmount ；求每个产品按照金额占比分摊下的最终分摊后的金额是多少？
//  交易中对金额的处理
////        100 * 1    100 *2   100 *1  400  -40  360
//
//        100*1  /  sum(100 * 1 + 100 *2  + 100 *1)    * 360 = 90 180 90

        test1(101d, 1, 100d, 1, 100d, 1, 301d);


    }

    private void test1(Double unitPriceA, int qtyA, Double unitPriceB, int qtyB, Double unitPriceC, int qtyC, Double totalAmount) {
        BigDecimal bigDecimalA = new BigDecimal(unitPriceA.toString()).multiply(new BigDecimal(qtyA));
        BigDecimal bigDecimalB = new BigDecimal(unitPriceB.toString()).multiply(new BigDecimal(qtyB));
        BigDecimal bigDecimalC = new BigDecimal(unitPriceC.toString()).multiply(new BigDecimal(qtyC));

        BigDecimal sum = bigDecimalA.add(bigDecimalB).add(bigDecimalC);

        BigDecimal resultA = bigDecimalA.multiply(new BigDecimal(totalAmount.toString())).divide(sum, 2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal resultB = bigDecimalB.multiply(new BigDecimal(totalAmount.toString())).divide(sum, 2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal resultC = new BigDecimal(totalAmount).subtract(resultA.add(resultB));

        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);
    }

//    对于子订单1（SKU A）
//
//    商品总价：25元
//
//    促销优惠：5元
//
//    促销分摊优惠：（25-5）/（20+60+20）*10=2 元
//
//    优惠券分摊优惠：（25-5）/（20+60+20）*10=2 元
//
//    订单实付款：25-5-2-2=16 元
//
//
//    对于子订单2（SKU B）
//
//    商品总价：60 元
//
//    促销分摊优惠：60/（20+60+20）*10=6 元
//
//    优惠券分摊优惠：60/（20+60+20）*10=6 元
//
//    订单实付款：60-6-6=48 元
//
//
//    对于子订单3（SKU C）
//
//    商品总价：20 元
//
//    促销分摊优惠：20/（20+60+20）*10=2 元
//
//    优惠券分摊优惠：20/（20+60+20）*10=2 元
//
//    订单实付款：20-2-2=16 元
//


}
