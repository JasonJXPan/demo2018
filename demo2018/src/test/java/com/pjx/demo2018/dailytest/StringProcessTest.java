package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.pjx.demo2018.dailytest.util.StringProcessUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test11() {

        String x = "{launch_day=3, top_180d=0, tools_90d=0, car_180d=0, education_180d=0, tail_7d=0, education_7d=0, ip_90d=3, app_stability_90d=3, tools_7d=0, education_90d=0, travel_180d=0, sns_180d=0, travel_90d=0, car_7d=0, shopping_7d=2, loan_7d=0, entertainment_7d=0, shopping_90d=4, reading_180d=0, game_7d=0, service_90d=0, tail_90d=0, shopping_180d=2, service_180d=0, sns_7d=0, province_freq=310000, tools_180d=0, finance_7d=0, property_90d=0, reading_7d=0, car_90d=0, sns_90d=0, game_180d=0, city_freq=310100, woman_90d=0, country_freq=156, woman_180d=0, loan_90d=0, loan_180d=0, device_price=5, top_90d=0, reading_90d=0, finance_90d=0, property_180d=0, property_7d=0, entertainment_180d=0, woman_7d=0, app_stability_7d=3, app_stability_180d=2, service_7d=0, country_rec=156, province_rec=310000, finance_180d=0, entertainment_90d=0, health_90d=0, device_os=ios, health_7d=0, travel_7d=0, game_90d=0, device_brand=苹果, health_180d=0, tail_180d=0, top_7d=0, city_rec=310100, device_rank=0, status=0}";

        Gson gson = new Gson();
        Map aliDataOut = gson.fromJson(x, Map.class);
        System.out.println(aliDataOut);
        System.out.println(aliDataOut.keySet());
//        System.out.println(aliDataOut.getCode()+"-"+aliDataOut.getValue().getLaunch_day()+"-"+aliDataOut.getValue().getTop_180d());

    }
    @Test
    public void test12() {

        String x = "[{cellphone=13916906202,data={code=200, value={launch_day=3, top_180d=0, tools_90d=0, car_180d=0, education_180d=0, tail_7d=0, education_7d=0, ip_90d=3, app_stability_90d=3, tools_7d=0, education_90d=0, travel_180d=0, sns_180d=0, travel_90d=0, car_7d=0, shopping_7d=2, loan_7d=0, entertainment_7d=0, shopping_90d=4, reading_180d=0, game_7d=0, service_90d=0, tail_90d=0, shopping_180d=2, service_180d=0, sns_7d=0, province_freq=310000, tools_180d=0, finance_7d=0, property_90d=0, reading_7d=0, car_90d=0, sns_90d=0, game_180d=0, city_freq=310100, woman_90d=0, country_freq=156, woman_180d=0, loan_90d=0, loan_180d=0, device_price=5, top_90d=0, reading_90d=0, finance_90d=0, property_180d=0, property_7d=0, entertainment_180d=0, woman_7d=0, app_stability_7d=3, app_stability_180d=2, service_7d=0, country_rec=156, province_rec=310000, finance_180d=0, entertainment_90d=0, health_90d=0, device_os=ios, health_7d=0, travel_7d=0, game_90d=0, device_brand=苹果, health_180d=0, tail_180d=0, top_7d=0, city_rec=310100, device_rank=0, status=0}}},,{cellphone=13969785452,data={code=200, value={launch_day=3, top_180d=6, tools_90d=5, car_180d=0, education_180d=0, tail_7d=4, education_7d=0, ip_90d=10, app_stability_90d=3, tools_7d=2, education_90d=1, travel_180d=1, sns_180d=2, travel_90d=0, car_7d=0, shopping_7d=0, loan_7d=0, entertainment_7d=2, shopping_90d=1, reading_180d=6, game_7d=0, service_90d=5, tail_90d=3, shopping_180d=3, service_180d=4, sns_7d=0, province_freq=370000, tools_180d=5, finance_7d=0, property_90d=1, reading_7d=5, car_90d=0, sns_90d=0, game_180d=0, city_freq=370600, woman_90d=1, country_freq=156, woman_180d=4, loan_90d=0, loan_180d=0, device_price=4, top_90d=6, reading_90d=7, finance_90d=0, property_180d=1, property_7d=0, entertainment_180d=5, woman_7d=0, app_stability_7d=7, app_stability_180d=2, service_7d=2, country_rec=156, province_rec=370000, finance_180d=2, entertainment_90d=3, health_90d=0, device_os=android, health_7d=0, travel_7d=0, game_90d=0, device_brand=华为, health_180d=0, tail_180d=5, top_7d=4, city_rec=370200, device_rank=0, status=0}}}]";

        Gson gson = new Gson();
        AliJueCe[] aliDataOut = gson.fromJson(x, AliJueCe[].class);

        System.out.println(gson.toJson(aliDataOut));
//        System.out.println(gson.toJson(aliDataOut));
//        System.out.println(aliDataOut.getCode()+"-"+aliDataOut.getValue().getLaunch_day()+"-"+aliDataOut.getValue().getTop_180d());
//        List<AliJueCe> aliJueCes = JSON.parseArray(x, AliJueCe.class);
//        AliJueCe aliJueCe = JSON.parseObject(x, AliJueCe.class);
//        System.out.println(JSON.toJSONString(aliJueCe));

    }

    @Test
    public void test13() {
        System.out.println(null == null);
    }

    @Test
    public void test14() {
        String temp = "%s折扣";
        String result = String.format(temp, "什么玩意");
        System.out.println(result);
    }

    @Test
    public void test15() {
        String x = "abc";
        System.out.println(StringUtils.substring(x, 0, 2));
    }

    @Test
    public void test16() {
        String refundRatioPreDelimiter = "实际退款比例";
        String refundRatioPostDelimiter = "%)";
        String x = "用户原因-客户有责退款-(建议退款比例:85%,实际退款比例86%)";
        System.out.println(StringUtils.substringBetween(x, refundRatioPreDelimiter, refundRatioPostDelimiter));
        System.out.println(Integer.parseInt(StringUtils.substringBetween(x, refundRatioPreDelimiter, refundRatioPostDelimiter)));
        System.out.println(Integer.parseInt(null));
        System.out.println(StringUtils.equals(StringUtils.substringBetween(x, refundRatioPreDelimiter, refundRatioPostDelimiter), "null"));
    }
    @Data
    class AliJueCe {
        private String cellphone;
        private AliDataOut data;
    }
    @Data
    class AliDataOut {
        private String code;
        private AliDataIn value;
    }
    @Data
    class AliDataIn {
        private String launch_day;
        private String top_180d;
        private String tools_90d;
        private String car_180d;
        private String education_180d;
        private String tail_7d;
        private String education_7d;
        private String ip_90d;
        private String app_stability_90d;
        private String tools_7d;
        private String education_90d;
        private String travel_180d;
        private String sns_180d;
        private String travel_90d;
        private String car_7d;
        private String shopping_7d;
        private String loan_7d;
        private String entertainment_7d;
        private String shopping_90d;
        private String reading_180d;
        private String game_7d;
        private String service_90d;
        private String tail_90d;
        private String shopping_180d;
        private String service_180d;
        private String sns_7d;
        private String province_freq;
        private String tools_180d;
        private String finance_7d;
        private String property_90d;
        private String reading_7d;
        private String car_90d;
        private String sns_90d;
        private String game_180d;
        private String city_freq;
        private String woman_90d;
        private String country_freq;
        private String woman_180d;
        private String loan_90d;
        private String loan_180d;
        private String device_price;
        private String top_90d;
        private String reading_90d;
        private String finance_90d;
        private String property_180d;
        private String property_7d;
        private String entertainment_180d;
        private String woman_7d;
        private String app_stability_7d;
        private String app_stability_180d;
        private String service_7d;
        private String country_rec;
        private String province_rec;
        private String finance_180d;
        private String entertainment_90d;
        private String health_90d;
        private String device_os;
        private String health_7d;
        private String travel_7d;
        private String game_90d;
        private String device_brand;
        private String health_180d;
        private String tail_180d;
        private String top_7d;
        private String city_rec;
        private String device_rank;
        private String status;
    }



}
