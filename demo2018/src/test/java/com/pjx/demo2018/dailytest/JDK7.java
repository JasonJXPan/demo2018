package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Date;

/**
 * Created by juqi on 18/11/1.
 */
public class JDK7 {
    @Test
    public void test(){
        int a = 1_000_000;
        System.out.println(a);
        String x = "ab";
        switch (x) {
            case "a":
                System.out.println("wow");
                break;
            case "ab":
                System.out.println("yee");
                break;
            default:
                break;
        }
        Date date1 = new Date(1541088000000L);
        Date date2 = new Date(1541127600000L);
        System.out.println(date1.compareTo(date2));
    }
}