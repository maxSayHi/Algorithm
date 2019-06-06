package bobo.learn.algorithm.leetcode.Dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinPathSum {

    /**
     * 120. Triangle
     * Medium
     *
     * 1106
     *
     * 120
     *
     * Favorite
     *
     * Share
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     *
     * Note:
     *
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     *
     * https://www.cnblogs.com/271934Liao/p/6919843.html
     * 动态规划，使用从下向上的方法，可以把空间复杂度降低到n
     *
     */
    @Test
    public void testMinimumTotal(){
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        ArrayList<Integer> integers3 = new ArrayList<>();
        integers3.add(5);
        integers3.add(6);
        integers3.add(7);
        ArrayList<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        integers4.add(1);
        integers4.add(8);
        integers4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(integers1);
        triangle.add(integers2);
        triangle.add(integers3);
        triangle.add(integers4);

        System.out.println(minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int row=triangle.size();
        int result[] = new int[row+1];

        for(int i=row-1;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for(int j=0;j<list.size();j++){
                result[j]=Math.min(result[j],result[j+1])+list.get(j);
            }
        }
        return result[0];
    }

//    public int bruteForce(List<List<Integer>> triangle) {
//        for(int i=0;i<triangle.size();i++){
//            List<Integer> integers = triangle.get(i);
//            for(int j=0;j<integers.size();j++){
//            }
//        }
//    }

    /**
     * 64. Minimum Path Sum
     * Medium
     *
     * Favorite
     *
     * Share
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     *
     *
     */

    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        for(int j=0;j<row-1;j++){
            grid[j+1][0]=grid[j][0]+grid[j+1][0];
        }

        for(int i=0;i<col-1;i++){
            grid[0][i+1]=grid[0][i]+grid[0][i+1];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[row-1][col-1];
    }


    /**
     * 152. Maximum Product Subarray
     * Medium
     *
     * 2075
     *
     * 92
     *
     * Favorite
     *
     * Share
     * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * Example 1:
     *
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     *
     *
     */

    public int maxProduct(int[] nums) {
        int tempMax=0;
        int tempMin=0;
        int min=nums[0];
        int max = nums[0];
        int result=nums[0];

        for(int i=0;i<nums.length;i++){
            tempMax=Math.max(nums[i]*max,nums[i]*min);
            tempMin=Math.min(nums[i]*max,nums[i]*min);
            max=Math.max(nums[i],tempMax);
            min=Math.min(nums[i],tempMin);
            result=Math.max(result,max);
        }
        return result;
    }
}
