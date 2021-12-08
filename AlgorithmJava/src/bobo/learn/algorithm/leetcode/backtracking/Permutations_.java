package bobo.learn.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutations_ {
    List<Integer> candidates;
    List<List<Integer>> ans;
    boolean[] vis;

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations_().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        candidates = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            candidates.add(nums[i]);
        }
        ans = new ArrayList();
        dfs(new ArrayList<>(), candidates.size(), 0);
        return ans;
    }

    public void dfs(List combine, int size, int index) {
        if (index == size) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < size; i++) {
            if (vis[i]) continue;
            combine.add(candidates.get(i));
            vis[i] = true;
            dfs(combine, size, index + 1);
            vis[i] = false;
            combine.remove(combine.size() - 1);
        }
    }
}