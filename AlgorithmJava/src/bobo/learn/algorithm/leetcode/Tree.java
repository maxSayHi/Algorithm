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
     * 对于返回值为boolean的递归，学会使用 return  conditionA||conditionB
     *
     *
     */
    @Test
    public void testPathSum(){
        TreeNode node = new TreeNode(0);
        node.left=new TreeNode(1);
        node.left.left=new TreeNode(3);
        node.right=new TreeNode(2);

//        System.out.println(pathSum(node,4));
        System.out.println(pathSumTwo(node,0,4));
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

    public boolean pathSumTwo(TreeNode root, int sum,int target){
        if(root==null){
            return false;
        }

        if(root.left==null&&root.right==null){
            return sum+root.val==target;
        }

        return pathSumTwo(root.left,sum+root.val,target)||pathSumTwo(root.right,sum+root.val,target);
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


    /**
     *
     *
     * 563. Binary Tree Tilt
     * Easy
     *
     * 325
     *
     * 737
     *
     * Favorite
     *
     * Share
     * Given a binary tree, return the tilt of the whole tree.
     *
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
     *
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     *
     * Example:
     * Input:
     *          1
     *        /   \
     *       2     3
     * Output: 1
     * Explanation:
     * Tilt of node 2 : 0
     * Tilt of node 3 : 0
     * Tilt of node 1 : |2-3| = 1
     * Tilt of binary tree : 0 + 0 + 1 = 1
     * Note:
     *
     * The sum of node values in any subtree won't exceed the range of 32-bit integer.
     * All the tilt values won't exceed the range of 32-bit integer.
     *
     *
     * 学习到了新的解法，return left+right+root.val
     *
     */

    @Test
    public void testfindTild(){
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(4);
        node.left.left=new TreeNode(6);
        System.out.println(findTilt(node));
    }

    int tilt;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root){
        if(root==null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);

        tilt += Math.abs(left-right);
        return left+right+root.val;
    }

    /**
     *
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     *
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode helper(int preStart,int inStart,int inEnd,int preorder[],int inorder[]){
        if(preStart>preorder.length-1||inStart>inEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if(preorder[preStart]==inorder[i]){
                index=i;
                break;
            }
        }
        treeNode.left=helper(preStart+1,inStart,index-1,preorder,inorder);
        treeNode.right=helper(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return treeNode;
    }

    /**
     *
     * 572. Subtree of Another Tree

     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
     *
     * Example 1:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.
     * Example 2:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return false.
     *
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        if(isSame(s,t))
            return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        if(s.val!=t.val)
            return false;
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}