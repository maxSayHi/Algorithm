package bobo.learn.algorithm.thread;

import sun.awt.windows.ThemeReader;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class SBuf {

    private static SBuf.sbuf_t sbuf_t;

    static class sbuf_t{
        int buf[];
        int n;
        int front;
        int rear;
        Semaphore mutex;
        Semaphore slots;
        Semaphore items;
    }

    public SBuf(sbuf_t sp,int n){
        sp.buf=new int[n];
        sp.n=n;
        sp.front=sp.rear=0;
        sp.mutex=new Semaphore(1);
        sp.slots=new Semaphore(n);
        sp.items=new Semaphore(0);
    }

    public void sbuf_insert(sbuf_t sp,int item) throws InterruptedException {
        sp.slots.acquire();
        sp.mutex.acquire();
        sp.buf[(++sp.rear)%(sp.n)]=item;
        sp.mutex.release();
        sp.items.release();
    }

    public int sbuf_remove(sbuf_t sp) throws InterruptedException {
        int item;
        sp.items.acquire();
        sp.mutex.acquire();
        item=sp.buf[(++sp.front)%(sp.n)];
        sp.mutex.release();
        sp.slots.release();
        return item;
    }

    public static void main(String[] args) {

        sbuf_t = new sbuf_t();
        final SBuf sBuf = new SBuf(sbuf_t, 10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sBuf.sbuf_insert(sbuf_t,new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("after insert"+ sbuf_t.front%10);
//                    System.out.println("after insert"+ Arrays.toString(sbuf_t.buf));
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        int i = sBuf.sbuf_remove(sbuf_t);
                        System.out.println("after delete"+ sbuf_t.rear%10);
//                        System.out.println("after delete"+ Arrays.toString(sbuf_t.buf));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
