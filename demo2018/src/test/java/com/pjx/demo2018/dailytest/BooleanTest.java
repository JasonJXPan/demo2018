package com.pjx.demo2018.dailytest;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

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
}
