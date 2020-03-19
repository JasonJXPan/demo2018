package com.pjx.demo2018.expire;


import java.util.concurrent.Semaphore;

public class NewExample {

    static int result = 0;
    public static void main(String[] args) throws InterruptedException {

        int N = 3;
        final Semaphore[] semaphores = new Semaphore[N];
        for (int i =0; i<N; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != 0) {
                semaphores[i].acquire();
            }
        }

        for (int i=0 ; i<N ; i++) {
            final Semaphore currentSemaphore = semaphores[i];
            final Semaphore nextSemaphore = i ==N-1? semaphores[0]: semaphores[i+1];

            new Thread(() -> {
                while (true) {
                    try {
                        currentSemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":::"+result++);
                    if (result % 101 == 0) {
                        result =0;
                    }
                    nextSemaphore.release();
                }
            }).start();
        }
    }
}
