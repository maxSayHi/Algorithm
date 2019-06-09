package bobo.learn.algorithm.leetcode;

public class Mathematic {
    /**
     *
     * 50. Pow(x, n)
     * Medium
     *
     * 854
     *
     * 2085
     *
     * Favorite
     *
     * Share
     * Implement pow(x, n), which calculates x raised to the power n (xn).
     *
     * Example 1:
     *
     * Input: 2.00000, 10
     * Output: 1024.00000
     * Example 2:
     *
     * Input: 2.10000, 3
     * Output: 9.26100
     * Example 3:
     *
     * Input: 2.00000, -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * Note:
     *
     * -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−231, 231 − 1]
     *
     * https://leetcode.com/problems/powx-n/discuss/19544/5-different-choices-when-talk-with-interviewers
     * 剑指offer
     *
     */
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n==Integer.MIN_VALUE){
            x=x*x;
            n=n>>1;
        }
        if(n<0){
            x = 1/x;
            n=-n;
        }
        return (n&1)==0?myPow(x*x,n>>1):x*myPow(x*x,n>>1);
    }

    /**
     *
     * 65. Valid Number
     * Hard
     *
     * 430
     *
     * 3199
     *
     * Favorite
     *
     * Share
     * Validate if a given string can be interpreted as a decimal number.
     *
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
     *
     * Numbers 0-9
     * Exponent - "e"
     * Positive/negative sign - "+"/"-"
     * Decimal point - "."
     * Of course, the context of these characters also matters in the input.
     *
     * Update (2015-02-10):
     * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
     *
     * https://www.runoob.com/java/java-regular-expressions.html  正则表达式学习
     */
    public boolean isNumber(String s) {
        return s.trim().matches("[+-]?(\\d+\\.?|\\.\\d+)\\d*(e[+-]?\\d+)?");
    }
}
