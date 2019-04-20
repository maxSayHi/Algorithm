package bobo.learn.algorithm.leetcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    @Test
    public void testTree(){
        TreeNode node = new TreeNode(0);
        node.left=new TreeNode(1);
        node.left.left=new TreeNode(3);
        node.right=new TreeNode(2);

//        printLMR(node);
//        printLRM(node);
//        printByQueue(node);

        System.out.println(maxDepth(node));
    }

    public void printLMR(TreeNode node){
        if(node==null){
            return;
        }
        printLMR(node.left);
        System.out.println(node.val);
        printLMR(node.right);
    }

    public void printMLR(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        printMLR(node.left);
        printMLR(node.right);
    }

    public void printLRM(TreeNode node){
        if(node==null){
            return;
        }
        printLRM(node.left);
        printLRM(node.right);
        System.out.println(node.val);
    }

    public void printByQueue(TreeNode node){
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        while(list.size()>0){
            TreeNode poll = list.poll();
            System.out.println(poll.val);
            if(poll.left!=null) list.add(poll.left);
            if(poll.right!=null) list.add(poll.right);
        }
    }


    /**
     *
     * 104. Maximum Depth of Binary Tree
     * Easy
     *
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * return its depth = 3.
     *
     */


    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int maxleft=maxDepth(root.left);
        int maxright=maxDepth(root.right);

        return Math.max(maxleft,maxright)+1;
    }


    /**
     *
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     *
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * 总结，关键点是把sum逐层下放到根节点
     *
     *
     */
    @Test
    public void testPathSum(){
        TreeNode node = new TreeNode(0);
        node.left=new TreeNode(1);
        node.left.left=new TreeNode(3);
        node.right=new TreeNode(2);

        System.out.println(pathSum(node,4));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }

    public boolean pathSum(TreeNode root, int sum){
        if(root==null){
            return false;
        }

        if(root.left==null&&root.right==null){
            return sum==root.val;
        }

        int new_sum=sum-root.val;
        return pathSum(root.left,new_sum)||pathSum(root.right,new_sum);
    }


    /**
     *
     * 98. Validate Binary Search Tree
     * Medium
     *
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * Example 1:
     *
     * Input:
     *     2
     *    / \
     *   1   3
     * Output: true
     * Example 2:
     *
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * Output: false
     * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
     *              is 5 but its right child's value is 4.
     *
     *
     *  https://www.cnblogs.com/grandyang/p/4298435.html  中序遍历+数组  最简单
     */

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode node, List list){
        if(node==null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);

    }

}