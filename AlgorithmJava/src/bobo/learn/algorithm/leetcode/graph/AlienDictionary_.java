package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

public class AlienDictionary_ {
    /**
     * 269. 火星词典
     * 现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。
     * <p>
     * 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
     * <p>
     * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
     * <p>
     * 字符串 s 字典顺序小于 字符串 t 有两种情况：
     * <p>
     * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
     * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["wrt","wrf","er","ett","rftt"]
     * 输出："wertf"
     * 示例 2：
     * <p>
     * 输入：words = ["z","x"]
     * 输出："zx"
     * 示例 3：
     * <p>
     * 输入：words = ["z","x","z"]
     * 输出：""
     * 解释：不存在合法字母顺序，因此返回 "" 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] 仅由小写英文字母组成
     * <p>
     * 总结：这道题理解清楚题目是难点，所谓"字典"序，指的是可以根据两个词的先后，找出第一个不相同的字母的先后。
     * <p>
     * 第三次练习错误：忘记入度--
     */

    public static void main(String[] args) {

    }

    public String bfs(String[] words) {

        return "";
    }
}