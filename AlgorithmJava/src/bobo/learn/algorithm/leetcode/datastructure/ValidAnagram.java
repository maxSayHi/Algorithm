package bobo.learn.algorithm.leetcode.datastructure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class ValidAnagram {

    public boolean valid(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer orDefault = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), orDefault + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            Integer orDefault = map.getOrDefault(t.charAt(j), 0);
            if (orDefault == 0) {
                return false;
            } else {
                map.put(t.charAt(j), orDefault - 1);
            }
        }
        return true;
    }
}
