package bobo.learn.algorithm.leetcode.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class FindFirstAndLastPositionInSortedArray_ {

    public static void main(String[] args) {

    }

    public int findFirstPosition(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (data[mid] < target) {
                low = mid + 1;
            } else if (data[mid] > target) {
                high = mid - 1;
            } else {
            }
        }
        return -1;
    }

    public int findLastPosition(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 2;
            if (target > data[mid]) {
                low = mid + 1;
            } else if (target < data[mid]) {
                high = mid - 1;
            } else {
            }
        }
        return -1;
    }
}