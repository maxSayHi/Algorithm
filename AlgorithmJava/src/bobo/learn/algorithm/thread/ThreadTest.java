package bobo.learn.algorithm.thread;

public class ThreadTest {

    public static void main(String[] args) {

        Counter counter = new Counter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    counter.add();
//                    System.out.println(counter.count);
                    System.out.println(counter.acount.get());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    counter.minus();
//                    System.out.println(counter.count);
                    System.out.println(counter.acount.get());
                }
            }
        }).start();

    }
}
