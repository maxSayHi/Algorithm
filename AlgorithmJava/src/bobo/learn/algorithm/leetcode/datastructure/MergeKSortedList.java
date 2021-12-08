package bobo.learn.algorithm.leetcode.datastructure;

import bobo.learn.algorithm.datastructure.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 总结：链表，需要有个"把儿"
 *
 * 二刷的时候，发现自己根本没有掌握这个题的编码思路，虽然解题思路是有的...
 *
 */

public class MergeKSortedList {
    class Status {
        int val;
        ListNode next;

        public Status(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode merge(ListNode[] list) {

        Queue<Status> queue = new PriorityQueue<>();
        for (ListNode node : list) {
            if (node != null) {
                queue.add(new Status(node.val, node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (!queue.isEmpty()) {
            Status poll = queue.poll();
            tail.next = poll.next;
            tail = tail.next;
            if (poll.next.next != null) {
                queue.add(new Status(poll.next.next.val, poll.next.next));
            }
        }

        return head.next;
    }

}