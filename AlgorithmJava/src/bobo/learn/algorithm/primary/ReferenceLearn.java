package bobo.learn.algorithm.primary;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

public class ReferenceLearn {
    public static void main(String[] args) {
        String s = new String("123");
        WeakReference<String> weakReference = new WeakReference<String>(s);
        System.out.println(weakReference.get()==null);
        s=null;
        System.out.println(weakReference.get()==null);
        System.gc();
        System.out.println(weakReference.get()==null);

//        PhantomReference<String> stringPhantomReference = new PhantomReference<String>();
    }
}