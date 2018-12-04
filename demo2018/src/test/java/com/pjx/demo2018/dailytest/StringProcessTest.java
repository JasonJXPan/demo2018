package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.util.StringProcessUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by juqi on 18/7/30.
 */
public class StringProcessTest {

    @Test
    public void test1(){
        String content = "12345678901234567890";
        System.out.println(StringProcessUtil.getBreviaryValue(content, 20, ".."));
        System.out.println(StringProcessUtil.getBreviaryValue(content, 15, ".."));
        System.out.println(StringProcessUtil.getBreviaryValue(content, 30, ".."));
    }

    @Test
    public void testAbbreviate(){
        String content = "1234567890123456789012345678";
        System.out.println(StringUtils.abbreviate(content, 26));
    }

    @Test
    public void testStringFormat(){
        System.out.println(String.format("%s%d元", "总计", 20));
    }

    @Test
    public void test2(){
        StringProcessTest stringProcessTest = new StringProcessTest();
        System.out.println(stringProcessTest);
    }

    @Override
    public String toString() {
        return "StringProcessTest{}"+super.toString();
//        toString方法内不能使用this, 会造成toString方法的循环调用, 出现java.lang.StackOverflowError
//        return "StringProcessTest{}"+this;
    }

    @Test
    public void test3() {
        System.out.println(StringUtils.join(Arrays.asList("a", "b", "b"), ","));
    }

    @Test
    public void test4() {
        String x = "尊敬的会员：您订购的 【广州站】2018广州国际汽车展览会 2018-11-25 16:30 2 张。感谢您的支持！电子凭证 https://mj.tking.cn/ticketCredentials.html?id=5bf10ec0069b3e455070c69f 。客服热线：400-636-2266。";

        String y = "尊敬的客户，您在 摩天轮票务 购买的 1张<【上海站】2019上海马桥国际半程马拉松赛 2019-01-01 星期二 09:00 50(5km健康跑)> 已出票成功，您可凭核销码 992261714811 或者二维码 https://d.4k1.cn/2/4UaqP19ADm/4VHZrkyUU0 现场换票，兑换地址:，请妥善保管，祝您观演愉快 。";


        int start = x.lastIndexOf("https");
        int end = x.indexOf(" ", start);

        System.out.println(start);
        System.out.println(end);
        System.out.println("::"+x.substring(start, end)+"::");

        int start1 = y.lastIndexOf("https");
        int end1 = y.indexOf(" ", start1);

        System.out.println(start1);
        System.out.println(end1);
        System.out.println("::"+y.substring(start1, end1)+"::");
    }
    @Test
    public void test5() {
        String x = "a ,b,,";
        String[] replace = x.replace(" ", "##").replace(",", "##").split("##");
        for (String a : replace) {
            if (StringUtils.isNotBlank(a)) {
                System.out.println("::"+a+"::");
            }
        }
    }

    @Test
    public void test6() {
        boolean result = true && false || true && false;
        System.out.println(result);
    }
}
