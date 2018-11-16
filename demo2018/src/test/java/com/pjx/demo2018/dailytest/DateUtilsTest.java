package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by juqi on 18/10/18.
 */
public class DateUtilsTest {

    @Test
    public void test(){
        System.out.println(DateUtils.next(new Date(), 2).after(new Date()));
        Date lastWeekStart = DateUtils.getDayOfLastWeek(1);
        Date lastWeekEnd = DateUtils.endTime(DateUtils.getDayOfLastWeek(7));
        System.out.println(lastWeekStart);
        System.out.println(lastWeekEnd);
        System.out.println(DateUtils.getDayOfLastWeek(3));
        StringBuilder periodName = new StringBuilder();
        periodName.append(DateUtils.format(lastWeekStart, DateUtils.shortFormat));
        periodName.append(" - ");
        periodName.append(DateUtils.format(lastWeekEnd, DateUtils.shortFormat));
        System.out.println(periodName);

        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2018-11-02 11:00:01");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(new Date(4070908800000L));
    }
}
