package com.pjx.demo2018.dailytest.thread;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/30
 */
public class VolatileMain extends Thread {
    private volatile boolean keepRunning = true;

    public void run(){
        System.out.println("Thread starts");
        while (keepRunning) {
            System.out.println("Going to sleep");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stops");
    }
    public void stopThread() {
        this.keepRunning = false;
    }

    public static void main(String[] args) {
        VolatileMain main = new VolatileMain();
        main.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Going to set keepRunning flag");
        main.stopThread();
    }
}
