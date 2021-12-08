package bobo.learn.algorithm.leetcode.pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 *
 * 纠结，为啥++r不行，研究中。  找到原因了：如果直接写++r，下次for循环进来直接就++r了，上次的r直接没被判断就+了1
 * 一定要注意++r这种细节！
 */
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().longest("abcabcbb"));
    }

    public int longest(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int r = -1;
        for (int l = 0; l < s.length(); l++) {
            if (l != 0) {
                set.remove(s.charAt(l - 1));
            }
            while (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set =new HashSet();
        char[] strs = s.toCharArray();
        int len = strs.length;
        int result = 0;
        int j= 0;
        for(int i=0;i<len;i++){
            if(i!=0){
                set.remove(strs[i-1]);
            }

            while(j<len&&!set.contains(strs[j])){
                set.add(strs[j]);
                j++;
            }
            result = Math.max(j-i,result);
        }
        return result;
    }
}
