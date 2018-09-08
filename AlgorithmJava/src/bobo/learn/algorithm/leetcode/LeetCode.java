package bobo.learn.algorithm.leetcode;

import org.junit.Test;

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

}
