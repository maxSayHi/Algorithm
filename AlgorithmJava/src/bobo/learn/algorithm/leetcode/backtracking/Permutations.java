package bobo.learn.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutations {
    List<Integer> candidates;

    public static void main(String[] args) {
        new Permutations().test();
    }

    public void test() {
        candidates = Arrays.asList(1, 2, 3);
        Collections.sort(candidates);
        dfs(new ArrayList(), candidates.size(), 0);
    }

    public void dfs(List<Integer> combine, int size, int index) {

        if (size == index) {
            System.out.println(combine);
            return;
        }

        for (int i = 0; i < candidates.size(); i++) {
            if (!combine.contains(candidates.get(i))) {
                combine.add(candidates.get(i));
                dfs(combine, size, index + 1);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
