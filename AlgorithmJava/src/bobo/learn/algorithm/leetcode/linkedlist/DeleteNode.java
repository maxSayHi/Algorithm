package bobo.learn.algorithm.leetcode.linkedlist;

import bobo.learn.algorithm.datastructure.ListNode;

/**
 * 注意：不能使用node = node.next，因为传进来的node不是引用
 */
public class DeleteNode {

    public void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
