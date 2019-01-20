package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/12
 */
public class ThreadLocalTest {

    @Test
    public void test() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "threadLocal");
        ThreadLocal<String> threadLocal1 = new ThreadLocal<String>() {
            protected String initialValue() {
                return "threadLocal1";
            }
        };
        ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy"));

        System.out.println(threadLocal.get());
        System.out.println(threadLocal1.get());
        Map<String, String> map = new LinkedHashMap();
        map.put("a", "a");

        Set<String> set = new HashSet<>();
        set.add("a");



    }

}
