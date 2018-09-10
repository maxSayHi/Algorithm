package bobo.learn.algorithm.leetcode;

/**
 * Created by han on 18-9-9.
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 */


import org.junit.Test;

/**
 * 思考，使用滑动窗口，思考不出来..
 * 暴力法，遍历所有子串
 *
 */
public class LongestParlindrome {

    @Test
    public void testParlindrome(){
//        String s="abaeedaabbccbbaaaaeeeeeeaaaa";
        String s="cbbd";
//        System.out.println(isParlindrome(s,2,4));
//        System.out.println(longestPalindrome(s));
    }


    //暴力法
    public String longestPalindromeRude(String s) {
        if(s==null||"".equals(s)){
            return "";
        }
        int max=0;
        int maxStart=0;
        int maxEnd=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(isParlindrome(s,i,j+1)){
                    max=Math.max(max,j-i+1);
                    if(max==j-i+1){
                        maxStart=i;
                        maxEnd=j;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

    public boolean isParlindrome(String s,int start,int end){
        for(int i=start,j=end;i<=(end-1+start)/2;i++){
            if(s.charAt(i)!=s.charAt(--j)){
                return false;
            }
        }
        return true;
    }
}
