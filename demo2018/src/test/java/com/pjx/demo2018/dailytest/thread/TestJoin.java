package com.pjx.demo2018.dailytest.thread;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/2/27
 */
public class TestJoin {

    private static final long count = 10000l;
    public static void main(String[] args) throws InterruptedException {
        concurrency();
    }
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println("thread done");
            }
        });
        thread.start();
        System.out.println("loop starts");
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("loop ends");
        System.out.println("concurrency :" + time+"ms,b="+b);
    }
}