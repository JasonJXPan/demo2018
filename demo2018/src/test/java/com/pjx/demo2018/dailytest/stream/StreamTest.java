package com.pjx.demo2018.dailytest.stream;

import com.pjx.demo2018.dailytest.stream.dto.StreamTestDTO;
import com.pjx.demo2018.dailytest.stream.po.StreamTestPO;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        for (int i=0; i<500;i++) {
            LIST.add(i+"");
        }
    }
    @Test
    public void test1(){
        Long begin = Calendar.getInstance().getTimeInMillis();
        LIST.stream().forEach(item -> System.out.print(item));
        System.out.println();
        System.out.println("stream().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        LIST.stream().parallel().forEach(item -> System.out.print(item));
        System.out.println();
        System.out.println("stream().parallel().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        LIST.parallelStream().forEach(item -> System.out.print(item));
        System.out.println();
        System.out.println("parallelStream().forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        for (String x : LIST) {
            System.out.print(x);
        }
        System.out.println();
        System.out.println("iterator.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        for (int i=0; i<LIST.size();i++) {
            System.out.print(LIST.get(i));
        }
        System.out.println();
        System.out.println("standard.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
        begin = Calendar.getInstance().getTimeInMillis();
        Iterator<String> iterator = LIST.iterator();
        for (int i=0 ;i < LIST.size(); i++) {
            System.out.print(iterator.next());
        }
        System.out.println();
        System.out.println("standard+iterator.forEach:"+((Calendar.getInstance().getTimeInMillis()) - begin));
    }

    @Test
    public void test2(){
        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        Optional<String> longest = names
                .filter(name -> name.startsWith("L"))
                .findFirst();

        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(x -> System.out.println(x));
        Stream<String> stringStream = list.stream().filter(x -> x.equals("1"));
        System.out.println(stringStream.findAny());
        List<String> collect = list.stream().filter(x -> x.equals("1")|| x.equals("2")).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test3() {
        Stream<String> a = Stream.of("a", "a", "b", "v");
        Set<String> collect = a.collect(Collectors.toSet());
        System.out.println(collect);
        Stream<String> a1 = Stream.of("a", "a", "b", "v");
        Stream<String> distinct = a1.distinct();
        List<String> collect1 = distinct.collect(Collectors.toList());
        System.out.println(collect1);

    }

    @Test
    public void test4() {
        List<StreamTestPO> pos = new ArrayList<>();
        StreamTestPO po1 = new StreamTestPO();
        po1.setOrderId("order1");
        po1.setShowId("show1");
        StreamTestPO po2 = new StreamTestPO();
        po2.setOrderId("order2");
        po2.setShowId("show2");
        pos.add(po1);
        pos.add(po2);

        List<StreamTestDTO> collect = pos.parallelStream().map(StreamTestDTO::new).collect(Collectors.toList());
        System.out.println(collect);

    }

}
