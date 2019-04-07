package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by max on 16-10-12.
 */
public class LeetCode {

    @Test
    public void testTwoSum() {
        int[] nums = {1, 3};
        int[] ints = twoSum(nums, 9);
        System.out.println(ints[0] + "  " + ints[1]);
    }

    /**
     *
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]

     * 可以使用HashTble或者是HashSet
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    @Test
    public void testLengthOfLongestSubstring() {
//        System.out.println("a".lastIndexOf("aaa".toCharArray()[0]));
//        System.out.println("abc".indexOf("c"));
        System.out.println(lengthOfLongestSubstring("abc"));
    }

    //思路  从左到又遍历 用tempStr存储目前最长的字符串  遇到有重复字母的  从重复字母的下一个开始给tempStr赋值  继续向下遍历
    //自己写几个case  通过case总结出遍历方法
    // asjrgapa 这个case对我的帮助最大  只遍历一次的速度才能满足要求   在遍历过程中动态调整tempStr的位置
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int firstSamePosition = 0;//记录tempStr的开始位置
        char[] chars = s.toCharArray();
        String tempStr = "";
        for (int i = 0; i < chars.length; i++) {
            int index = tempStr.indexOf(chars[i]);
            if (index == -1) {
                tempStr += chars[i];
            } else {
                firstSamePosition = index + firstSamePosition + 1;
                tempStr = s.substring(firstSamePosition, i + 1);
            }

            if (maxLength < tempStr.length()) {
                maxLength = tempStr.length();
            }
        }
        return maxLength;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int up = 0;

        while (l1 != null || l2 != null) {
            int l1val = 0, l2val = 0;
            if (l1 != null) {
                l1val = l1.val;
            }
            if (l2 != null) {
                l2val = l2.val;
            }
            int sum = l1val + l2val + up;
            up = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (up == 1) {
            current.next = new ListNode(up);
        }

        return head.next;
    }

    @Test
    public void testFindMedianSortedArrays() {
        System.out.println(findMedianSortedArrays(new int[]{1, 3,4}, new int[]{2}));
    }

    public double findMedianSortedArraysSlow(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        LinkedList<Integer> newNums = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            newNums.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            for (int k = 0; k < newNums.size(); k++) {
                if (nums2[j] >= newNums.get(k)) {
                    newNums.add(k + 1, nums2[j]);
                    break;
                }
            }
        }

        System.out.println(newNums);
        return 0.0;
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int num = a.length + b.length;
        if (num % 2 == 1) {
            return findKth(a, 0, b, 0, num / 2 + 1);
        } else {
            return (findKth(a, 0, b, 0, num / 2) + findKth(a, 0, b, 0, num / 2 + 1)) / 2.0;
        }
    }

    public double findKth(int a[], int astart, int b[], int bstart, int k) {

        if (astart >= a.length) {
            return b[bstart + k - 1];
        }
        if (bstart >= b.length) {
            return a[astart + k - 1];
        }

        if (k == 1) {
            return Math.min(a[astart], b[bstart]);
        }

        int aKey = astart + k / 2 - 1 < a.length ? a[astart + k / 2 - 1] : Integer.MAX_VALUE;
        int bKey = bstart + k / 2 - 1 < b.length ? b[bstart + k / 2 - 1] : Integer.MAX_VALUE;

        if (aKey < bKey) {
            return findKth(a, astart + k / 2, b, bstart, k - k / 2);
        } else {
            return findKth(a, astart, b, bstart + k / 2, k - k / 2);
        }
    }


    // k = (m+n)/2   a[k/2-1]<b[k/2-1]  如果a融合到b中   a[0] 到 a[k/2-1 ] 都是小于融合后第k小元素的值
    public double findKthLearn(int a[], int astart, int b[], int bstart, int k) {

        if (astart >= a.length) {
            return b[bstart + k - 1];
        }
        if (bstart >= b.length) {
            return a[astart + k - 1];
        }

        if (k == 1) {
            return Math.min(a[astart], b[bstart]);
        }


        int aVal = astart + k / 2 - 1 < a.length ? a[astart + k / 2 - 1] : Integer.MAX_VALUE;
        int bVal = bstart + k / 2 - 1 < b.length ? b[bstart + k / 2 - 1] : Integer.MAX_VALUE;

        if (aVal < bVal) {
            return findKthLearn(a, astart + k / 2, b, bstart, k - k / 2);
        } else {
            return findKthLearn(a, astart, b, bstart + k / 2, k - k / 2);
        }
    }

    @Test
    public void testConvert() {
        System.out.println(convert("abcdefghijklmn", 3));
    }

    /*
    * 0     6
    * 1   5
    * 2 4
    * 3
    *
    * 0   4
    * 1 3
    * 2
    * */
    public String convert(String str, int numRows) {
        if (null == str || numRows < 1) {
            return "";
        }
        int size = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < str.length(); j += size) {
                sb.append(str.charAt(j));
                if (i != 0 && i != numRows) {
                    sb.append(str.charAt(2 * (numRows - 1 - i)));
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void testisPalindrome() {
        System.out.println(isPalindrome(12321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int length = 1;
        while (x / length >= 10) {
            length *= 10;
        }

        while (x != 0) {
            int left = x / length;
            int right = x % 10;
            if (left != right)
                return false;
            x = (x % length) / 10;
            length /= 100;
        }
        return true;
    }

    /*
    * test case:
    *  -1  maxvalue
    *
    *
    * */
    @Test
    public void testMyAtoi() {
        char[] chars = {0, 9};
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {
        if ("".equals(str) || null == str) {
            return 0;
        }
        int result = 0;
        int last = 0;
        char[] chars = str.toCharArray();
        int start = -1;
        int sign=1;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (32 == temp && start != -1) {
                return 0;
            }else if (32 == temp && start == -1) {
                continue;
            } else if (start == -1) {
                start = i;
                if(chars[start]=='-'){
                    sign=-1;
                }
                if (chars[start] == 45 || chars[start] == 43) {
                    continue;
                }
            }

            if (temp >= 48 && temp <= 57) {
                result = result * 10 + temp - 48;
                if (result / 10 != last&&result!=-2147483648) {
                    return 0;
                }
                last = result;
            } else {
                break;
            }

        }
        if (chars[start] == 45) {
            result = -result;
        }
        return result;
    }

    @Test
    public void testLengthOfLastWord(){
//        char[] chars = {'a', 'b', 'A'};
        System.out.println(lengthOfLastWord("   cCGiKdpcAjnbQbewGXqQDKuuwcg"));
    }

    public int lengthOfLastWord(String s) {
        int length=0;
        int isStart=-1;
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(isStart==-1&&c==' '){
                continue;
            }
            if(c>='A'&&c<='z'){
                isStart++;
                length++;
                if(i==0){
                    return length;
                }
            }else {
                return length;
            }
        }
        return length;
    }


    /**
     * testcase: 2147395599
     */
    @Test
    public void testSqrt(){
        System.out.println(sqrt(2147395599));
    }

    /**
     *
     * mplement int sqrt(int x).
     *
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     *
     * Example 1:
     *
     * Input: 4
     * Output: 2
     *
     * Example 2:
     *
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     *              the decimal part is truncated, 2 is returned.
     *
     * 注意，因为计算过程涉及到平方运算，为了防止int的最大值出现，所以使用long类型保存中间类型
     *
     * 二分查找
     *
     * */

    public int sqrt(int num){
        long mid;
        long lo=0,hi=num;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if(mid*mid==num){
                return (int)mid;
            }else if(mid*mid>num){
                long next=(int)mid-1;
                if(next*next<num)
                    return (int)next;
                hi=next;
            }else {
                int next=(int)mid+1;
//                if(next*next>num)   不需要这个操作，因为题目要求
//                    return next;
                lo=next;
            }
        }
        return -1;
    }

    /**
     *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */

    @Test
    public void mergeKLists(){
        ListNode[] lists=new ListNode[3];
        ListNode node0 = new ListNode(1);
        node0.next=new ListNode(2);

        ListNode node1 = new ListNode(6);
        node1.next=new ListNode(9);

        ListNode node2 = new ListNode(3);
        node2.next=new ListNode(8);

        lists[0]=node0;
        lists[1]=node1;
        lists[2]=node2;

        ListNode node = mergeKLists(lists);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode node = lists[i];
            while(node!=null){
                q.add(node.val);
                node=node.next;
            }
        }

        ListNode node=null,head=null;
        while (q.size()!=0){
            if(node==null){
                node=new ListNode(q.poll());
                head=node;
            }else {
                node.next=new ListNode(q.poll());
                node=node.next;
            }
        }
        return head;
    }


    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     *
     *
     * Example 1:
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     *
     * Example 2:
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the first node.
     *
     *
     * Example 3:
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     * 核心思想:快慢指针
     */
    @Test
    public void testCycle(){
        ListNode node0 = new ListNode(1);
        node0.next=new ListNode(2);
        node0.next.next=new ListNode(1);
        node0.next.next.next=node0.next;
        System.out.println(hasCycle(node0));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }


    /**
     * 贪心、动态规划
     */

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     *
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     *
     * 关键点：单向，不能往回走
     */

    @Test
    public void testProfit(){
        int prices[]={7,1,5,3,6,4};
//        int prices[]={4};
        System.out.println(maxProfitOnepass(prices));
    }


    //BruteForce
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<2)
            return 0;
//        int table[][]=new int[len][len];
        int max=0;
        for(int i=0;i<len-1;i++){//第i天买
            for(int j=i+1;j<len;j++){//第j天卖
                int profit=prices[j]-prices[i];
                if(profit>max)
                    max=profit;
//                if(i>0){
//                    if(profit<table[i-1][j]){
//                        profit=table[i-1][j];
//                    }
//                }
//                if(profit>table[i][j-1]){
//                    table[i][j]=profit;
//                }else {
//                    table[i][j]=table[i][j-1];
//                }

            }
        }

        return max;
//        return table[len-2][len-1];

    }

    public int maxProfitOnepass(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else if(prices[i]-min>max){
                max=prices[i]-min;
            }
        }
        return max;
    }


    /**
     *
     * 322. Coin Change
     * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Example 1:
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     *
     * Example 2:
     *
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     * 必须动手画，找状态转移方程
     *
     */
    @Test
    public void testCoin(){
        int coins[] = {1,2,5};
        System.out.println(coinChange(coins,10));
    }

    public int coinChange(int[] coins, int amount) {
        int table[][] =new int[coins.length][amount+1];

        if(coins.length<1){
            return -1;
        }

        if(coins.length<2){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
        }

        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                table[i][j]=amount+1;
            }
        }

        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){
                table[0][j]=j/coins[0];
            }
            System.out.print(table[0][j]+" ");
        }

        System.out.println();
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j-coins[i]>=0){
                    table[i][j]=Math.min(table[i-1][j],table[i][j-coins[i]]+1);//核心部分
                }else{
                    table[i][j]=table[i-1][j];
                }
                System.out.print(table[i][j]+" ");

            }
            System.out.println();

        }

        return table[coins.length-1][amount]==amount+1?-1:table[coins.length-1][amount];
    }

    public int coinChangeAC(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * 169. Majority Element
     * Easy
     *
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     *
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     *
     */
    @Test
    public void testMajority(){
        int nums[]={2,1,2,2,2,2,1,2,3,3,3,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int half=nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            Integer val = map.get(num);
            if(val==null){
                map.put(num,1);
            }else {
                map.put(num,++val);
                if(val>half){
                    return num;
                }
            }

//            Integer peek = queue.peek();

        }
        return 0;
    }

    /**
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     *     Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
     */

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode temp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp;
        return root;
    }
}
