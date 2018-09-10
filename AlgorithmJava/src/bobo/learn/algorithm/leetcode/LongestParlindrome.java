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
 * 暴力法，遍历所有子串。提交之后，超时...
 *
 * 继续思考，使用指针思想？
 * 怎么才能不去校验已经校验过的字符串？
 *
 * 新思路，遍历每一个元素，往两边找。(错误  只能算出aba这种情况   不能算出aabb这种情况)
 * 后续看正确答案，发现自己的思路是正确的！自己的答案至少了一个地方，那就是每遍历到一个元素，要while循环两次寻找回文数
 * 第一次：  l=i,r=i+1
 * 第二次：  l=i-1,r=i+1
 * 这样就覆盖全了。
 * 最终结果还是好的，给自己点赞，加油，你可以的！
 *
 *
 */
public class LongestParlindrome {

    @Test
    public void testParlindrome(){
        String s="";
//        String s="cccc";
//        System.out.println(isParlindrome(s,2,4));
//        System.out.println(longestPalindrome(s));
//        System.out.println(longestPalindromeDp(s));
        System.out.println(longestDp(s));
    }

    //从中间向两边扩张  需要处理的情况太多 放弃。
    public String longestPalindromeMidToEdge(String s) {
        if(s==null||"".equals(s)){
            return "";
        }

        int max=0;
        int maxl=0;
        int maxr=1;
        for(int i=0;i<s.length()-1;i++){
            int l=i,r=i+1;
//            if(l>0&&(s.charAt(l-1)==s.charAt(r))){
//                l--;
//            }else if(s.charAt(l)!=s.charAt(r)){//如果中间两个数不相等
//                l--;
//            }
            while (true){
                if(l<0||r>2*i+1||r>=s.length()){
                    break;
                }

                if (s.charAt(l)!=s.charAt(r)){
                    break;
                }

                max=Math.max(max,r-l+1);
                if(max==r-l+1){
                    maxl=l;
                    maxr=r+1;
                }
                l--;
                r++;
            }

            if(i>0){
                l=i-1;
                r=i+1;
                while (true){
                    if(l<0||r>2*i+1||r>=s.length()){
                        break;
                    }

                    if (s.charAt(l)!=s.charAt(r)){
                        break;
                    }

                    max=Math.max(max,r-l+1);
                    if(max==r-l+1){
                        maxl=l;
                        maxr=r+1;
                    }
                    l--;
                    r++;
                }
            }

        }

        return s.substring(maxl,maxr);
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

    /**
     * 方法三：动态规划
     为了改进暴力法，我们首先观察如何避免在验证回文时进行不必要的重复计算。考虑 \textrm{“ababa”}“ababa” 这个示例。如果我们已经知道 \textrm{“bab”}“bab” 是回文，那么很明显，\textrm{“ababa”}“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。

     我们给出 P(i,j)P(i,j) 的定义如下：

     𝑃(𝑖,𝑗)={true,false,如果子串𝑆𝑖…𝑆𝑗是回文子串其它情况
     因此，

     P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j ) P(i,j)=(P(i+1,j−1) and S
     ​i
     ​​ ==S
     ​j
     ​​ )

     基本示例如下：

     P(i, i) = true P(i,i)=true

     P(i, i+1) = ( S_i == S_{i+1} ) P(i,i+1)=(S
     ​i
     ​​ ==S
     ​i+1
     ​​ )

     这产生了一个直观的动态规划解法，我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…

     复杂度分析

     时间复杂度：O(n^2)O(n
     ​2
     ​​ )， 这里给出我们的运行时间复杂度为 O(n^2)O(n
     ​2
     ​​ ) 。

     空间复杂度：O(n^2)O(n
     ​2
     ​​ )， 该方法使用 O(n^2)O(n
     ​2
     ​​ ) 的空间来存储表。

     关键点：表格每个cell[i,j]，代表的是从i开始到j结束的这串字符串，是否为回文数
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        int longest = 1, start = 0;
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] &&
                        s.charAt(i) == s.charAt(j);

                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(isPalindrome[i][j]==true?isPalindrome[i][j]+"  ":isPalindrome[i][j]+" ");
            }
            System.out.println();
        }

        return s.substring(start, start + longest);
    }


    /**
     * 按照自己理解改写的  先1个1个   再2个2个  再3个3个......
     * @param s
     * @return
     */
    public String longestDp(String s){
        if(s==null||"".equals(s)){
            return s;
        }
        int max=0,maxl=0,maxr=1;
        int n = s.length();
        int[][] cells=new int[n][n];

        for(int i=0;i<n;i++){
            cells[i][i]=1;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                cells[i][i+1]=1;

                max=2;
                maxl=i;
                maxr=i+1+1;
            }
        }

        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                if((cells[j+1][j+i-1]==1)&&(s.charAt(j)==s.charAt(j+i))){
                    cells[j][j+i]=1;

                    max=Math.max(max,i+1);
                    if(max==i+1){
                        maxl=j;
                        maxr=j+i+1;
                    }
                }
            }
        }

        return s.substring(maxl,maxr);
    }
}
