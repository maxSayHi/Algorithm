package bobo.learn.algorithm.primary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import bobo.learn.algorithm.primary.User;

/**
 * https://www.jianshu.com/p/95970b089360  这篇文章写的也不错
 */
public class ProxyLearn {


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        User user = (User) Proxy.newProxyInstance(ProxyLearn.class.getClassLoader(), new Class[]{User.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+args[0]);
                return null;
            }
        });
        System.out.println(user.getClass());

        user.login("bobo","666");
    }

}
