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
     *
     */

    @Test
    public void testMatch(){
        boolean aab = java.util.regex.Pattern.compile("c*a*b").matcher("f").find();
        System.out.println(aab);

        char p[]="*a?b".toCharArray();
        Pattern pattern = new Pattern(p, 3);
        char str[]="ccccadddddb".toCharArray();
        System.out.println(pattern.match(str,6));
    }

    //标准正确答案
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));//核心代码
        }
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

}
