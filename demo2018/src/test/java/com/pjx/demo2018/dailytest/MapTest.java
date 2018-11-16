package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
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
}
