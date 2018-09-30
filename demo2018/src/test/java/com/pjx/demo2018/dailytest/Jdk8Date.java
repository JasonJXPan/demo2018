package com.pjx.demo2018.dailytest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by juqi on 18/9/29.
 */
public class Jdk8Date {
    @Test
    public void test1(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
    }
}
