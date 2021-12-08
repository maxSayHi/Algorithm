package bobo.learn.algorithm.leetcode.bt;

import bobo.learn.algorithm.datastructure.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * 总结：题目非常棒！自己掉坑里了。总是纠结 root.val == p.val的时候，这个时候应该rson == true，其实不是这样的！  经过做实验，确实
 * 自己的想法是错的。因为，当root是p的时候，q既可以在root的left中，也可以再root的right中。dfs只是判断，node里到底有没有p或者q!
 *
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public void lowestCommonAncestor(TreeNode tree, TreeNode p, TreeNode q) {

    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        if (lson && rson || (lson && node.val == q.val) || (rson && node.val == p.val)) {
            System.out.println("answer");
        }
        return lson || rson || node.val == p.val || node.val == q.val;
    }


}