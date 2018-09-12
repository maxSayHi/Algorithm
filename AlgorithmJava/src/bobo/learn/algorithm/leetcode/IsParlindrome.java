package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
public class IsParlindrome {

    @Test
    public void testParlindrome(){
        System.out.println(isParlindrome(010));
    }

    public boolean isParlindrome(int i){
        if(i<0){
            return false;
        }

        int temp=i;
        int length=0;
        while(temp!=0){
            length++;
            temp=temp/10;
        }
        //1234321
        for(int pos=1;pos<=length/2;pos++){
            int r= (int) (i%Math.pow(10,pos));
            int l= (int) (i/Math.pow(10,(length-pos)));
            if(pos!=1){
                r= (int) (r/Math.pow(10,pos-1));
                l= l%10;
            }
            if(r!=l){
                return false;
            }
        }
        return true;
    }
}
