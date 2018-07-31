package com.pjx.demo2018.dailytest;

import com.pjx.demo2018.dailytest.util.StringProcessUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
}
