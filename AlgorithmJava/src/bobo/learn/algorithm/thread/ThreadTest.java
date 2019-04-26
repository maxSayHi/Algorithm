package bobo.learn.algorithm.thread;

import org.junit.Test;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class ThreadTest {

    public static void main(String[] args) {

//        Counter counter = new Counter();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    counter.add();
////                    System.out.println(counter.count);
//                    System.out.println(counter.acount.get());
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    counter.minus();
////                    System.out.println(counter.count);
//                    System.out.println(counter.acount.get());
//                }
//            }
//        }).start();

        new ThreadTest().testSemaphore();
    }


    @Test
    public void testStartThread(){
        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 666;
            }
        });
        new Thread(ft).start();
//        try {
//            Integer integer = ft.get();
//            System.out.println(integer);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("done!");
    }


    Semaphore semaphore = new Semaphore(2,true);


    public void testSemaphore(){
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().interrupt();
                    try {
                        runSemaphore();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void runSemaphore() throws InterruptedException {
        semaphore.acquire();
        System.out.println("running");
        Thread.sleep(1000);
        semaphore.release();
    }
}
