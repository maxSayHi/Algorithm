package bobo.learn.algorithm.thread;

import java.util.concurrent.locks.Lock;

public class DeadLock {
    public static Object obj1=new Object();
    public static Object obj2=new Object();

    public static void main(String[] args) {
        new Thread(new Lock1()).start();
//        new Thread(new Lock2()).start();
    }

    static class Lock1 implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (DeadLock.obj1){
                    try {
                        System.out.println("obj1 locked");
                        Thread.sleep(1000);

                        synchronized (DeadLock.obj2){
                            System.out.println("obj2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Lock2 implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (DeadLock.obj2){
                    try {
                        System.out.println("obj2 locked");
                        Thread.sleep(1000);

                        synchronized (DeadLock.obj1){
                            System.out.println("obj1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
