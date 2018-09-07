package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/406a54ff2b354bdcb1b1077605620465?from=14pdf
 来源：牛客网

 有编号1~100个灯泡，起初所有的灯都是灭的。有100个同学来按灯泡开关，如果灯是亮的，那么按过开关之后，灯会灭掉。如果灯是灭的，按过开关之后灯会亮。
 现在开始按开关。
 第1个同学，把所有的灯泡开关都按一次(按开关灯的编号： 1,2,3,......100)。
 第2个同学，隔一个灯按一次(按开关灯的编号： 2,4,6,......,100)。
 第3个同学，隔两个灯按一次(按开关灯的编号： 3,6,9,......,99)。
 ......
 问题是，在第100个同学按过之后，有多少盏灯是亮着的？这些灯的编号是多少？要求给出解题思路或给出伪码。
 */
public class HundredLamp {

    private int lamps[]=new int[101];

    @Test
    public void testLamps(){
        handleLamps();
//        System.out.println(20%1);
    }

    public void handleLamps(){
        for(int i=1;i<=100;i++){//100个同学
            for(int j=i;j<=100;j++){//100盏灯
                if(j%i==0){
                    if(lamps[j]==0){
                        lamps[j]=1;
                    }else {
                        lamps[j]=0;
                    }
                }
            }
        }

        int sum=0;
        for(int i=1;i<lamps.length;i++){
            if(lamps[i]==1){
                sum++;
                System.out.println("灯 "+i+" 开着");
            }
        }
        System.out.println("共"+sum+"盏灯开着");
    }

}
