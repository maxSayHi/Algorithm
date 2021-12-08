package bobo.learn.algorithm.leetcode.backtracking;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 */
public class CombinationSumII_ {
    List<Integer> candidates;
    List<int[]> freq = new ArrayList<>();

    public static void main(String[] args) {
        new CombinationSumII_().testDfs();
    }

    public void testDfs() {
        candidates = Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        Collections.sort(candidates);
        for (int i = 0; i < candidates.size(); i++) {
            if (freq.size() == 0 || freq.get(freq.size() - 1)[0] != candidates.get(i)) {
                freq.add(new int[]{candidates.get(i), 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        dfs(8, new ArrayList(), 0);
    }

    public void dfs(int target, List<Integer> combine, int index) {

    }
}
