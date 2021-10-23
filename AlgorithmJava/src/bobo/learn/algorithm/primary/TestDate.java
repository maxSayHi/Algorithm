package bobo.learn.algorithm.primary;

import org.junit.Test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestDate {
    @Test
    public void testDate() throws InterruptedException {
//        System.out.println("0123456789".substring(0,9));
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
////        try {
////            Date office = simpleDateFormat.parse("11:06");
////            Date out = simpleDateFormat.parse("11:07");
////            long currentTime = System.currentTimeMillis();
////            Date currentDate = simpleDateFormat.parse(simpleDateFormat.format(new Date(currentTime)));
////            System.out.println(currentDate + "  " + office + "  " + out);
////            if (currentDate.compareTo(office) < 0 || currentDate.compareTo(out) >= 0) {
//////                ToastUtils.showShort(context.getResources().getString(R.string.consultant_rest_hint));
////                System.out.println("不在时间内");
////                return;
////            } else {
////                System.out.println("弹窗！！！");
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        BodyRequest bodyRequest = new BodyRequest();
//        Thread.sleep(100);
//        bodyRequest = new BodyRequest();
//        Thread.sleep(100);
//        bodyRequest = new BodyRequest();
//
//        try {
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    new InterfaceCallback.MyCallback() {
//                        @Override
//                        public String say() {
//                            System.out.println(1 / 0);
//                            return null;
//                        }
//                    }.say();
//                }
//            }).start();
//            return;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String str = null;
//        String name = str + "123";
//        System.out.println(name);
//        System.out.println(5 % 0);

//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("周煦明");
//        arr.add("田雨露");
//        arr.add("李婧馨");
//        int position = ThreadLocalRandom.current().nextInt(0, 3);
//        System.out.println("下一位轮值人：" + arr.get(position));

//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("周煦明");
////        arr.add("田雨露");
//        arr.add("李婧馨");
////        arr.add("韩博");
//        int position = ThreadLocalRandom.current().nextInt(0, arr.size());
//        System.out.println("下一位轮值人：" + arr.get(position));


//        /**
//         * 排名不分先后
//         */
        ArrayList<String> arr = new ArrayList<>();
        arr.add("周煦明");
        arr.add("田雨露");
        arr.add("李婧馨");
        arr.add("韩博");
        arr.add("金贤伦");
        arr.add("刘硕菲");
        arr.add("杨乐");
        arr.add("李永斌");
        arr.add("邱圣明");
        arr.add("王乾坤");
        arr.add("张占永");
        arr.add("胡学文");
        arr.add("付树棣");
        int position = ThreadLocalRandom.current().nextInt(0, arr.size());
        System.out.println("中奖选手：" + arr.get(position));
//
//
//        /**
//         * 排名不分先后
//         */
//        ArrayList<String> bonus = new ArrayList<>();
//        bonus.add("交换券");
//        bonus.add("分享后退一格");
//        bonus.add("肩颈放松券（金藏）");
//        bonus.add("可以向主题池里面添加自己感兴趣的、想要了解的主题");
//        bonus.add("夸奖券（全体小伙伴夸奖一分钟）");
//        position = ThreadLocalRandom.current().nextInt(0, arr.size());
//        System.out.println("中奖选手：" + arr.get(position));
//
//        /**
//         * 处罚
//         */
//        ArrayList<String> punish = new ArrayList<>();
//        bonus.add("真心话大冒险（分享人挑选一个人，必须用真心话回答）");
//        bonus.add("必须从主题池里随机抽取、或选取分享主题");
//        bonus.add("体罚：俯卧撑、蛙跳");
//        bonus.add("一个月内再来一次");
//        bonus.add("提前券");
//        bonus.add("wiki券(主题池里的主题选一个，写一篇wiki)");
//        position = ThreadLocalRandom.current().nextInt(0, arr.size());
//        System.out.println("中奖选手：" + arr.get(position));
        sayHi();
    }


    public static void sayHi() {
        try {
            System.out.println("hello darling!");
            return;
        } catch (Exception e) {

        } finally {
            System.out.println("Finally");
        }
    }
}
