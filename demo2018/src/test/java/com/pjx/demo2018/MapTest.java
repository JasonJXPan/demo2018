package com.pjx.demo2018;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by juqi on 18/9/23.
 */
public class MapTest {
    @Test
    public void test1(){
        Map<String, String> map = new HashMap<>();
        String aNull = map.put(null, "null");
        //空指针 null
        System.out.println(aNull);
//        String null
        String null1 = map.put(null, "null1");
        System.out.println(null1);
//        String null1
        String null2 = map.put(null, "null2");
        System.out.println(null2);
    }
    @Test
    public void test2(){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        //key和value都不允许添加null
//        concurrentHashMap.put(null, null);
    }
}
