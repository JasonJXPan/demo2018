package com.pjx.demo2018.dailytest.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/26
 */
public class ThreadPoolTest {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        AtomicInteger
    }
}