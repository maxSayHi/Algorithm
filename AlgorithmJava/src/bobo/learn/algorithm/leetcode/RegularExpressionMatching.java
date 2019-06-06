package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.regex.Pattern;

public class RegularExpressionMatching {
    /**
     *
     * 10. Regular Expression Matching
     * Hard
     *
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     *
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     *     s could be empty and contains only lowercase letters a-z.
     *     p could be empty and contains only lowercase letters a-z, and characters like . or *.
     *
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     *
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     *
     * Example 3:
     *
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     *
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
     *
     * Example 5:
     *
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     *
     * 总结：要注意，不是普通的正则表达式，*的意义不同，*前面的字符可以不出现！
     * 审题：*代表zero or more
     *
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*':
     *    here are two sub conditions:
     *                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     *                2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     *                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     *                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     *
     * https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
     *
     *
     */

    @Test
    public void testMatch(){
//        boolean aab = java.util.regex.Pattern.compile("c*a*b").matcher("f").find();
//        System.out.println(aab);
//
//        char p[]="*a?b".toCharArray();
//        Pattern pattern = new Pattern(p, 3);
//        char str[]="ccccadddddb".toCharArray();
//        System.out.println(pattern.match(str,6));

        isMatch("aac","a*c");
    }

    public boolean isMatch(String text, String pattern) {

        if (text == null || pattern == null) {
            return false;
        }
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < text.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pattern.charAt(j) == text.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pattern.charAt(j) == '*') {
                    if (pattern.charAt(j-1) != text.charAt(i) && pattern.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }

        for (int i = 0 ; i < text.length()+1; i++) {
            for (int j = 0; j < pattern.length()+1; j++) {
                System.out.print(String.format("%8s",dp[i][j]));
            }
            System.out.println();
        }

        return dp[text.length()][pattern.length()];
    }


    public class Pattern {
        private boolean matched = false;
        private char[] pattern; // 正则表达式
        private int plen; // 正则表达式长度

        public Pattern(char[] pattern, int plen) {
            this.pattern = pattern;
            this.plen = plen;
        }

        public boolean match(char[] text, int tlen) { // 文本串及长度
            matched = false;
            rmatch(0, 0, text, tlen);
            return matched;
        }

        private void rmatch(int ti, int pj, char[] text, int tlen) {
            if (matched) return; // 如果已经匹配了，就不要继续递归了
            if (pj == plen) { // 正则表达式到结尾了
                if (ti == tlen) matched = true; // 文本串也到结尾了
                return;
            }
            if (pattern[pj] == '*') { // * 匹配任意个字符
                for (int k = 0; k <= tlen-ti; ++k) {
                    rmatch(ti+k, pj+1, text, tlen);
                }
            } else if (pattern[pj] == '?') { // ? 匹配 0 个或者 1 个字符
                rmatch(ti, pj+1, text, tlen);
                rmatch(ti+1, pj+1, text, tlen);
            } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
                rmatch(ti+1, pj+1, text, tlen);
            }
        }
    }


    /**
     *
     * 152. Maximum Product Subarray
     * Medium
     *
     * 2075
     *
     * 92
     *
     * Favorite
     *
     * Share
     * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * Example 1:
     *
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     *
     */

}
