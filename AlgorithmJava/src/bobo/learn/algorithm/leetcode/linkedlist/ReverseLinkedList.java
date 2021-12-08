package bobo.learn.algorithm.leetcode.linkedlist;

import bobo.learn.algorithm.datastructure.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 解答思路： 穿针引线！
 *
 */
public class ReverseLinkedList {

    public void reverse(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i > right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next=pre.next;
            pre.next = next;
        }
        
    }
}
