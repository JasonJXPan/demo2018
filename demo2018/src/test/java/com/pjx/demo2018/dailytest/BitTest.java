package com.pjx.demo2018.dailytest;

import org.junit.Test;

import java.util.Collections;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/22
 */
public class BitTest {
    @Test
    public void test1() {
        int i = 32;
        System.out.println(i >>1);
        System.out.println(i >>2);
        System.out.println(i >>3);
        System.out.println(i <<1);

    }
}
