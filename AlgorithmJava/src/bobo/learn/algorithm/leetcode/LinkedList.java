package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class LinkedList<I extends Number> {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    @Test
    public void testReverse(){
        ListNode node = new ListNode(0);
//        node.next=new ListNode(1);
//        node.next.next=new ListNode(2);

        node = reverseLinkdedList(node);

        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }

    public ListNode reverseLinkdedList(ListNode head){
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;
    }

    class LinkListOneway{

        ListNode head;

        public int get(int index){
            ListNode n=head;
            int pos=0;
            while (n!=null){
                if(pos++==index){
                    return n.val;
                }
                n=n.next;
            }
            java.util.LinkedList<Object> list = new java.util.LinkedList<>();
            return 0;
        }

        public void add(int val){
            if(head==null){
                head = new ListNode(val);
            }else {
                ListNode temp=head;
                while (temp.next!=null){
                    temp=temp.next;
                }
                temp.next= new ListNode(val);
            }

        }

        public void delete(int index){
            ListNode n=head;
            int pos=0;
            while(n!=null){
                if(pos==index){

                    if(pos==0){
                        head=null;
                        return;
                    }

                    ListNode pre=head;
                    while(pre!=null){
                        if(pre.next==n){
                            pre.next=pre.next.next;//删除操作
                        }
                    }
                    return;
                }
                pos++;
                n=n.next;
            }

        }
    }

    @Test
    public void testMerge(){
        ListNode left=new ListNode(0);
        left.next=new ListNode(2);
        left.next.next=new ListNode(5);
        left.next.next.next=new ListNode(8);
        ListNode right=new ListNode(1);
        right.next=new ListNode(3);
        ListNode n=merge(left,right);
        while(n!=null){
            System.out.println(n.val);
            n=n.next;
        }
    }

    /**
     * 合并两个有序链表
     * @param left
     * @param right
     * @return
     */
    public ListNode merge(ListNode left, ListNode right){
        ListNode result=null,head=null;
        while(true){
            if(left==null&&right==null){
                break;
            }else if(left==null){
                if(result==null){
                    result=right;
                    head=result;
                }else {
                    result.next=right;
                    result=result.next;
                }
                right=right.next;
            }else if(right==null){
                if(result==null){
                    result=left;
                    head=result;
                }else {
                    result.next=left;
                    result=result.next;
                }
                left=left.next;
            }else if(left.val>right.val){
                if(result==null){
                    result=right;
                    head=result;
                }else {
                    result.next=right;
                    result=result.next;
                }
                right=right.next;
            }else {
                if(result==null){
                    result=left;
                    head=result;
                }else {
                    result.next=left;
                    result=result.next;
                }
                left=left.next;
            }
        }
        return head;
    }
    @Test
    public void testMedian(){
        ListNode node = new ListNode(0);
        node.next=new ListNode(2);
//        node.next.next=new ListNode(6);
//        node.next.next.next=new ListNode(8);

        System.out.println(medianOfList(node).val);
    }
    //求链表中间节点
    public ListNode medianOfList(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }


    /**
     *
     * 160. Intersection of Two Linked Lists
     * Easy
     *
     * 2098
     *
     * 179
     *
     * Favorite
     *
     * Share
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     * For example, the following two linked lists:
     *
     *
     * begin to intersect at node c1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     *
     *
     * Example 2:
     *
     *
     * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Reference of the node with value = 2
     * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     *
     *
     * Example 3:
     *
     *
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: null
     * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     *
     *
     * Notes:
     *
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     *
     *
     * https://www.cnblogs.com/grandyang/p/4128461.html
     * 关键点：走过的路程一样，最终一定会相遇
     *
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b =headB;
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }

        return a;
    }

    /**
     *
     * 237. Delete Node in a Linked List
     * Easy
     *
     * 737
     *
     * 3462
     *
     * Favorite
     *
     * Share
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     *
     * Given linked list -- head = [4,5,1,9], which looks like following:
     *
     *
     *
     *
     *
     * Example 1:
     *
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
     * Example 2:
     *
     * Input: head = [4,5,1,9], node = 1
     * Output: [4,5,9]
     * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
     *
     *
     * Note:
     *
     * The linked list will have at least two elements.
     * All of the nodes' values will be unique.
     * The given node will not be the tail and it will always be a valid node of the linked list.
     * Do not return anything from your function.
     *
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     *
     * 19. Remove Nth Node From End of List
     * Medium
     *
     * 1830
     *
     * 137
     *
     * Favorite
     *
     * Share
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     *
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     *
     * Given n will always be valid.
     *
     */

    @Test
    public void testRemove(){
        ListNode left=new ListNode(1);
//        left.next=new ListNode(2);
//        left.next.next=new ListNode(3);
//        left.next.next.next=new ListNode(4);
//        left.next.next.next.next=new ListNode(5);
        ListNode listNode = removeNthFromEnd(left, 1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        ListNode root = head;
        while (n-->0){
            root=root.next;
        }

        //删除第一个节点，非常特殊
        if(root==null){
            head=head.next;
            return head;
        }

        ListNode newHead = head;
        while(root!=null){
            if(root.next==null){
                if(newHead.next==null){
                    newHead=null;
                }else {
                    newHead.next=newHead.next.next;
                }
            }
            root=root.next;
            newHead=newHead.next;
        }
        return head;
    }
}