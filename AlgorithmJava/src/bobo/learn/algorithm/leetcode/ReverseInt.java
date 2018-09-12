package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInt {

    @Test
    public void testReverse(){
//        System.out.println(-101%10);
//        System.out.println(2<<30-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(123456));
//        System.out.println(reverse(999996));
    }

    public int reverse(int x) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if(x<0){
//            x=-x;
//        }

        int reverse=0;
        while(x!=0){
            //比较最后两位数
            if(reverse>Integer.MAX_VALUE/10||(reverse==Integer.MAX_VALUE/10&&x%10>7)){
                return 0;
            }

            if(reverse<Integer.MIN_VALUE/10||(reverse==Integer.MIN_VALUE/10&&x%10<-8)){
                return 0;
            }

//            list.add(x%10);
            reverse*=10;
            reverse+=x%10;
            x=x/10;

        }

//        System.out.println(list);
        return reverse;
    }
}
