package com.pjx.demo2018.expire;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuanFaA {

    @Test
    public void test() {
        //输出100 以内的素数
        List<Integer> list = new ArrayList<>(51);
        list.add(2);
        for (int i = 3; i<100; i+=2) {
            list.add(i);
        }

        List<Integer> result = new ArrayList<>(list.size());
        int size = 1;
        while (size >0) {
            Integer head = list.get(0);
            list.remove(0);
            list = list.stream().filter(x -> x % head!=0 ).collect(Collectors.toList());
            result.add(head);
            size = list.size();
        }
        System.out.println(result);
        System.out.println(result.size());

    }
}
