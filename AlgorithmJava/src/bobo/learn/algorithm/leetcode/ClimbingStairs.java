package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class ClimbingStairs {
    /**
     * 70. Climbing Stairs
     * Easy
     *
     * 1957
     *
     * 73
     *
     * Favorite
     *
     * Share
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *
     * 可以使用BruteForce   存储中间结果的BruteForce   动态规划
     */

    @Test
    public void testClimbStairs(){

    }

    public int climbStairs(int n) {
        int mem[]=new int[n+1];
        return climbS(n,0,mem);
    }

    public int climbS(int max,int step,int mem[]){

        if(step>max){
            return 0;
        }

        if(step==max){
            return 1;
        }

        if(mem[step]>0){
            return mem[step];
        }

        mem[step] = climbS(max,step+1,mem)+climbS(max,step+2,mem);
        return mem[step];
    }


}
