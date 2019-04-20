package bobo.learn.algorithm.primary;

import java.util.ArrayList;
import java.util.List;

public class Learn {

    public static String getName(){
        return "";
    }

    public static void main(String[] args) {
        Provider provider1 = new Provider();
        provider1.setName("66");
        Provider provider2 = new Provider();
        provider2.setName("66");

//        System.out.println(provider1.equals(provider2));
//        System.out.println(provider1==provider2);

        Learn learn = new Learn();
        learn.learnGeneric();

    }

    public void learnGeneric(){
        List<? extends Father> list= new ArrayList<>();
//        list.add(new Son());
//        list.add(new Father());
//        list.add(null);

//        Father father = list.get(0);

        List<? super Son> listS=new ArrayList<>();
//        listS.add(new Father());
        listS.add(new Son());

        Father f=new Son();
        System.out.println(((Son)f).name);
    }



    class Father extends Learn{
        public String name="爸爸";

    }
    class Son extends Father{
        public String name="儿子";

    }
}
