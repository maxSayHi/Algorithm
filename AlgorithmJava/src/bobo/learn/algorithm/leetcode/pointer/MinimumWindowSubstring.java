package bobo.learn.algorithm.leetcode.pointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * 关键是一定要理解这道题的解法!
 *
 */
public class MinimumWindowSubstring {

    Map<Character, Integer> ori = new HashMap();
    Map<Character, Integer> cnt = new HashMap();

    public void minimum(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = -1;
        int sLength = s.length();
        int ansL = -1;
        int ansR = -1;
        int len = Integer.MAX_VALUE;
        while (r < sLength) {
            r++;
            if (r < sLength && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) + 1);
            }

            while (check1(ori, cnt) && l <= r) {
                if (l - r + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        //return ansL==-1?"":s.substring(ansL,ansR)
    }

    //检查是否包含所有
    public boolean check1(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (entry.getValue() > cnt.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap();
        for(Character c : t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> map = new HashMap();
        int l = 0;
        int r = -1;
        int resultL = -1;
        int resultR = -1;
        int resultLen = Integer.MAX_VALUE;
        int slen = s.length();
        while(r<slen){
            r++;
            if(r<slen && tMap.containsKey(s.charAt(r))){
                int num = map.getOrDefault(s.charAt(r),0)+1;
                map.put(s.charAt(r),num);
            }

            while(check(tMap,map)&& l<=r){
                if(r - l+1<resultLen){
                    resultLen = r - l+1;
                    resultL = l;
                    resultR = l + resultLen;
                }
                if(tMap.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }
        }

        return resultL==-1?"":s.substring(resultL,resultR);
    }

    public boolean check(Map<Character,Integer> tMap,Map<Character,Integer> map){
        Iterator<Map.Entry<Character,Integer>> it = tMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character,Integer> entry = it.next();
            if( map.getOrDefault(entry.getKey(),0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
