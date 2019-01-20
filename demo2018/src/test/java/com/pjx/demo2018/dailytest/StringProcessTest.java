package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pjx.demo2018.dailytest.util.StringProcessUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test7() {
        String a = "123";
        String b = "123";
        System.out.println(a==b);
    }

    @Test
    public void test8() {
        String a = "a";
        String b = null;
        int c = 4;
        String d = "d";
        String e = "e";
        Object[] objects = new Object[]{a ,b, c, d, e};
        System.out.println(StringUtils.join(a, b, c, d, e));
        System.out.println(StringUtils.join(objects, "-"));
    }
    @Test
    public void test9() {
        ExtentionDTO dto = new ExtentionDTO();
        dto.setServiceFeeSwitch(true);
        String string = JSON.toJSONString(null);
        System.out.println(string);
        ExtentionDTO jsonObject = JSON.parseObject(string,ExtentionDTO.class);
        System.out.println(jsonObject);

        System.out.println(JSON.toJSONString(new ExtentionDTO()));
        System.out.println(JSON.toJSONString(null));
        String x = "{\"serviceFeeSwitch\":false}";
        System.out.println(x);
        ExtentionDTO extentionDTO = JSON.parseObject(x, ExtentionDTO.class);
        System.out.println(extentionDTO);
    }
    class ExtentionDTO implements Serializable {

        private static final long serialVersionUID = 5302100609886058646L;

        private boolean serviceFeeSwitch;

        public boolean getServiceFeeSwitch() {
            return serviceFeeSwitch;
        }

        public void setServiceFeeSwitch(boolean serviceFeeSwitch) {
            this.serviceFeeSwitch = serviceFeeSwitch;
        }

        private List<A> a;


        public List<A> getA() {
            return a;
        }

        public void setA(List<A> a) {
            this.a = a;
        }

    }
    class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void test10() {

        String x = "您抢购的[SHOW_NAME SHOW_TIME ORDER_QTY张]已取消，支付金额会在2-3个工作日内原路退还到您的账户中。摩天轮票务不会以订单无效、支付异常等为由，要求您提供银行卡信息、退款或进行银行间操作，谨防诈骗。";

        System.out.println(x.replace("SHOW_NAME", "演出啊"));
        System.out.println(x);
    }
}
