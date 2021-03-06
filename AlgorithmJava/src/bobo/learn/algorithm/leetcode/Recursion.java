package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testPermutation(){
        int nums[]={1,2,3};
//        fullPermutation(nums,0,3);
        String permutation = getPermutation(3, 3);
        System.out.println(permutation);
    }


    /**
     * 60. Permutation Sequence
     * Medium
     *
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     *
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     *
     *     "123"
     *     "132"
     *     "213"
     *     "231"
     *     "312"
     *     "321"
     *
     * Given n and k, return the kth permutation sequence.
     *
     * Note:
     *
     *     Given n will be between 1 and 9 inclusive.
     *     Given k will be between 1 and n! inclusive.
     *
     * Example 1:
     *
     * Input: n = 3, k = 3
     * Output: "213"
     *
     * Example 2:
     *
     * Input: n = 4, k = 9
     * Output: "2314"
     *
     * @param n
     * @param k
     * @return
     */
    private int pos=0;
    private int k=0;
    private String result="";
    public String getPermutation(int n, int k) {
        int nums[]=new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        this.k=k;
        fullPermutation(nums,0,n);
        return result;
    }

    //全排列
    public void fullPermutation(int arr[],int start,int end){
        if(start==end){
            pos++;
            for(int i:arr)
                System.out.print(i);
            System.out.println("   "+pos);
            if(pos==k){
                StringBuilder sb = new StringBuilder();
                for(int i:arr)
                    sb.append(i);
                result = sb.toString();
            }
            return;

        }
        for(int i=start;i<end;i++){
            swap(arr,i,start);
            fullPermutation(arr,start+1,end);
            swap(arr,i,start);//不还原，就会乱
        }
    }

    public void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b]= temp;
    }


    /**
     *
     *
     * 509. Fibonacci Number
     * Easy
     *
     * 176
     *
     * 138
     *
     * Favorite
     *
     * Share
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), for N > 1.
     * Given N, calculate F(N).
     *
     *
     *
     * Example 1:
     *
     * Input: 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     * Example 2:
     *
     * Input: 3
     * Output: 2
     * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     * Example 3:
     *
     * Input: 4
     * Output: 3
     * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     *
     */

    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        return fib(N-1)+fib(N-2);
    }
}
