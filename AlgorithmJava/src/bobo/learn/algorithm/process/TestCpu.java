package bobo.learn.algorithm.process;

import org.junit.Test;

public class TestCpu {

    @Test
    public void testCpu(){
//        try (AffinityLock al = AffinityLock.acquireCore()) {//需要使用Affinity库
        try{
            // do some work while locked to a CPU.
            long start = System.currentTimeMillis();
            double rate = 0;//rate非常关键，rate用来控制一段时间内(40ms)，busy和idle的比例

            System.out.println(Math.sin(Math.PI/2));

            int step = 20;//10秒  x从0到pi
            for(double j =0;j<300;j++){
//                rate = j/step*Math.PI;
                rate = 0.5+Math.sin(j/step*Math.PI)/2;
                System.out.println(rate);
                int playtime=0;//执行睡眠次数
                int i=0;

                //每秒cpu取得的使用率 在任务管理器上打点
                //封装，每40ms内，让cpu busy和idle的次数   12个40ms约为0.5s  0.5s是任务管理器记录cpu使用率的一个节点一半
                while(playtime<12){
                    if(System.currentTimeMillis()-start<40*rate){
                        i++;
                    }else {
                        Thread.sleep((long) (40*(1-rate)));
                        i=0;
                        start = System.currentTimeMillis();
                        playtime++;
                    }
                }
            }


        }catch (Exception e){

        }
    }

    @Test
    public void testSin(){

        //编程之美解法
        int interval = 80;//cpu运行一次busy idle的周期
        double split = 0.01;//分割2PI的单位
        int count = 200;//横向长度
        int busy[] = new int[200];
        int idle[] = new int[200];
        double radian = 0;

        //每1000毫秒内，繁忙时间
//        try (AffinityLock al = AffinityLock.acquireCore()) {//需要使用Affinity库
        try{
            // do some work while locked to a CPU.
            int half = interval/2;

            for(int i=0;i<count;i++){
                busy[i] = (int) (half+half*Math.sin(Math.PI*radian));
                idle[i] = interval - busy[i];
                radian+=split;
            }

            int j =0;
            while(true){
                j=j%count;
                long start = System.currentTimeMillis();
                while(System.currentTimeMillis()-start<busy[j]);
                Thread.sleep(idle[j]);
                j++;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
