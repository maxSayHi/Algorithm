package bobo.learn.algorithm.leetcode.backtracking;

import java.util.*;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubSets {
    List<Integer> candidates;

    public static void main(String[] args) {
        new SubSets().testSubSets();
    }

    public void testSubSets() {
        candidates = Arrays.asList(1, 2, 3);
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

        combine.add(candidates.get(index));
        dfs(combine, index + 1);
        combine.remove(combine.size() - 1);

    }
}
