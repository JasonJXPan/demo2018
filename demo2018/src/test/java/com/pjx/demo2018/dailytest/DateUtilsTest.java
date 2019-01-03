package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public static long getDiffHours(Date one, Date two) {
        GregorianCalendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        GregorianCalendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 3600000L;
    }
    public static long getDiffMinutes(Date one, Date two) {
        GregorianCalendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        GregorianCalendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 60000L;
    }

    @Test
    public void test2() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = dateFormat.parse("2019-01-03 07:50:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        Calendar calendarParse = Calendar.getInstance();
        calendarParse.setTime(parse);

        System.out.println(getDiffMinutes(calendarParse.getTime(), currentDate));
        System.out.println(getDiffHours(calendarParse.getTime(), currentDate));
    }


}
