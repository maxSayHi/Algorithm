package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

public class AlienDictionary {
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
     * 需要注意是不是有环。如果有环，就是a在b前，b又再a前
     * <p>
     * 第四次，靠自己，完美实现！ 脑子里要有图！！脑子里要有图！！脑子里要有图！！
     */

    public static void main(String[] args) {
        System.out.println(new AlienDictionary().bfs(new String[]{"ab", "abc"}));
    }

    public String bfs(String[] words) {
        //建图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                    set.add(words[i + 1].charAt(j));
                    map.put(words[i].charAt(j), set);
                    break;
                }

                if (words[i].length() > words[i + 1].length() && j == words[i + 1].length() - 1) {
                    return "";
                }
            }
        }

        //拓扑排序
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);
        for (String s : words) {
            for (Character c : s.toCharArray()) {
                indegrees[c - 'a'] = 0;
            }
        }

        for (Character key : map.keySet()) {
            for (Character c : map.get(key)) {
                indegrees[c - 'a']++;
            }
        }

        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] != -1) count++;
            if (indegrees[i] == 0) {
                queue.add((char) ('a' + i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            sb.append(poll);
            if (map.containsKey(poll)) {//非常关键！
                Set<Character> characters = map.get(poll);
                for (Character c : characters) {
                    indegrees[c - 'a']--;
                    if (indegrees[c - 'a'] == 0) {
                        queue.add(c);
                    }
                }
            }
        }

        if (sb.length() != count) {
            return "";
        }
        return sb.toString();

    }
}