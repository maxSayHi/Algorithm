package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by max on 2019/4/6.
 */
public class Recursion {

    @Test
    public void testFactorial(){
        System.out.println(factorial(6));
    }

    public int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    //全排列
    public int fullPermutation(int n){
        return n;
    }
}
