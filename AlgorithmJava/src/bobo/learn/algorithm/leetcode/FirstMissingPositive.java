package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class FirstMissingPositive {

    /**
     * 41. First Missing Positive
     * Hard
     *
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     *
     * Note:
     *
     * Your algorithm should run in O(n) time and uses constant extra space.
     *
     * 思路：
     *
     * https://segmentfault.com/a/1190000006013062  思路完全正确，解析也很到位，但是代码无法通过LeetCode
     *
     * https://www.cnblogs.com/springfor/p/3889547.html  代码正确，注释太少，使用第二个方法
     *
     * 这道题利用了数组，遍历的时候从0~n   刚好可以找到缺失的数字
     * 关键点：数字不可能超过0~n这个区间！
     *
     * 答案太巧妙了，必须多看几遍记住
     *
     */

    @Test
    public void testPositive(){
        int nums[]={-1,9,0,5,3};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){//在区间内
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];//在对应的区间存放
                nums[i]=temp;
                i--;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

}
