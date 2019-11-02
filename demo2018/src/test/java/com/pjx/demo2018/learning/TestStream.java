package com.pjx.demo2018.learning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    @Test
    public void testPrac1() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        List<Integer> list = integerStream.collect(Collectors.toList());

        List<Integer> collect = list.stream().map((x) -> x * x)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


    }

    @Test
    public void testCreate() {
        //创建stream

        //集合
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 通过Arrays
        Integer [] integers = new Integer [10];
        Stream<Integer> stream1 = Arrays.stream(integers);

        // 通过 stream 静态方法
        Stream<String> a = Stream.of("a", "b");

        //无限流
        Stream.iterate(0, (i) -> i + 2)
        .limit(2)
        .forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(3)
                .forEach(System.out :: println);
    }

    @Test
    public void test () {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> collect = list.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println(collect);

    }
}
