package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 idea: use Grid

 3  4个一堆  一堆2列
 4  6个一堆  一堆3列
 5  8个一堆  一堆4列

 n行  n+n-2个一堆   一堆n-1列

 解题关键点：
 找规律

 */
public class ZigZagConvert {

    @Test
    public void testZigZag(){
        String paypalishiring = convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }

    public String convert(String s, int numRows) {
        if(numRows<=1){
            return s;
        }
        int totalCol=0;
        int heap=2*(numRows-1);
//        if(s.length()%(2*(numRows-1))==0){
        totalCol=s.length() / heap*(numRows-1);
        totalCol+=numRows-1;//故意多加一堆
//        }else {
//            totalCol=
//        }
        char cells[][]=new char[numRows][totalCol];
        for(int i=0,j=0,k=0;k<s.length();k++){

            cells[i][j]=s.charAt(k);

            int pos = k % heap;
            if(pos<numRows-1){
                i++;
            }else {
                i--;
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<totalCol;j++){
                if(0==cells[i][j]){
//                    System.out.print(" ");
                }else {
//                    System.out.print(cells[i][j]);
                    sb.append(cells[i][j]);
                }

            }
//            System.out.println();
        }
        return sb.toString();
    }
}
