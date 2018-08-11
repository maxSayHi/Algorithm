package bobo.learn.algorithm.process;

import org.junit.Test;

public class Chess {
    /*只允许一个变量，给出棋盘上两个将的位置*/
    @Test
    public void testChess(){
        int sum=0;
        for(int i=0;i<81;i++){
            if(i/9%3!=i%9%3){
                sum++;
                System.out.println("A="+i/9+"   B="+i%9);
            }
        }
        System.out.println(sum);
    }

    /*测试位运算  异或   等*/
    @Test
    public void testCal(){
//        int i = Integer.parseInt("110", 3);

        int i = -3;
        System.out.println(~3+1);
    }
}
