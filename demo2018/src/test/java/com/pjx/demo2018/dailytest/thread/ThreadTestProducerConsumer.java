package com.pjx.demo2018.dailytest.thread;

import org.junit.Test;

import java.util.Random;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/19
 */
public class ThreadTestProducerConsumer {

    @Test
    public void test(){
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();
    }

    class Consumer extends Thread {
        private Buffer buffer;
        public Consumer(Buffer buffer){
            this.buffer = buffer;
        }
        public void run() {
            int data;
            while (true) {
                data = buffer.consume();
            }
        }
    }

    class Producer extends Thread {
        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }
        public void run(){
            Random random = new Random();
            while (true) {
                int n = random.nextInt();
                buffer.produce(n);
            }
        }
    }

    class Buffer {
        private int data;
        private boolean empty;

        public Buffer() {
            this.empty = true;
        }

        public synchronized void produce(int newData) {
            while (this.empty) {

                this.data = newData;
                this.empty = false;
                this.notify();
                System.out.println("produced: "+newData);
            }
            while (!this.empty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public synchronized int consume() {
            while (!this.empty) {

                this.empty = true;
                this.notify();
                System.out.println("consumed: "+data);
                return data;
            }
            while (this.empty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
    }
}
