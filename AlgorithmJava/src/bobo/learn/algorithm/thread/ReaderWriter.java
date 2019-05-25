package bobo.learn.algorithm.thread;

import java.util.concurrent.Semaphore;

public class ReaderWriter {

    int readcnt=0;
    Semaphore mutex =new Semaphore(1),w=new Semaphore(1);

    void reader() throws InterruptedException {

        while (true){
            mutex.acquire();
            readcnt++;
            if(readcnt==1)
                w.acquire();
            mutex.release();

            //do reading
//            System.out.println("reading...");

            mutex.acquire();
            readcnt--;
            if(readcnt==0)
                w.release();
            mutex.release();
        }
    }

    void writer() throws InterruptedException {
        while (true){
            w.acquire();

            //do writing
            System.out.println("writting...");

            w.release();
        }
    }

}
