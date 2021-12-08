package bobo.learn.algorithm.leetcode.pointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 总结：
 * 窗口往右加，然后缩小左边。有很多细小的控制，好难，多做几遍，就像高数题一样
 */
public class MinimumWindowSubstring_ {

    Map<Character, Integer> ori = new HashMap();//存储t的信息，每个字符出现的次数
    Map<Character, Integer> cnt = new HashMap();//存储试错过程中的每个字符出现次数

    public void minimum(String s, String t) {
        //cnt赋值
    }

    //检查是否包含所有
    public boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        return true;
    }
}
