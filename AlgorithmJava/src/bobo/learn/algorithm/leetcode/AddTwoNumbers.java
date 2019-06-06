package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by han on 18-9-3.

 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 */
public class AddTwoNumbers {

    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testAdd(){
        ListNode l1 = new ListNode(9);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next=new ListNode(5);
//        l2.next.next=new ListNode(6);

        ListNode add = add(l1, l2);
        while(add!=null){
            System.out.println(add.val);
            add=add.next;
        }
    }

    /**
     * 关键点：处理进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode add(ListNode l1, ListNode l2){
        //进位
        int nextValue=0;
        int current;
        ListNode result = null;
        ListNode head=null;

        while(true){
            if(l1!=null&&l2!=null){
                current=l1.val+l2.val;
            }else if(l1!=null&&l2==null){
                current=l1.val;
            }else if(l1==null&&l2!=null){
                current=l2.val;
            }else if(nextValue>0){
                current=0;//重置
            }else {
                break;
            }

            //处理进位
            if(nextValue>0){
                current+=nextValue;
            }
            nextValue = current/10;
            //根据进位，处理当前位
            if(nextValue>0){
                current=current%10;
            }

            if(result!=null){
                result.next=new ListNode(current);
                result=result.next;
            }else {
                result=new ListNode(current);
                head=result;
            }

            //移动链表指针
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }

        }

        return head;
    }
}
