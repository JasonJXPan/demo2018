package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by juqi on 18/10/17.
 */
public class CalendarTest {

    @Test
    public void test(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        System.out.println(c.getTime());
    }

    @Test
    public void test1() {
        Calendar current = Calendar.getInstance();
        System.out.println(current.getTime());
        current.set(Calendar.HOUR_OF_DAY, current.get(Calendar.HOUR_OF_DAY )-1);
        System.out.println(current.getTime());
    }
}
