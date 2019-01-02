package bobo.learn.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public int count=100;
    public AtomicInteger acount=new AtomicInteger(100);

    public void add(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        acount.incrementAndGet();
    }

    public void minus(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        acount.decrementAndGet();
    }
}
