package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by juqi on 19/6/12.
 */
public class ArraysTest {
    @Test
    public void test1() {
        char[] value = new char[10];
        for (int i=0; i<10; i++) {
            value[i]= '1';
        }
        System.out.println(value);

        char[] newValue = Arrays.copyOf(value, 20);
        System.out.println(newValue);
        System.out.println(value);
        System.out.println(value==newValue);
    }

}
