package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by max on 2019/4/5.
 */
public class Fibonacci {
    @Test
    public void testFib(){
        for (int i=0;i<20;i++){
            System.out.println(fib(i));
        }
    }

    public int fib(int n){
        if(n==0)
            return 0;
        if(n==1||n==2)
            return 1;
        int result = fib(n-1)+fib(n-2);
        return result;
    }
}
