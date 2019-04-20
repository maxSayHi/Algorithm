package bobo.learn.algorithm.thread;

import org.junit.Test;
import java.util.concurrent.CountDownLatch;

public class ProducerConsumer {

    private final CountDownLatch countDownLatch = new CountDownLatch(4);
    private int items=100;

    private void comsume(){
        items--;
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100000000;i++)
                items++;
        }
    }

    class Comsumer implements Runnable{
        public int count;
        @Override
        public void run() {

            synchronized (ProducerConsumer.this){
                while(items>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    comsume();
                    count++;
                }
                System.out.println(Thread.currentThread().getName()+": "+count);
                countDownLatch.countDown();
            }

        }
    }

    public void testProduce(){
//        new Producer().run();
        Comsumer c1 = new Comsumer();
        Comsumer c2 = new Comsumer();
        Comsumer c3 = new Comsumer();
        Comsumer c4 = new Comsumer();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
        System.out.println(items);
//        try {
//            countDownLatch.await();
//            System.out.println(items);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {
        new ProducerConsumer().testProduce();
    }
}
