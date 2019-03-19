package com.pjx.demo2018.dailytest.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/19
 */
public class ThreadTest {
    public static int myValue = 1;

    @Test
    public void test() {
        Thread thread = new Thread(ThreadTest::print);
        Thread thread1 = new Thread(ThreadTest::print);
        thread.start();
        thread1.start();
    }

    @Test
    public void test1() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    updateBalance();
                }
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    checkBalance();
                }
            }
        });
        thread1.start();
        try {
            Thread.currentThread().sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    updateBalanceNonSync();
                }
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    checkBalance();
                }
            }
        });
        thread1.start();
        try {
            Thread.currentThread().sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("MyThread Instance - " + name);
        }
    }

    @Test
    public void test3() {
        MyThread thread = new MyThread("myThread1");
        Thread thread1 = new MyThread("myThread2");
        thread.start();
        thread1.start();
        String name = Thread.currentThread().getName();
        try {
            Thread.currentThread().sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }

    class CatchAllExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Exception :" + "--" + e.toString() + "--" + e.getMessage() + "--" + t.getName());
        }
    }

    @Test
    public void test4() {
        CatchAllExceptionHandler exceptionHandler = new CatchAllExceptionHandler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });
        myThread.setUncaughtExceptionHandler(exceptionHandler);
        myThread.start();
        try {
            Thread.currentThread().sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * done 一定会打印 counter不一定打印几个
     */
    @Test
    public void test6() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sleepPrint();
            }
        });
        thread.start();
        System.out.println("done");
    }

    @Test
    public void test7() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sleepPrint();
            }
        });
        thread.start();
        try {
//            thread.join();
            thread.join(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    //线程状态
    @Test
    public void test8() {
        Object syncObject = new Object();
        ThreadState threadState = new ThreadState(syncObject);
        System.out.println("Before start() - t.isAlive()-" + threadState.isAlive());
        System.out.println("#1:" + threadState.getState());

        threadState.start();
        System.out.println("After start() - t.isAlive()-" + threadState.isAlive());
        System.out.println("#2:" + threadState.getState());

        threadState.setWait(true);
        try {
            threadState.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (syncObject) {
            System.out.println("#3:" + threadState.getState());
            threadState.setWait(false);
            syncObject.notifyAll();
        }
        try {
            Thread.currentThread().sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4#:" + threadState.getState());

        threadState.setTimedWait(true);
        try {
            Thread.currentThread().sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (syncObject) {
            System.out.println("#5:" + threadState.getState());
            threadState.setTimedWait(false);
            syncObject.notifyAll();
            System.out.println("#5:" + threadState.getState());
            System.out.println("#5:" + threadState.getState());
            System.out.println("#5:" + threadState.getState());
            System.out.println("#5:" + threadState.getState());
            System.out.println("#5:" + threadState.getState());
        }


        threadState.setKeepRunning(false);

        try {
            Thread.currentThread().sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#6:" + threadState.getState());
        System.out.println("At the end, ts.isAlive()-" + threadState.isAlive());

    }

    @Test
    public void test9() {
        Thread thread = new Thread();
        System.out.println(thread.getPriority());
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread.getPriority());
    }

//    只要当前JVM实例中尚存任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束是，守护线程随着JVM一同结束工作，Daemon作用是为其他线程提供便利服务，守护线程最典型的应用就是GC(垃圾回收器)，他就是一个很称职的守护者。
//    User和Daemon两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果 User Thread已经全部退出运行了，只剩下Daemon Thread存在了，虚拟机也就退出了。 因为没有了被守护者，Daemon也就没有工作可做了，也就没有继续运行程序的必要了
//    不是说当子线程是守护线程，主线程结束，子线程就跟着结束，这里的前提条件是：当前jvm应用实例中没有用户线程继续执行，如果有其他用户线程继续执行，那么后台线程不会中断
//    (1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
//            (2) 在Daemon线程中产生的新线程也是Daemon的。
//            (3) 不要认为所有的应用都可以分配给Daemon来进行服务，比如读写操作或者计算逻辑。
//    写java多线程程序时，一般比较喜欢用java自带的多线程框架，比如ExecutorService，但是java的线程池会将守护线程转换为用户线程，所以如果要使用后台线程就不能用java的线程池。
    @Test
    public void test10() {
        Thread thread = new Thread(ThreadTest::print);
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println("exiting main");
    }
    @Test
    public void test11() {
//        Thread thread = new Thread(ThreadTest::print);
//        thread.setDaemon(false);
//        thread.start();
//        System.out.println(Thread.currentThread().isDaemon());
//        System.out.println("exiting main");

        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread childThread = new Thread(new ChildThread());
                childThread.setDaemon(false);
                childThread.start();
                System.out.println("I'm main thread...");
            }
        });
        mainThread.start();

    }
    //主线程
    public static void main(String[] args) {
//        Thread thread = new Thread(ThreadTest::print);
//        thread.setDaemon(false);
//        thread.start();
//        System.out.println(Thread.currentThread().isDaemon());
//        System.out.println("exiting main");
        //守护线程
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread childThread = new Thread(new ChildThread());
                childThread.setDaemon(true);
                childThread.start();
                System.out.println("I'm main thread...");
            }
        });
        mainThread.start();
//        非守护线程
//        Thread mainThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Thread childThread = new Thread(new ChildThread());
//                childThread.setDaemon(false);
//                childThread.start();
//                System.out.println("I'm main thread...");
//            }
//        });
//        mainThread.start();

        //如果需要在主线程结束时，将子线程结束掉，可以采用如下的中断方式：

//        Thread mainThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Thread sonThread = new Thread(new Thread1(Thread.currentThread()));
//                sonThread.setDaemon(false);
//                sonThread.start();
//                System.out.println("主线程结束");
//            }
//        });
//        mainThread.start();

    }
    class ThreadState extends Thread {
        private boolean keepRunning = true;
        private boolean wait = false;
        private boolean timedWait = false;
        private Object syncObject = null;

        public ThreadState(Object syncObject) {
            this.syncObject = syncObject;
        }

        public void run() {
            while (keepRunning) {
                synchronized (syncObject) {
                    if (wait) {
                        try {
                            syncObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (timedWait) {
                        try {
                            syncObject.wait(20000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public void setKeepRunning(boolean keepRunning) {
            this.keepRunning = keepRunning;
        }

        public void setWait(boolean wait) {
            this.wait = wait;
        }

        public void setTimedWait(boolean timedWait) {
            this.timedWait = timedWait;
        }
    }

    public static void sleepPrint() {
        for (int i = 0; i < 10; i++) {
            System.out.println("counter" + i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void updateBalanceNonSync() {
        System.out.println("start : " + myValue);
        myValue += 1;
        myValue -= 1;
        System.out.println("end : " + myValue);
    }

    public static synchronized void updateBalance() {
        System.out.println("start : " + myValue);
        myValue += 1;
        myValue -= 1;
        System.out.println("end : " + myValue);
    }

    public static synchronized void checkBalance() {
        int b = myValue;
        if (b != 1) {
            System.out.println("changed : " + b);
            System.exit(1);
        }
    }

    public static void print() {
        for (int i = 0; i <= 500; i++) {
            System.out.println(i);
        }
    }

    //关于interruted 和isInterripted 参考
//    https://www.cnblogs.com/forfreewill/p/9111162.html
    @Test
    public void test12() {
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().interrupted());
    }

    @Test
    public void test13(){
        Thread thread = new Thread(ThreadTest::counter);
        thread.start();
        try {
            Thread.currentThread().sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
    public static void counter() {
        int counter = 0;
        while (!Thread.interrupted()) {
            counter ++;
        }
        System.out.println(counter);
    }

    //中断一个被阻塞的线程
    @Test
    public void test14() {
        Thread thread = new Thread(ThreadTest::interruptedRun);
        thread.start();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void interruptedRun() {
        int counter = 1;
        while (true) {
            try {
                Thread.sleep(1000L);
                System.out.println(counter);
            } catch (InterruptedException e) {
                System.out.println("I got interrupted");
            }
        }
    }

    @Test
    public void 线程组1(){
        Thread thread = Thread.currentThread();
        ThreadGroup threadGroup = thread.getThreadGroup();
        System.out.println(thread.getName());
        System.out.println(threadGroup.getName());
        Thread thread1 = new Thread("Thread1");
        System.out.println(thread1.getName());
        System.out.println(thread1.getThreadGroup().getName());
    }
    @Test
    public void 线程组2() {
        ThreadGroup threadGroup = new ThreadGroup("abc");
        Thread thread = new Thread(threadGroup, "threadA");
        System.out.println(thread.getThreadGroup().getName());
    }

    @Test
    public void volatile测试1() {
        //我们可以只声明一个类成员变量，实例或静态字段，作为volatile。
        //我们可以使用volatile变量作为标志来停止线程。



    }

    @Test
    public void test123() {

    }

    public static synchronized void ab(){

    }
}
class ChildThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("I'm child thread...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread1 implements Runnable{
    private Thread mainThread;
    public Thread1(Thread thread) {
        this.mainThread = thread;
    }
    @Override
    public void run() {
        while (mainThread.isAlive()) {
            System.out.println("子线程运行中。。。");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}