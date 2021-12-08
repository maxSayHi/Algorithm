package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 */
public class WordLadder {
    List<Integer> candidates;

    public static void main(String[] args) {
        new WordLadder().test();
    }

    public void test() {
        candidates = Arrays.asList(1, 2, 3);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                if (changeWordEveryOneLetter(currentWord, endWord, queue, wordSet, visited)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> wordSet, Set<String> visited) {
        char[] chars = currentWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (originChar == j) {
                    continue;
                }
                chars[i] = j;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }

                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            chars[i] = originChar;
        }
        return false;
    }

}
