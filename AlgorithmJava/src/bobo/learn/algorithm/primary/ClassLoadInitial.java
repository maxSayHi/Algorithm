package bobo.learn.algorithm.primary;

public class ClassLoadInitial {

    static class A{
        static int val=123;
        static {
            System.out.println("A初始化");
        }
    }

    static class B extends A{
//        static int val=456;
        static {
            System.out.println("B初始化");
        }
    }

    public static void main(String[] args) {
        int val = B.val;
        System.out.println(val);
    }

}
