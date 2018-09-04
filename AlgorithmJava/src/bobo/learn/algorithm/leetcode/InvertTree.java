package bobo.learn.algorithm.leetcode;


import org.junit.Test;

import java.util.LinkedList;

/**
 * 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 备注:
 这个问题是受到 Max Howell 的 原问题 启发的 ：

 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class InvertTree {

    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testRevert(){
        TreeNode root = new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);

        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);

        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);

        root = invertTree(root);
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(nodes.size()>0){
            TreeNode poll = nodes.poll();
            System.out.println(poll.val);
            if(poll.left!=null){
                nodes.add(poll.left);
            }
            if(poll.right!=null){
                nodes.add(poll.right);
            }
        }
//        Iterator<TreeNode> iterator = nodes.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().val);
//        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null){
            invertTree(root.left);
        }

        if(root.right!=null){
            invertTree(root.right);
        }
        return root;
    }
}
