package bobo.learn.algorithm.primary;

import javafx.scene.control.SeparatorMenuItem;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LearnCollections {

    public static void main(String[] args) {
//        new LearnCollections().testThread();
//        new LearnCollections().testHashMap();
//        new LearnCollections().testThreadNoneStatic();
//        new LearnCollections().testShutDown();
//        try {
            c();
//        }catch (Exception e){
//            System.out.println("出问题了"+e.getCause());
//        }
    }

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    public void testShutDown(){
        for(int i=0;i<100;i++){
            final int cur = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    if(cur==50)
                        executorService.shutdownNow();

                    try{
                        System.out.println(cur);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }
            });
        }


    }

    @Test
    public void testHashMap(){

        HashMap<Integer, String> map = new HashMap<>();
//        for(int i=0;i<100;i++){
//            map.put(i,i+"");
//        }

        map.put(0,"666");

//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for(Map.Entry<Integer, String> entry:entries){
////            map.remove(entry.getKey());
//            map.put(1000,"66");
//            map.put(1001,"66");
//        }

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
//            map.remove(iterator.next().getKey());
//            map.put(100,"66");
//            map.put(1001,"66");
//            map.put(1002,"66");
            System.out.println("666");
            iterator.next();//调用next方法，才会触发异常
        }

    }

    public static AtomicInteger in = new AtomicInteger(0);

    public void testThread(){
        int count =10;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for(int i=0;i<count;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        countDownLatch.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    c();
                }
            }).start();
        }

//        for(int i=0;i<count;i++)
//            countDownLatch.countDown();
    }

    public static HashMap<String,String> E = new HashMap<>();
    public static String c() {
        in.incrementAndGet();
        if (null == E) {
            return null;
        } else {
            Date var0 = new Date();
            long var1 = var0.getTime() + (long)(var0.getSeconds() * 1000);
            double var3 = (double)(var1 / 1000L) + (double)(var1 % 1000L) / 1000.0D;
            E.put("ctm", "123");
            StringBuilder var5 = new StringBuilder();
            Iterator var6 = E.entrySet().iterator();
            while(var6.hasNext()) {

                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doNext();

                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Map.Entry var7 = (Map.Entry)var6.next();
                var5.append("&").append((String)var7.getKey()).append("=").append((String)var7.getValue());
                sem.release();
            }

            return var5.toString();
        }
    }


    private static Semaphore sem = new Semaphore(1);
    public void testThreadNoneStatic(){


        E.put("bobo","666");
        Iterator<Map.Entry<String, String>> iterator = E.entrySet().iterator();
        while (iterator.hasNext()){

            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doNext();

            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            iterator.next();//调用next方法，才会触发异常
        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Date var0 = new Date();
//                long var1 = var0.getTime() + (long)(var0.getSeconds() * 1000);
//                double var3 = (double)(var1 / 1000L) + (double)(var1 % 1000L) / 1000.0D;
//                E.put("ctm", "123");
//                StringBuilder var5 = new StringBuilder();
//                Iterator var6 = E.entrySet().iterator();
//                while(var6.hasNext()) {
//                    Thread.yield();
//                    System.out.println(E.size()+"0");
//                    Map.Entry var7 = (Map.Entry)var6.next();
//                    var5.append("&").append((String)var7.getKey()).append("=").append((String)var7.getValue());
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Date var0 = new Date();
//                long var1 = var0.getTime() + (long)(var0.getSeconds() * 1000);
//                double var3 = (double)(var1 / 1000L) + (double)(var1 % 1000L) / 1000.0D;
//                E.put("ctm", "123");
//                StringBuilder var5 = new StringBuilder();
//                Iterator var6 = E.entrySet().iterator();
//                while(var6.hasNext()) {
//                    System.out.println(E.size()+"1");
//                    Map.Entry var7 = (Map.Entry)var6.next();
//                    var5.append("&").append((String)var7.getKey()).append("=").append((String)var7.getValue());
//                }
//            }
//        }).start();
    }

    public static void doNext(){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                E.put("bobo1","456");
//                E.put("bobo2","456");
                E.put("ctm1", "456");
                sem.release();
            }
        }).start();
    }
}
