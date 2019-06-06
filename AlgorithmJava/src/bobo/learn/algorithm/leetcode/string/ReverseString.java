package bobo.learn.algorithm.leetcode.string;

import org.junit.Test;

import java.util.Stack;

public class ReverseString {
    /**
     * 344. Reverse String
     * Easy
     *
     * 757
     *
     * 486
     *
     * Favorite
     *
     * Share
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * You may assume all the characters consist of printable ascii characters.
     *
     *
     *
     * Example 1:
     *
     * Input: ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     */
    @Test
    public void testReverse(){
        char chs[]={'h','e','l','l'};
        reverseString(chs);
        for(int i=0;i<chs.length;i++){
            System.out.print(chs[i]);
        }
    }

    public void reverseString(char[] s) {
        int len=s.length-1;
        int mid=s.length/2;
        for(int i=0;i<mid;i++){
            char temp=s[i];
            s[i]=s[len-i];
            s[len-i]=temp;
        }
    }

    /**
     * 151. Reverse Words in a String
     * Medium
     *
     * 554
     *
     * 2259
     *
     * Favorite
     *
     * Share
     * Given an input string, reverse the string word by word.
     *
     *
     *
     * Example 1:
     *
     * Input: "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     *
     * Input: "  hello world!  "
     * Output: "world! hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     *
     * Input: "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *
     * Note:
     *
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     */
    @Test
    public void testReverseWords(){
        System.out.println(reverseWords("  hello i am   bobo!"));
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isSpace=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(isSpace){
                    continue;
                }
                stack.push(sb.toString());
                sb.delete(0,sb.length());
                isSpace=true;
                continue;
            }else{
                isSpace=false;
                sb.append(s.charAt(i));

                if(i==s.length()-1){
                    stack.push(sb.toString());
                    sb.delete(0,sb.length());
                }
            }
        }


        while (!stack.isEmpty()){
            sb.append(stack.pop());
            if(!stack.isEmpty()){
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}