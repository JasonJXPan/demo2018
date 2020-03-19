package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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

    @Test
    public void test3() {
        Date date = DateUtils.addDays(new Date(), -2);
        System.out.println(date);
    }


    @Test
    public void test4() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = dateFormat.parse("2019-01-28 15:28:43");
            boolean after = DateUtils.next(parse, 2).after(new Date());
            System.out.println(after);
        } catch (ParseException e) {

        }
        try {
            Object dateUtilsTest = Class.forName("com.pjx.demo2018.dailytest.DateUtilsTest").newInstance();
            DateUtilsTest dateUtilsTest1 = (DateUtilsTest) dateUtilsTest;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2020-02-16 11:00";
        String datex = "2020-02-16 11:00:00";
        Date date1 = DateUtils.parseNoSecondFormat(date);
        Date date2 = DateUtils.parseDateNewFormat(datex);
        System.out.println(date1);
        System.out.println(date2);

        long diffMinutes = DateUtils.getDiffMinutes(date1, date2);
        System.out.println(date1.equals(date2));
        System.out.println(diffMinutes);

        System.out.println(DateUtils.getNoSecondDateString(date1));

        String xingQiFormatNoSecond = DateUtils.getXingQiFormatNoSecond(date1);
        System.out.println(xingQiFormatNoSecond);

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
////        executorService.
//        ThreadLocal

    }

    @Test
    public void test6() {
        System.out.println("2"+7);
    }

}
