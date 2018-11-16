package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.*;

/**
 * Created by juqi on 18/9/25.
 */
public class CollectionTest {
    @Test
    public void test1(){
        Set<String> set = null;
        Set<String> all = new HashSet<>();
        all.add("a");
        all.add("B");
        all.removeAll(set);
        System.out.println(all);
    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list);
        list.addAll(Collections.emptyList());
        System.out.println(list);
    }
}
