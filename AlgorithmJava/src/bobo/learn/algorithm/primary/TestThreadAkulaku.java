package bobo.learn.algorithm.primary;

public class TestThreadAkulaku {

    class Person{
        public void set(){
            synchronized (this){
                System.out.println("Hello");
            }

            try {
                this.wait();
                System.out.println("wait ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        TestThreadAkulaku testThreadAkulaku = new TestThreadAkulaku();
        testThreadAkulaku.testData();
    }

    public void testData(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Person p =new Person();
//                p.set();
//            }
//        }).start();
        Person p =new Person();
        p.set();

    }
}
