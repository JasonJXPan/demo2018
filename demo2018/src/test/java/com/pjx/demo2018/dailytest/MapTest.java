package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by juqi on 18/10/26.
 */
public class MapTest {

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", new Date());
        map.put("b", null);
        Date a = (Date) map.get("a");
        Date b = (Date) map.get("b");
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test1() {
//        Map<String, BigDecimal> priceItemMap = new LinkedHashMap<>();
//        for (Map.Entry<String, BigDecimal> fee : priceItemMap.entrySet()) {
//
//        }

        try {
            Date sessionTime = DateUtils.parseDateNoTime("2019-08-06 15:00", "yyyy-MM-dd HH:mm");
            System.out.println(sessionTime);
            System.out.println(DateUtils.addMinutes(sessionTime, 10));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer integer = -199;
        System.out.println(Math.abs(integer));
    }

    @Test
    public void test2() {
        Map<String, Integer> priceItemMap = new LinkedHashMap<>();
        System.out.println(priceItemMap.get("a"));

        Integer a = priceItemMap.getOrDefault("a", 0);
        System.out.println(a);
        a++;
        priceItemMap.put("a", a);
        System.out.println(priceItemMap.get("a"));

        System.out.println(StringUtils.join("a", "-", "b"));

    }
}
