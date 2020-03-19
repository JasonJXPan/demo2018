package com.pjx.demo2018.expire;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTestTest {


    public static void main(String[] args) throws InterruptedException {

        int n = 3;
        Lock lock = new ReentrantLock();

        List<Condition> locks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Condition condition = lock.newCondition();
            if (i !=0) {
                condition.await();
            }
            locks.add(condition);
        }

        Condition currentLock = null;
        Condition nextLock = null;
        for (int i = 0; i < n; i++) {
//            currentLock = locks.get(i);
//            if (i == n -1) {
//                nextLock = locks.get(0);
//            }else {
//                nextLock = locks.get(i+1);
//            }
            System.out.println(i);
            new Thread(new MyThread("thread" + i, 100,0, i, locks.get(i), i == n -1?  locks.get(0): locks.get(i+1), lock)).start();
//            new Thread(new MyThread("thread" + i, 100, 0, i, lock, lock)).start();
        }

    }

    static class MyThread implements Runnable {

        private volatile int currentNumber = 0;
        private int total = 100;
        private int myNumber;
        private String threadName;
        private Condition currentLock;
        private Condition nextLock;
        private Lock lock;

        public MyThread(String threadName, int total, int currentNumber, int myNumber, Condition currentLock, Condition nextLock, Lock lock) {
            this.threadName = threadName;
            this.total = total;
            this.currentNumber = currentNumber;
            this.myNumber = myNumber;
            this.currentLock = currentLock;
            this.nextLock = nextLock;
            this.lock = lock;
        }

        @Override
        public void run() {

            while (true) {
                lock.lock();

                System.out.println(Thread.currentThread().getName() + "currentNumber" + currentNumber);
                System.out.println(Thread.currentThread().getName() + "myNumber" + myNumber);
                if (currentNumber % total == myNumber) {
//                    synchronized (currentLock) {
                        if (currentNumber % total == myNumber) {
                            System.out.println(threadName + ": " + currentNumber);
                            currentNumber++;
//                            currentLock.notifyAll();
                            nextLock.signal();
                            System.out.println(Thread.currentThread().getName() + "currentNumber" + currentNumber);
                        }
//                    }
                }else {
                    try {
                        currentLock.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();

            }
//                System.out.println("myNumber"+myNumber);


        }
    }


}
