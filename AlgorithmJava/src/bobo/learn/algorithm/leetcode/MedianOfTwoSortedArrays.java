package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * 思路，使用二分查找：
 * // m+n为奇数
 * // 扎到nums1的中位数mid1，然后在nums2中二分查找所在位置
 * <p>
 * 1 nums1 last  <nums2 first
 * 2 nums1 first > nums2 last
 * 直接求中位数
 * <p>
 * if mid1==mid2
 * 刚好就是我们要的
 * <p>
 * if mid1>mid2  （脑中想象：nums2融合nums1到nums中，mid2在mid1前面
 * x x x x x m2 X X X X m1 x x x x x x x
 * m不可能出现在nums1中m1的右边，因为nums2中 m2右侧>m1的元素不够nums2的一半 ，m1右侧+m2右侧< 总长/2
 * m不可能出现在nums2中m2的左边，因为nums1中的0~m2位置不够m1总长一半，m2左边+nums1中的0!m< num总长/2）
 * <p>
 * 中位数在nums1的index 0~m1
 * 或者 nums2的index m2~n之间
 * <p>
 * if mid1<mid2
 * x x x x m1 X X X m2 x x x x
 * 中位数在nums1的index mid1~m
 * 或者 nums2的index 0~mid2
 * <p>
 * <p>
 * 第二天更新 2018-9-8：
 * 思考了一整天后，查询了大量网站资料，最后在九章，找到的答案是转化问题为寻找两个数组中第k个序列，这个思路可以理解
 *寻找两个有序数组中，第K小元素
 * 关键点：想象出来两个指针
 * A   x x x x x x x
 *     |  ->
 *
 * B   x x x x x x x
 *    |   ->
 *
 * 总结:这道题花了我2整天的时间，10多个番茄。最后也是勉强理解答案，佩服发明解题方法人的聪明才智，自己只能背下来，作为
 * 以后“融汇贯通”的基础。花了这么多时间，真的值得么？
 * 收获：
 *通过这道题，了解了指针的思想，算是最大收获
 *
 * 反思：
 * 1 快速找到问题的最好答案。这些题都是网上流传已久，肯定有非常棒的答案，按照经验来看,jiuzhang的答案非常靠谱。
 * 2 不要花费1天以上的时间在一个普通题目上。这道题太浪费时间了，以至于自己没有复习数学，没有学习新的算法
 * 3 思考问题，一定要画图，要理解，死磕也要理解，不然学完就马上忘光
 *
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    //暴力法
    public double findMedianSortedArraysRude(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double result;
        ArrayList<Integer> list = new ArrayList<>(len1 + len2);
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }

        Collections.sort(list);
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            result = (list.get(mid) + list.get(mid - 1)) / 2.0;
        } else {
            result = list.get(mid);
        }

        return result;
    }

    public double findMedian(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int totallen = m + n;
        if (totallen % 2 == 0) {
            return (findkthMy(A, 0, B, 0, totallen / 2) + findkthMy(A, 0, B, 0, totallen / 2 +1)) / 2.0;
        } else {
            return findkthMy(A, 0, B, 0, totallen / 2+1);
        }
    }

    public double findkth(int a[], int astart, int b[], int bstart, int k) {

        if (astart >= a.length) {
            return b[bstart + k - 1];
        }
        if (bstart >= b.length) {
            return a[astart + k - 1];
        }

        if (k == 1) {
            return Math.min(a[astart], b[bstart]);
        }

        int aKey = astart + k / 2 - 1 < a.length ? a[astart + k / 2 - 1] : Integer.MAX_VALUE;
        int bKey = bstart + k / 2 - 1 < b.length ? b[bstart + k / 2 - 1] : Integer.MAX_VALUE;

        if (aKey > bKey) {
            return findkth(a, astart, b, bstart + k / 2, k - k / 2);
        } else {
            return findkth(a, astart + k / 2, b, bstart, k - k / 2);
        }
    }

    @Test
    public void testFindMedian() {
        int nums1[] = new int[]{1, 3,4};
        int nums2[] = new int[]{2,5,6,7,9};
//        int nums2[] = new int[]{2};
//        System.out.println(findMedianSortedArraysRude(nums1,nums2));
        System.out.println(findMedian(nums1, nums2));
    }

    public int findkthMy(int A[], int startOfA, int B[], int startOfB, int k) {
        if(startOfA>=A.length){
            return B[startOfB+k-1];
        }

        if(startOfB>=B.length){
            return A[startOfA+k-1];
        }

        if(k==1){
            return Math.min(A[startOfA],B[startOfB]);
        }

        int keyA = startOfA + k / 2 - 1;
        if (keyA < A.length) {
            keyA = A[startOfA + k / 2 - 1];
        } else {
            keyA = Integer.MAX_VALUE;
        }

        int keyB = startOfB + k / 2 - 1;
        if (keyB < B.length) {
            keyB = B[startOfB + k / 2 - 1];
        } else {
            keyB = Integer.MAX_VALUE;
        }

        if (keyA > keyB) {
            //x x x x B x x x A x x x x
            return findkthMy(A, startOfA, B, startOfB + k / 2, k - k / 2);
        } else {
            return findkthMy(A, startOfA + k / 2, B, startOfB, k - k / 2);
        }
    }
}
