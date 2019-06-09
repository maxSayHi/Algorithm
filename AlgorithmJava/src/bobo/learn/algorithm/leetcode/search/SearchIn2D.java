package bobo.learn.algorithm.leetcode.search;

import org.junit.Test;

public class SearchIn2D {

    /**
     *
     * 74. Search a 2D Matrix

     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example 1:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * Output: true
     * Example 2:
     *
     * Input:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * Output: false
     */
    @Test
    public void testSearch() {
        int matrix[][] = new int[][]{{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
//        int matrix[][] = new int[][]{{}};
        System.out.println(searchMatrix(matrix,16));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length<1) {
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int lo=0,hi=n*m-1;
        while(lo<=hi){
            int mid = lo+((hi-lo)>>1);
            if(matrix[mid/m][mid%m]>target){
                hi=mid-1;
            }else if(matrix[mid/m][mid%m]<target){
                lo=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}