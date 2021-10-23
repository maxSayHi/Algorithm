package bobo.learn.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubSetsII {
    List<Integer> candidates;

    public static void main(String[] args) {
        new SubSetsII().testSubSets();
    }

    public void testSubSets() {
        candidates = Arrays.asList(1, 1, 3);
        Collections.sort(candidates);
        dfs(new ArrayList(), 0);
    }

    public void dfs(List<Integer> combine, int index) {

        if (index == candidates.size()) {
            System.out.println(combine);
            return;
        }
//        if (target == 0) {
        //找到了
//            return;
//        }
        dfs(combine, index + 1);
        if (index == 0 || index > 1 && candidates.get(index) != candidates.get(index - 1)) {
            combine.add(candidates.get(index));
            dfs(combine, index + 1);
            combine.remove(combine.size() - 1);
        }

    }
}
