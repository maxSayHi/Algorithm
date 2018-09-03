package bobo.learn.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by han on 18-9-3.
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
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next=new ListNode(5);
        l2.next.next=new ListNode(6);

        ListNode add = add(l1, l2);
        System.out.println(add.val);
        while(add!=null){
            System.out.println(add.next.val);
            add=add.next;
        }
    }


    public ListNode add(ListNode l1, ListNode l2){
        //进位
        int nextValue=0;
        int current=l1.val+l2.val;
        ListNode result = new ListNode(current);
        nextValue = current/10;
        while(true){
            if(l1.next!=null&&l2.next!=null){
                current=l1.next.val+l2.next.val;
                if(nextValue>0){
                    current+=1;
                }
                nextValue = current/10;
                result.next=new ListNode(current);
            }else if(l1.next!=null&&l2.next==null){
                current=l1.next.val;
                if(nextValue>0){
                    current+=nextValue;
                }
                nextValue = current/10;
                result.next=new ListNode(current);
            }else if(l1.next==null&&l2.next!=null){
                current=l2.next.val;
                if(nextValue>0){
                    current+=nextValue;
                }
                nextValue = current/10;
                result.next=new ListNode(current);
            }else if(nextValue>0){
                current=nextValue;
                nextValue = current/10;
                result.next=new ListNode(current);
            }else {
                break;
            }
        }

        return result;
    }
}
