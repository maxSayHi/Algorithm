package bobo.learn.algorithm.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显式锁学习，Lock是除了synchronized以外,java提供的另一种锁
 * jvm内置了synchronized，Lock需要显示声明调用
 */
public class LockLearn {

    static ReentrantLock lock1 =new ReentrantLock();
    static ReentrantLock lock2 =new ReentrantLock();
    private static Thread t1;
    private static Thread t2;

    public static void testLock(){
        t1 = new Thread(new LockOne());
        t2 = new Thread(new LockTwo());

        t1.start();
        t2.start();

    }

    //测试trylock,尝试10s,每秒尝试一次
    public static void testTryLock(){
        t1 = new Thread(new LockOne());
        t2 = new Thread(new LockTry());

        t1.start();
        t2.start();

    }

    //测试trylock+时间
    public static void testTryLockTime(){
        t1 = new Thread(new LockOne());
        t2 = new Thread(new LockTryTime());

        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        testTryLockTime();
    }

    static class LockOne implements Runnable{

        @Override
        public void run() {
            while (true){
                lock1.lock();
                System.out.println("ThreadOne lock1 locked");
                try {
                    Thread.sleep(1000);
//                    t2.interrupt();
                    lock2.lock();
                    try{
                        System.out.println("ThreadOne lock2 locked");
                    }finally {
                        lock2.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock1.unlock();
                }


            }
        }
    }

    static class LockTwo implements Runnable{

        @Override
        public void run() {
            while (true){
                lock2.lock();
                System.out.println("lock2 locked");
                try {
                    Thread.sleep(500);
                    lock1.lock();
                    try{
                        System.out.println("lock1 locked");
                    }finally {
                        lock1.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock2.unlock();
                }

            }
        }
    }

    static class LockTry implements Runnable{

        @Override
        public void run() {
            long start=System.currentTimeMillis();
            while (true){
                if(lock2.tryLock()) {
                    System.out.println("lock2 locked");
                    try {
                        Thread.sleep(500);
                        if(lock1.tryLock()) {
                            try {
                                System.out.println("lock1 locked");
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                    }

                }

                //每间隔1秒尝试一次，10次之后放弃
                if(System.currentTimeMillis()-start>10000)
                    return;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class LockTryTime implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    if(lock2.tryLock(2, TimeUnit.SECONDS)) {
                        System.out.println("lock2 locked");
                        try {
                            Thread.sleep(500);
                            if(lock1.tryLock(2, TimeUnit.SECONDS)) {
                                try {
                                    System.out.println("lock1 locked");
                                } finally {
                                    lock1.unlock();
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock2.unlock();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}