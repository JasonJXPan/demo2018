package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by juqi on 19/4/28.
 */
public class RegexTest {

    @Test
    public void test(){
        String x = "尊敬的张三，您的信息我们已经收到，你的编号为01。我们将在近期联系您，确认您的邮寄地址。感谢您的支持！";
//        Pattern pattern = Pattern.compile("尊敬的[^，]*?，您的信息[^，]*?，你的编号为[\\d]+。我们将在近期联系您，确认您的邮寄地址。感谢您的支持！");
        Pattern pattern = Pattern.compile("尊敬的[\\W]*?，您的信息[^，]*?，你的编号为[\\d]+。我们将在近期联系您，确认您的邮寄地址。感谢您的支持！");
        Matcher matcher = pattern.matcher(x);
        System.out.println(matcher.find());
        boolean matches = matcher.matches();
        System.out.println(matches);
        int i = matcher.groupCount();
        System.out.println(i);
        String group = matcher.group();
        System.out.println(group);
    }

    @Test
    public void test1(){
        String url = "http://activityadfasd.aaa.tking.cn/aaa.cn.cn.html";
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        System.out.println(matcher.group()); ;
    }
}
