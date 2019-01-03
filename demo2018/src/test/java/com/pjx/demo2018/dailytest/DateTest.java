package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/25
 */
public class DateTest {

    @Test
    public void test1(){
        Date showTime = new Date();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.setTime(showTime);
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        Date earliestDate = calendar.getTime();
        calendar.setTime(showTime);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        Date latestDate = calendar.getTime();
        System.out.println(showTime);
        System.out.println(currentDate);
        System.out.println(earliestDate);
        System.out.println(latestDate);
    }
}
