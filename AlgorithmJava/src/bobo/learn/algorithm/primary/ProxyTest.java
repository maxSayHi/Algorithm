package bobo.learn.algorithm.primary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * https://www.jianshu.com/p/95970b089360  这篇文章写的也不错
 */
public class ProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        class Bobo implements User{

            @Override
            public void login(String name, String password) {
                System.out.println("bobo login");
            }
        }

        final Bobo bobo = new Bobo();
        bobo.login("bobo","666");


        User user = (User) Proxy.newProxyInstance(Bobo.class.getClassLoader(), Bobo.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("bobo 是超级管理员，密码错了也能登录！");
                return method.invoke(bobo,args);
            }
        });
        System.out.println(user.getClass());

        user.login("bobo","666");
    }

}
