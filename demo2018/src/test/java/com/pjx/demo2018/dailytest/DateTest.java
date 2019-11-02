package com.pjx.demo2018.dailytest;

import com.juqitech.service.utils.BigDecimalUtil;
import com.juqitech.service.utils.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
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

    @Test
    public void test2() {
        System.out.println(new Date().getHours());
        System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        BigDecimal bigDecimal = new BigDecimal("62.10");
        System.out.println(bigDecimal.setScale(0, BigDecimal.ROUND_UP));
    }
    @Test
    public void test3() {
        System.out.println(DateUtils.parseWebFormat("1564502400000"));
    }
    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        System.out.println(calendar.getTime());
    }
}
