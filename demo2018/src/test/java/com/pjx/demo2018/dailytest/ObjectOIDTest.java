package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.util.ObjectOIDUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by juqi on 18/8/1.
 */
public class ObjectOIDTest {
    @Test
    public void test1(){
        for (int i=0; i < 4; i++) {
            System.out.println(ObjectOIDUtil.generateOID());
        }
    }

    @Test
    public void test2(){
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        String a = "a";
        String b = "b";
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
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
}
