package com.pjx.demo2018.dailytest.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/30
 */
public class AtomicTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
