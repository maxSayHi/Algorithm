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

    /**
     *
     * 150. Evaluate Reverse Polish Notation
     * Medium
     *
     * 513
     *
     * 347
     *
     * Favorite
     *
     * Share
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     *
     * Note:
     *
     * Division between two integers should truncate toward zero.
     * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
     *
     * Example 1:
     *
     * Input: ["2", "1", "+", "3", "*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Example 2:
     *
     * Input: ["4", "13", "5", "/", "+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     * Example 3:
     *
     * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     * Output: 22
     * Explanation:
     *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     *
     * 逆波兰表达式
     *
     */
    @Test
    public void testRPN(){
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str=tokens[i];
            if("+".equals(str)){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first+second);
            }else if("-".equals(str)){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first-second);
            }else if("*".equals(str)){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first*second);
            }else if("/".equals(str)){
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first/second);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

}