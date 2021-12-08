package bobo.learn.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 最大心得：脑子里一定要有图，在脑子里跑一个树，才能理解代码
 */
public class PermutationsII_ {
    List<Integer> candidates;

    public static void main(String[] args) {
        new PermutationsII_().test();
    }

    public void test() {
        candidates = Arrays.asList(1, 1, 3);
        Collections.sort(candidates);
        dfs(new ArrayList(), candidates.size(), 0);
    }

    public void dfs(List<Integer> combine, int size, int index) {
    }
}