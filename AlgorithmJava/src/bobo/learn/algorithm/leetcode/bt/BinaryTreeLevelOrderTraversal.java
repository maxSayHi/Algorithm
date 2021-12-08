package bobo.learn.algorithm.leetcode.bt;

import bobo.learn.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode poll = queue.poll();
                System.out.println(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }
}
