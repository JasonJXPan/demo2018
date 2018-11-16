package com.pjx.demo2018.dailytest.jdk8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by juqi on 18/9/30.
 */
public class LocalDate1 {

    @Test
    public void test1(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println(today);
        System.out.println(tomorrow);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
}
