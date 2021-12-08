package bobo.learn.algorithm.leetcode.binarysearch;

/**
 * 69. Sqrt(x)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Sqrt {

    public int getPow(int x) {
        int lo = 0;
        int hi = x;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) >> 1;
            if ((long)mid * mid > x) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }
}
