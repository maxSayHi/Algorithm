package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class LinkedList {

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
}
