package bobo.learn.algorithm.leetcode.datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class KthLargestInArray {

    public void findKth(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public void findKthHand(int[] nums, int k) {
        int N = nums.length;
        buildHeap(nums, N);
        while (N > nums.length - k) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
        System.out.println(nums[nums.length - k]);
    }

    public void buildHeap(int[] nums, int N) {
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }
    }

    public void sink(int[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (2 * k < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) break;
            swap(nums, k, j);
            k = j;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a - 1];
        nums[a - 1] = nums[b - 1];
        nums[b - 1] = temp;
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i - 1] - nums[j - 1] < 0;
    }
}
