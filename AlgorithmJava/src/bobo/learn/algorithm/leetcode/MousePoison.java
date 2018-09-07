package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * 有100只一模一样的瓶子，编号1-100。其中99瓶是水，一瓶是看起来像水的毒药。只要老鼠喝下一小口毒药，
 * 一天后则死亡。现在，你有7只老鼠和一天的时间，如何检验出哪个号码瓶子里是毒药？

 核心思想：进制
 二进制每一位只有2种状态，对应题目，如果需要1次出结果，那么只能使用二进制。死的老鼠是1，没死的是0，直接拼接出结果
 同理，三进制，每一位有3种状态，没做一次实验，只能确定出3种状态中的一种，因此需要做2次实验，以此类推

 */
public class MousePoison {

    @Test
    public void testMouse(){
        System.out.println(Integer.toBinaryString(20));

        String poison="1010";
        int mouses[]=new int[7];
        for(int i=0;i<100;i++){
            String binStr=Integer.toBinaryString(i);
            for(int j=0;j<binStr.length();j++){
                if(poison.length()>j){
                    if(poison.charAt(poison.length()-1-j)=='1'){//charat是从左往右的
                        mouses[j]=1;
                    }
                }
            }
        }

        for(int i=mouses.length-1;i>=0;i--){
            System.out.print(mouses[i]);
        }
    }
}
