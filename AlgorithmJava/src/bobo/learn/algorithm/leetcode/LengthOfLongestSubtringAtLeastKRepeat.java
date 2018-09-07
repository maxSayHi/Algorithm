package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by han on 18-9-5.
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

 示例 1:

 输入:
 s = "aaabb", k = 3

 输出:
 3

 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 示例 2:

 输入:
 s = "ababbc", k = 2

 输出:
 5

 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。


 jiuzhang解法
 https://www.jiuzhang.com/solution/longest-substring-with-at-least-k-repeating-characters/
 九章的解题方法和左耳朵耗子是一样的。。。。。。

 此题不能使用滑动窗口思想

 总结：如果解题思路不清晰，修修补补再多也没用

 */
public class LengthOfLongestSubtringAtLeastKRepeat {

    @Test
    public void testLongestSubstring(){
//        System.out.println(longestSubstringWindow("ababacb",3));
//        System.out.println("abcd".substring(0));
        System.out.println(longestSubstringJiuzhang("aaabbb",3));
    }

    /**
     * 核心思想，使用DV，递归解决
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s,int k){
        if(k<1||s.length()<k){
            return 0;
        }
        //遍历寻找不符合规矩的K值
        HashMap<Character,Integer> problemmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(problemmap.containsKey(s.charAt(i))){
                problemmap.put(s.charAt(i),1+problemmap.get(s.charAt(i)));
            }else {
                problemmap.put(s.charAt(i),1);
            }
        }

//        //如果所有的字符串都没有问题，就返回该字符串整体长度(更好的解决办法是，直接判断subStrings的长度是不是1  非常重要！小的优化可以数倍提高效率)
//        Set<Map.Entry<Character, Integer>> entries = problemmap.entrySet();
//        boolean isOk=true;
//        for(Map.Entry<Character,Integer> entry:entries){
//            if(entry.getValue()<k){
//                isOk=false;
//            }
//        }
//        if(isOk)
//            return s.length();

        List<String> subStrings=new ArrayList<>();
        for(int i=0,j=0;j<s.length();j++){
            if(problemmap.get(s.charAt(j))<k){
                subStrings.add(s.substring(i,j));
                i=j+1;
            }else if(j==s.length()-1){
                subStrings.add(s.substring(i));
            }
        }

        if(subStrings.size()==1){//如果只有一串，说明没有干扰字母，直接返回
            return subStrings.get(0).length();
        }
        int max=0;
        for(String str :subStrings){
            max=Math.max(max,longestSubstring(str,k));
        }
        return max;
    }

    /**
     * 错误解法，无法通过测试用例，放弃！！！！！！！！
     * 思路，找出出现次数<k的字符，然后使用slidewindow思想解题
     *
     * 用例： bbaaacd  3       ababacb   3
     * @param s
     * @param k
     * @return
     */
    public int longestSubstringWindow(String s, int k) {
        //遍历寻找不符合规矩的K值
        HashMap<Character,Integer> problemmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(problemmap.containsKey(s.charAt(i))){
                problemmap.put(s.charAt(i),1+problemmap.get(s.charAt(i)));
            }else {
                problemmap.put(s.charAt(i),1);
            }
        }

        int len=0,n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0,j=0;j<n;j++){
            if(problemmap.get(s.charAt(j))<k||j==n-1){
                if(j==n-1&&problemmap.get(s.charAt(j))>=k){
                    if(map.containsKey(s.charAt(j))){
                        map.put(s.charAt(j),1+map.get(s.charAt(j)));
                    }else {
                        map.put(s.charAt(j),1);
                    }
                }
                //校验map中的值
                Set<Map.Entry<Character, Integer>> entries = map.entrySet();
                boolean isOk=true;
                for(Map.Entry<Character, Integer> entry:entries){
                    if(entry.getValue()<k){
                        isOk=false;
                    }
//                    else {
//                        len=Math.max(len,entry.getValue());
//                    }
                }
                if(isOk){
                    if(problemmap.get(s.charAt(j))<k){
                        len=Math.max(len,j-i);
                    }else {
                        len=Math.max(len,j-i+1);
                    }

                }
                i=j+1;
                map.clear();
            }else {
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),1+map.get(s.charAt(j)));
                }else {
                    map.put(s.charAt(j),1);
                }
            }

        }
        return len;
    }

    public int longestSubstringJiuzhang(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k <= 1) return s.length();
        if (s.length() < k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char charAtI = s.charAt(i);
            if (!map.containsKey(charAtI)) {
                map.put(charAtI, 1);
            } else {
                map.put(charAtI, map.get(charAtI) + 1);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }
        String[] strings = sb.toString().split(",");
        if (strings.length == 1) return strings[0].length();
        int longest = 0;
        for (String st: strings) {
            longest = Math.max(longest, longestSubstring(st, k));
        }
        return longest;
    }

}
