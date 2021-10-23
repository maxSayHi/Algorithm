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
public class CombinationSumII {
    List<Integer> candidates;
    List<int[]> freq = new ArrayList<>();

    public static void main(String[] args) {
        new CombinationSumII().testDfs();
    }

    public void testDfs() {
        candidates = Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        Collections.sort(candidates, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int candidate : candidates) {
            if (freq.size() == 0 || candidate != freq.get(freq.size() - 1)[0]) {
                freq.add(new int[]{candidate, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        dfs(8, new ArrayList(), 0);
    }

    public void dfs(int target, List<Integer> combine, int index) {
        if (index == freq.size()) {//freq的size是重点，递归的不是candidates，而是freq
            return;
        }
        if (target == 0) {
            //找到了
            System.out.println(combine.toString());
            return;
        }
        dfs(target, combine, index + 1);
        if (target - freq.get(index)[0] >= 0) {
            for (int i = 1; i <= freq.get(index)[1]; i++) {
                combine.add(freq.get(index)[0]);
                dfs(target - i * freq.get(index)[0], combine, index + 1);
            }
            for (int i = 1; i <= freq.get(index)[1]; i++) {
                combine.remove(combine.size() - 1);
            }
        }
    }
}
