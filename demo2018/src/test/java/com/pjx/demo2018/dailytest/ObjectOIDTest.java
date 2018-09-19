package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.util.ObjectOIDUtil;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by juqi on 18/8/1.
 */
public class ObjectOIDTest {
    @Test
    public void test1(){
        System.out.println(ObjectOIDUtil.generateOID());
    }

    @Test
    public void test2(){
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }
}
