package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class BinSearch {

    @Test
    public void testBinSearch(){
        int arr[]=new int[]{1,3,5,7,9,10};
//        System.out.println(binSearch(arr,0));
        System.out.println(search(arr,10));
    }

    public int binSearch(int arr[],int k){
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            if(arr[mid]<k){
                lo=mid+1;
            }else if(arr[mid]>k){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     *
     * 704. Binary Search
     * Easy
     *
     * 246
     *
     * 30
     *
     * Favorite
     *
     * Share
     * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     *
     * Example 2:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     *
     *
     * Note:
     *
     * You may assume that all elements in nums are unique.
     * n will be in the range [1, 10000].
     * The value of each element in nums will be in the range [-9999, 9999].

     */
    public int search(int[] nums, int target) {
        int low=0,hi=nums.length-1;
        while(low<=hi){
            int mid=low+((hi-low)>>1);
            if(nums[mid]>target){
                hi=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
