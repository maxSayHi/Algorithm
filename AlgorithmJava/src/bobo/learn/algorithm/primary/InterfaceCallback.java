package bobo.learn.algorithm.primary;

import org.junit.Test;

public class InterfaceCallback {

    public interface MyCallback{
        public String say();
    }

    @Test
    public void testCallback(){
        new InterfaceCallbackTest().sayHiAfter(new MyCallback() {
            @Override
            public String say() {
                return "66666";
            }
        });
    }



}
