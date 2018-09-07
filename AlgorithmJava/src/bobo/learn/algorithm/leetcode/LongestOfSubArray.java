package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by han on 18-9-5.
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

 示例 1:

 输入:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 输出: 3
 解释:
 长度最长的公共子数组是 [3, 2, 1]。
 说明:

 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100


 真心没想到，第一道动态规划的题目，一次通过，上道儿喽！！！！！！！
 */
public class LongestOfSubArray {

    @Test
    public void testSubArray(){
        int A[]=new int[]{1,2,3,2,1};
        int B[]=new int[]{3,2,1,4,7};
        System.out.println(findLength(A,B));
    }

    public int findLength(int[] A, int[] B) {
        int longest=0;
        int cells[][]=new int[A.length][B.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    if(i==0||j==0){
                        cells[i][j]=1;
                    }else {
                        cells[i][j]=cells[i-1][j-1]+1;
                    }
                    longest=Math.max(cells[i][j],longest);
                }else {
                    cells[i][j]=0;
                }

                System.out.print(cells[i][j]+" ");
            }
            System.out.println();
        }
        return longest;
    }
}
