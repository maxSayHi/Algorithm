package bobo.learn.algorithm.thread;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.yield();
        number=42;
        Thread.yield();
        ready=true;
    }
}
