package bobo.learn.algorithm.leetcode.binarysearch;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 官方解法真的是垃圾，让人无法理解，代码量超级大
 */
public class FindPeakElement {
    public int findPeakElement(int data[]) {
        int lo = 0;
        int hi = data.length;
        //这里用小于号，是关键，因为最终lo和hi会重合，循环结束了，lo和hi的值相等，就是我们要的结果
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (data[mid] > data[mid + 1]) {
                hi = mid;//下坡，固定住
            } else {
                lo = mid +1;//上坡，向上爬
            }
        }
        return lo;
    }
}