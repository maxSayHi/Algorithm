package bobo.learn.algorithm.leetcode;

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


 */
public class LongestOfSubArray {
    public int findLength(int[] A, int[] B) {
        int cells[][]=new int[A.length][B.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){

                if(A[i]==B[j]){
                    cells[i][j]=cells[i-1][j-1];
                }


            }
        }
        return 0;
    }
}
