package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
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

 */
public class LengthOfLongestSubtringAtLeastKRepeat {

    @Test
    public void testLongestSubstring(){
        System.out.println(longestSubstringWindow("ababacb",3));
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

}
