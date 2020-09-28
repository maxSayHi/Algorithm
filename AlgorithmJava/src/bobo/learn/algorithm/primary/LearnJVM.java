package bobo.learn.algorithm.primary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LearnJVM {
    @Test
    public void testDate() throws InterruptedException {
        A obja = A.getInstance();
        System.out.println(obja.a);
        System.out.println(obja.b);
    }

}

class A {
    public final int C;
    private static A instance = new A();
    public static int a = 0;
    public static int b;

    private A() {
        a++;
        b++;
        C = 0;
    }

    public static A getInstance() {
        return instance;
    }

}
