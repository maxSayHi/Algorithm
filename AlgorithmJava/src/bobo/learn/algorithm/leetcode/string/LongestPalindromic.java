package bobo.learn.algorithm.leetcode.string;

public class LongestPalindromic {

    /**
     *
     * 5. Longest Palindromic Substring
     * Medium
     *
     * 3645
     *
     * 353
     *
     * Favorite
     *
     * Share
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     *
     *
     */
    int longest,lo;
    public String longestPalindrome(String s) {

        if(s.length()<2){
            return s;
        }

        for(int i=0;i<s.length()-1;i++){
            getPalindromeFromcenter(s,i,i);
            getPalindromeFromcenter(s,i,i+1);
        }

        return s.substring(lo,lo+longest);
    }

    public void getPalindromeFromcenter(String s,int j,int k){
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }

        if(k-j-1>longest){
            lo=j+1;
            longest=k-j-1;
        }

    }

}
