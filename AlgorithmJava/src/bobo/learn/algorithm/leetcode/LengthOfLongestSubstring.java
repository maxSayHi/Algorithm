package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LengthOfLongestSubstring {

    @Test
    public void testLengthOflongestSubstring(){
        System.out.println(lengthOfLongestSubstringOptimizedSlideWindow("bbbbbb"));
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int cursor=0;
        int currentLongestLength=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(sb.indexOf(s.charAt(i)+"")==-1){
                sb.append(s.charAt(i)+"");
                if(i==s.length()-1){
                    if(sb.length()>currentLongestLength){
                        currentLongestLength=sb.length();
                    }
                    i=cursor;
                    cursor++;
                    if(currentLongestLength>=s.length()-cursor){
                        return currentLongestLength;
                    }
                }
            }else {
                if(sb.length()>currentLongestLength){
                    currentLongestLength=sb.length();
                }
                sb.delete(0,sb.length());
                i=cursor;
                cursor++;
                if(currentLongestLength>=s.length()-cursor){
                    return currentLongestLength;
                }
            }

        }

        return currentLongestLength;
    }

    /**
     * 滑动窗口
     * 使用set存储已经检查过的数组作为窗口，[i,j),如果发现新的char没有在串口里，[i,j+1),否则[i+1,j)
     * 很难理解的地方：窗口不停从左往右移动，移动过的地方都是已经计算了最长不重复子串的，所以i可以放心往右移动，不用担心i向右移动了，会落下一些情况
     * 其实，滑动串口是基于“暴力法”的，只不过滑动窗口不用检查所有的子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSlideWindow(String s) {
        int len=0;
        int n=s.length();
        HashSet<Character> window = new HashSet<>();
        int i=0,j=0;
        while(i<n&&j<n){
            if(!window.contains(s.charAt(j))){
                window.add(s.charAt(j++));
                len=Math.max(len,j-i);
            }else {
                window.remove(s.charAt(i++));
            }
        }
        return len;
    }

    /**
     * 精妙的算法！  巧妙地进行窗口滑动
     * 关键点：滑动窗口，[i,j),存储已经扫描的元素位置,如果发现扫描到的元素已经在map中了，直接取该元素的位置，并且让i滑动到该位置
     *
     * * @param s
     * @return
     */
    public int lengthOfLongestSubstringOptimizedSlideWindow(String s) {
        int n=s.length(),len=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0,j=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)),i);
            }
            len=Math.max(len,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return len;
    }
}
