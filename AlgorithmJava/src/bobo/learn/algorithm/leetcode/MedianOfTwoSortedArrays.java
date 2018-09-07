package bobo.learn.algorithm.leetcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.


 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5


 思路，使用二分查找：
// m+n为奇数
// 扎到nums1的中位数mid1，然后在nums2中二分查找所在位置

 1 nums1 last  <nums2 first
 2 nums1 first > nums2 last
 直接求中位数

 if mid1==mid2
    刚好就是我们要的

if mid1>mid2  （脑中想象：nums2融合nums1到nums中，mid2在mid1前面
 x x x x x m2 X X X X m1 x x x x x x x
 m不可能出现在nums1中m1的右边，因为nums2中 m2右侧>m1的元素不够nums2的一半 ，m1右侧+m2右侧< 总长/2
 m不可能出现在nums2中m2的左边，因为nums1中的0~m2位置不够m1总长一半，m2左边+nums1中的0!m< num总长/2）

    中位数在nums1的index 0~m1
    或者 nums2的index m2~n之间

if mid1<mid2
 x x x x m1 X X X m2 x x x x
     中位数在nums1的index mid1~m
     或者 nums2的index 0~mid2

 */
public class MedianOfTwoSortedArrays {

    @Test
    public void testFindMedian(){
        int nums1[]=new int[]{1, 3};
        int nums2[]=new int[]{};
        System.out.println(findMedianSortedArraysRude(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    //暴力法
    public double findMedianSortedArraysRude(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        double result;
        ArrayList<Integer> list = new ArrayList<>(len1+len2);
        for(int num:nums1){
            list.add(num);
        }
        for(int num:nums2){
            list.add(num);
        }

        Collections.sort(list);
        int mid = list.size() / 2;
        if(list.size()%2==0){
            result=(list.get(mid)+list.get(mid-1))/2.0;
        }else {
            result=list.get(mid);
        }

        return result;
    }
}
