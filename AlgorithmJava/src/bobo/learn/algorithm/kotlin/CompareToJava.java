package bobo.learn.algorithm.kotlin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CompareToJava {
    public static void main(String[] args) {
        System.out.println(returnValue() * 100000);

        System.out.println(!"A".equals("B"));
        String name = "波波";
        int age = 12;
        System.out.println("hello%s,我今年%d".format(name, age));
        Test.INSTANCE.sayMsg(name);

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if ("eat".equals(method.getName())) {
                    System.out.println("eat!!");
                }
                return null;
            }
        };

        People p = (People) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{People.class}, invocationHandler);
        p.eat();
    }


    public interface People {
        void eat();
    }

    public static long returnValue() {
        return 100000;
    }
}