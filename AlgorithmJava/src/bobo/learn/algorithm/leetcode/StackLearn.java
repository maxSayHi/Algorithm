package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

public class StackLearn {

    /**
     *
     * 20. Valid Parentheses
     * Easy
     *
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     *     Open brackets must be closed by the same type of brackets.
     *     Open brackets must be closed in the correct order.
     *
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     *
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     *
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     *
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     *
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     *
     */

    @Test
    public void testValid(){
        System.out.println(isValid("{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('{'==c||'('==c||'['==c){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if('{'==pop&&'}'!=c)
                    return false;
                else if('('==pop&&')'!=c){
                    return false;
                }else if('['==pop&&']'!=c){
                    return false;
                }
            }
        }
        if(stack.size()>0){
            return false;
        }

        return true;

    }
}
