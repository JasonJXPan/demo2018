package com.pjx.demo2018.dailytest.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * 结论1：stream()方法不能随便用 可能效率很低， 而且有大小限制
 * Created by juqi on 18/8/20.
 */
public class StreamTest {
//    public static String CONTENT = "遍历是一个基本的功能。所有编程语言都提供了简单的语法，让程序员去遍历容器。Steam API 以一种非常直接的形式来遍历容器。使用 C 语言形式的 for 循环，JVM 每次仅仅增加一个数字，然后直接从内存里读出数据。这使得它非常迅速。但是 forEach 就大不一样，根据 StackOverFlow 的这篇回答，和 Oracle 的文章，JVM 需要把 forEach 转换成一个 iterator，然后每个元素都调用一次 hasNext() 方法。这就是 forEach 比 C 语言的形式慢一些的原因。";
    public static List<String> LIST = new ArrayList<>();
    @Before
    public void before(){
//        for (Character c : CONTENT.toCharArray()) {
//            LIST.add(String.valueOf(c));
//        }
        for (int i=0; i<50000;i++) {
            LIST.add(i+"");
        }
    }
    @Test
    public void test1(){
        Long begin = Calendar.getInstance().getTimeInMillis();
        LIST.stream().forEach(item -> System.out.print(item));
        System.out.println("stream().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        LIST.stream().parallel().forEach(item -> System.out.print(item));
        System.out.println("stream().parallel().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        LIST.parallelStream().forEach(item -> System.out.print(item));
        System.out.println("parallelStream().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        for (String x : LIST) {
            System.out.print(x);
        }
        System.out.println("iterator.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        for (int i=0; i<LIST.size();i++) {
            System.out.print(LIST.get(i));
        }
        System.out.println("standard.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        Iterator<String> iterator = LIST.iterator();
        for (int i=0 ;i < LIST.size(); i++) {
            System.out.print(iterator.next());
        }
        System.out.println("standard+iterator.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
    }

    @Test
    public void test2(){

    }

}