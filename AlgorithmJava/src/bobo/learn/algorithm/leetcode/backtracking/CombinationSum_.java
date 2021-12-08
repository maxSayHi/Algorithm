package bobo.learn.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * 核心思路：每一个元素，可以选或者不选，枚举就行了。枚举的方式是dfs。
 */
public class CombinationSum_ {
    List<Integer> candidates;

    public static void main(String[] args) {
        new CombinationSum_().testDfs();
    }

    public void testDfs() {
        candidates = Arrays.asList(2, 3);
        dfs(6, new ArrayList(), 0);
    }

    public void dfs(int target, List<Integer> combine, int index) {

    }
}
