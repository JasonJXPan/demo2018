package com.pjx.demo2018.dailytest;

import com.alibaba.fastjson.JSON;
import com.pjx.demo2018.dailytest.util.ObjectOIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by juqi on 18/8/1.
 */
public class ObjectOIDTest {
    @Test
    public void test1(){
        for (int i=0; i < 8; i++) {
            System.out.println(ObjectOIDUtil.generateOID());
        }
        Map<String, String> map = new HashMap<>();
        map.put("COMMON_ORDER", "摩天轮将通知卖家尽快为您出票，请留意订单5状态变化及短信通知，感谢您的支持！");
        map.put("RESERVE_ORDER", "摩天轮将在主办开票后，通知卖家尽快为你出票，请留意订单状态变化及短信通知，感谢您的支持！");
        map.put("AGENT_ORDER", "");
        map.put("PRIME_CARD_ORDER", "更多会员福利等着您");
        String s = JSON.toJSONString(map);
        System.out.println(s);
    }

    @Test
    public void test2(){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<> ();
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        String a = "a";
        String b = "b";
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list.subList(0, 3));
        System.out.println(list.contains("a"));
        System.out.println(list.contains("a1"));
        long x = 0L;
        x = test111();

    }

    public Long test111(){
        return null;
    }
    @Test
    public void test3(){
        int a = 1;
        int b = 1;
        System.out.println(a ==b);
        int a1 = new Integer(200);
        int b1 = new Integer(200);
        System.out.println(a1 == b1);
    }

    @Test
    public void test4() {
        String x = "5c17651ba8e20658c4a0fb1b,5c17651ba8e20658c4a0fb1c,5c17651ba8e20658c4a0fb1d,5c177a31a8e20661834f85cc,5c177a31a8e20661834f85cd,5c177a31a8e20661834f85ce,5c20794ca8e2062e11f601ce,5c20794ca8e2062e11f601cf,5c20794ca8e2062e11f601d0,5c20795fa8e2062e11f601d9,5c20795fa8e2062e11f601da,5c20795fa8e2062e11f601db,5c20795fa8e2062e11f601dc,5c2749090ffd4e225d87c60d,5c2749090ffd4e225d87c60e,5c2749090ffd4e225d87c60f,5b5a951b908c381ad85aa9de,5b5a951b908c381ad85aa9df,5b5a951b908c381ad85aa9e0,5b5a951b908c381ad85aa9e1,5b5a951b908c381ad85aa9e2,5b5a951b908c381ad85aa9e3,5b5a951b908c381ad85aa9e4,5b5a951b908c381ad85aa9e5,5b5a951b908c381ad85aa9e6,5b5a951b908c381ad85aa9e7,5b5a951b908c381ad85aa9e8,5b5a951b908c381ad85aa9e9,5b5a951b908c381ad85aa9ea,5b5a951b908c381ad85aa9eb,5b5a951b908c381ad85aa9ec,5b5a951b908c381ad85aa9ed,5b5a951b908c381ad85aa9ee,5b5a951b908c381ad85aa9ef,5b5a951b908c381ad85aa9f0,5b5a951b908c381ad85aa9f1,5b5a951b908c381ad85aa9f2,5b5a951b908c381ad85aa9f3,5b5a951b908c381ad85aa9f4,5b5a951b908c381ad85aa9f5,5b5a951b908c381ad85aa9f6,5b5a951b908c381ad85aa9f7,5b5a951b908c381ad85aa9f8,5b5a951b908c381ad85aa9f9,5b5a951b908c381ad85aa9fa,5b5a951b908c381ad85aa9fb,5b5a951b908c381ad85aa9fc,5b5a951b908c381ad85aa9fd,5b5a951b908c381ad85aa9fe,5b5a951b908c381ad85aa9ff,5b5a951b908c381ad85aaa00,5b5a951b908c381ad85aaa01,5b5a951b908c381ad85aaa02,5b5a951b908c381ad85aaa03,5b5a951b908c381ad85aaa04,5b5a951b908c381ad85aaa05,5b5a951b908c381ad85aaa06,5b5a951b908c381ad85aaa07,5b5a951b908c381ad85aaa08,5b5a951b908c381ad85aaa09,5b5a951b908c381ad85aaa0a,5b8f7a1f908c3866b022a269,5b8f7a1f908c3866b022a26a,5b8f7a1f908c3866b022a26b,5b8f7a1f908c3866b022a26c,5b8f7a1f908c3866b022a26d,5b8f7a1f908c3866b022a26e,5b8f7a1f908c3866b022a26f,5b8f7a1f908c3866b022a270,5b8f7a1f908c3866b022a271,5b8f7a1f908c3866b022a272,5b8f7a1f908c3866b022a273,5b8f7a1f908c3866b022a274,5b90b60dc756b105bcfda399,5b90b60dc756b105bcfda39a,5b90b60dc756b105bcfda39b,";
        System.out.println(x.contains("5b8f7a1f908c3866b022a2aa"));
    }
    @Test
    public void test5() {
        System.out.println(1<<30);
        System.out.println(Integer.MAX_VALUE);
        Calendar now = Calendar.getInstance();
        DecimalFormat ORDER_NUMBER_FORMAT = new DecimalFormat(
                "0000");
        DecimalFormat MONTH_DAY_FORMAT = new DecimalFormat(
                "00");
        String yearStr = String.valueOf(now.get(Calendar.YEAR));
        String countStr = ORDER_NUMBER_FORMAT.format(99);
        System.out.println("yearStr"+yearStr);

        StringBuffer buffer = new StringBuffer();
        buffer.append("20");
        buffer.append(yearStr.charAt(2)).append(yearStr.charAt(3));
        buffer.append(countStr.charAt(0));
        buffer.append(MONTH_DAY_FORMAT.format(now.get(Calendar.MONTH) + 1));
        buffer.append(countStr.charAt(1)).append(countStr.charAt(2));
        buffer.append(MONTH_DAY_FORMAT.format(now.get(Calendar.DAY_OF_MONTH)));
        System.out.println("now.get(Calendar.DAY_OF_MONTH)"+now.get(Calendar.DAY_OF_MONTH));
        buffer.append(countStr.charAt(3));
        //加一位随机校验码
        buffer.append(new Random().nextInt(10));
        String s = buffer.toString();
        System.out.println(s);
    }

    @Test
    public void test6() {
        String x = "1111";
        String x2 = "2222";
        System.out.println(x.hashCode());
        System.out.println(x2.hashCode());

        System.out.println(StringUtils.join("a", "|", "b"));
    }
}
