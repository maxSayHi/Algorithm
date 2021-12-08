package bobo.learn.algorithm.leetcode.backtracking;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 最大心得：脑子里一定要有图，在脑子里跑一个树，才能理解代码
 */
public class PermutationsII {
    List<Integer> candidates;
    boolean vis[];

    public static void main(String[] args) {
        new PermutationsII().test();
    }

    public void test() {
        candidates = Arrays.asList(1, 1, 3);
        Collections.sort(candidates);
        vis = new boolean[candidates.size()];
        dfs(new ArrayList(), candidates.size(), 0);
    }

    public void dfs(List<Integer> combine, int size, int index) {
        if (size == index) {
            System.out.println(combine);
            return;
        }

        for (int i = 0; i < candidates.size(); i++) {
            //保证从左往右，取到相同一组数字第一个没有被使用过的的数字   换句话说，相同的数字，只允许挨着取。比如[1,1,1,3]，取0,1和0,2效果是一样的
            if (vis[i] || (i > 0 && candidates.get(i) == candidates.get(i - 1) && !vis[i - 1])) {
                continue;
            }

            combine.add(candidates.get(i));
            vis[i] = true;
            dfs(combine, size, index + 1);
            vis[i] = false;
            combine.remove(combine.size() - 1);
        }
    }
}