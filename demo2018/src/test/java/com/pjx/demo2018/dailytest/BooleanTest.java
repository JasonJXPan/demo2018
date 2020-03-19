package com.pjx.demo2018.dailytest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.BooleanUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by juqi on 18/9/20.
 */
public class BooleanTest {
    @Test
    public void test1() {
        Boolean b1 = null;
        System.out.println(BooleanUtils.isTrue(b1));
        Boolean b2 = false;
        System.out.println(BooleanUtils.isTrue(b2));
        Boolean b3 = true;
        System.out.println(BooleanUtils.isTrue(b3));
    }

    @Test
    public void test2(){
        Boolean result = null;
        String key = "a"+"-" + result;
        System.out.println(key);
        result = true;
        key = "a"+"-" + result;
        System.out.println(key);
        result = false;
        key = "a"+"-" + result;
        System.out.println(key);
    }

    @Test
    public void test3() throws JSONException, IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("isDefault", false);
        System.out.println(BooleanUtils.isTrue((Boolean) map.get("isDefault")));
        String x = "{\"SHOW_NAME\":\"【杭州站】孟京辉戏剧作品《两只狗的生活意见》\",\"SHOW_TIME\":\"2019-11-21 19:30\",\"VENUE_NAME\":\"杭州蜂巢剧场（杭杂小剧场）\",\"ARRIVE_TIME\":\"提前一小时\",\"TIPS\":\"温馨提醒：由于现场票务特殊性，最晚取票时间截止为开场后半小时。(摩天轮要求商家不能以任何名义与用户私下协商退补票款，如遇问题，请联系客服热线：10102266)\",\"ADDRESS\":\"沈塘桥路18号\",\"VENUE_CONTACT\":\"票票侠\",\"SELLER_PHONE\":\"15867154605\"}";
        System.out.println(Map2JsonString(map));
        Map map1 = JsonString2Map(x);
        map1.put("SHOW_TIME", "时间待定");
        System.out.println(Map2JsonString(map1));

    }

    public static Map JsonString2Map(String obj) throws JSONException, IOException {
        return (Map)(new ObjectMapper()).readValue(String.valueOf(new JSONObject(obj)), HashMap.class);
    }
    public static String Map2JsonString(Map obj) throws JSONException {
        return (new JSONObject(obj)).toString();
    }
}
