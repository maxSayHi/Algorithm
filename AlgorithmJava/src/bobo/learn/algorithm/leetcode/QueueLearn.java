package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueLearn {
    /**
     * 239. Sliding Window Maximum
     * Hard
     * <p>
     * 1671
     * <p>
     * 99
     * <p>
     * Favorite
     * <p>
     * Share
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * <p>
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     * <p>
     * Follow up:
     * Could you solve it in linear time?
     * <p>
     * https://www.cnblogs.com/grandyang/p/4656517.html
     * <p>
     * <p>
     * 使用dequeue存储下标
     * 滑动窗口，只保留最大的元素下标
     * dequeue.getFirst()==i-k 很关键，保证滑动窗口内，直到滑动到自己，才被pollFirst
     */
    @Test
    public void testSlidingWindow() {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (Integer i : ints) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> dequeue = new LinkedList<>();
        if (nums.length < 1) return new int[0];
        int result[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!dequeue.isEmpty() && dequeue.getFirst() == i - k) dequeue.pollFirst();
            while (!dequeue.isEmpty() && nums[i] > nums[dequeue.getLast()]) dequeue.pollLast();
            dequeue.addLast(i);
            if (i >= k - 1) {//已经滑动满一个窗口
                result[i - k + 1] = nums[dequeue.getFirst()];
            }
        }
        return result;
    }


    /**
     * 641. Design Circular Deque
     * Medium
     * <p>
     * 100
     * <p>
     * 29
     * <p>
     * Favorite
     * <p>
     * Share
     * Design your implementation of the circular double-ended queue (deque).
     * <p>
     * Your implementation should support following operations:
     * <p>
     * MyCircularDeque(k): Constructor, set the size of the deque to be k.
     * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
     * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
     * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
     * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
     * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
     * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
     * isEmpty(): Checks whether Deque is empty or not.
     * isFull(): Checks whether Deque is full or not.
     * <p>
     * <p>
     * Example:
     * <p>
     * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
     * circularDeque.insertLast(1);			// return true
     * circularDeque.insertLast(2);			// return true
     * circularDeque.insertFront(3);			// return true
     * circularDeque.insertFront(4);			// return false, the queue is full
     * circularDeque.getRear();  			// return 2
     * circularDeque.isFull();				// return true
     * circularDeque.deleteLast();			// return true
     * circularDeque.insertFront(4);			// return true
     * circularDeque.getFront();			// return 4
     * <p>
     * <p>
     * Note:
     * <p>
     * All values will be in the range of [0, 1000].
     * The number of operations will be in the range of [1, 1000].
     * Please do not use the built-in Deque library.
     * <p>
     * <p>
     * https://www.cnblogs.com/lightwindy/p/10154027.html
     */

    class Node {
        public Node next;
        public Node pre;
        public int val;

        Node(int val) {
            this.val = val;
        }
    }

    class MyCircularDeque {
        Node head;
        Node tail;
        int size;
        int cnt = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (cnt == size)
                return false;
            Node node = new Node(value);
            if (head == null) {
                head = node;
                tail = node;
                node.pre = node;
                node.next = node;
            } else {
                node.next = head;
                node.pre = head.pre;
                head.pre.next = node;
                head.pre = node;
                head = node;
            }
            cnt++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (cnt == size)
                return false;
            Node node = new Node(value);
            if (head == null) {
                head = node;
                tail = node;
                node.pre = node;
                node.next = node;
            } else {
                node.next = tail.next;
                node.pre = tail;
                tail.next.pre = node;
                tail.next = node;//之前写成了tail.pre=node，花费了3个多小时解决，最终通过读代码发现，Read the fucking source code!!
                tail = node;
            }
            cnt++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (cnt == 0)
                return false;
            if (head == tail) {
                head = null;
            } else {
                head.pre.next = head.next;
                head.next.pre = head.pre;
                head = head.next;
            }
            cnt--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (cnt == 0)
                return false;

            if (head == tail) {
                head = null;
            } else {
                tail.pre.next = tail.next;
                tail.next.pre = tail.pre;
                tail = tail.pre;
            }
            cnt--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (cnt == 0)
                return -1;
            return head.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (cnt == 0)
                return -1;
            return tail.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return cnt == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == cnt;
        }
    }

    @Test
    public void testMyCircularDeque() {
        MyCircularDeque obj = new MyCircularDeque(77);

//        String cmds[] = new String[]{"MyCircularDeque", "insertFront", "getRear", "deleteLast", "getRear", "insertFront", "insertFront", "insertFront", "insertFront", "isFull", "insertFront", "isFull", "getRear", "deleteLast", "getFront", "getFront", "insertLast", "deleteFront", "getFront", "insertLast", "getRear", "insertLast", "getRear", "getFront", "getFront", "getFront", "getRear", "getRear", "insertFront", "getFront", "getFront", "getFront", "getFront", "deleteFront", "insertFront", "getFront", "deleteLast", "insertLast", "insertLast", "getRear", "getRear", "getRear", "isEmpty", "insertFront", "deleteLast", "getFront", "deleteLast", "getRear", "getFront", "isFull", "isFull", "deleteFront", "getFront", "deleteLast", "getRear", "insertFront", "getFront", "insertFront", "insertFront", "getRear", "isFull", "getFront", "getFront", "insertFront", "insertLast", "getRear", "getRear", "deleteLast", "insertFront", "getRear", "insertLast", "getFront", "getFront", "getFront", "getRear", "insertFront", "isEmpty", "getFront", "getFront", "insertFront", "deleteFront", "insertFront", "deleteLast", "getFront", "getRear", "getFront", "insertFront", "getFront", "deleteFront", "insertFront", "isEmpty", "getRear", "getRear", "getRear", "getRear", "deleteFront", "getRear", "isEmpty", "deleteFront", "insertFront", "insertLast", "deleteLast"};
//
//        String vals[] = new String[]{"77", "89", "", "", "", "19", "23", "23", "82", "", "45", "", "", "", "", "", "74", "", "", "98", "", "99", "", "", "", "", "", "", "8", "", "", "", "", "", "75", "", "", "35", "59", "", "", "", "", "22", "", "", "", "", "", "", "", "", "", "", "", "21", "", "26", "63", "", "", "", "", "87", "76", "", "", "", "26", "", "67", "", "", "", "", "36", "", "", "", "72", "", "87", "", "", "", "", "85", "", "", "91", "", "", "", "", "", "", "", "", "", "34", "44", ""};

//        for (int i = 0; i < cmds.length; i++) {
//            if (vals[i].equals("59")) {
//                int j = 0;
//            }
//            if ("insertFront".equals(cmds[i])) {
//                System.out.println(obj.insertFront(Integer.parseInt(vals[i])));
//            } else if ("insertLast".equals(cmds[i])) {
//                System.out.println(obj.insertLast(Integer.parseInt(vals[i])));
//            } else if ("getRear".equals(cmds[i])) {
//                System.out.println(obj.getRear());
//            } else if ("getFront".equals(cmds[i])) {
//                System.out.println(obj.getFront());
//            } else if ("deleteLast".equals(cmds[i])) {
//                System.out.println(obj.deleteLast());
//            } else if ("deleteFront".equals(cmds[i])) {
//                System.out.println(obj.deleteFront());
//            } else if ("isEmpty".equals(cmds[i])) {
//                System.out.println(obj.isEmpty());
//            } else if ("isFull".equals(cmds[i])) {
//                System.out.println(obj.isFull());
//            }
//        }
//        System.out.println(obj.insertFront(20));
//        obj.deleteLast();
//        obj.deleteLast();
//        obj.deleteLast();
//        obj.deleteLast();
//        System.out.println(obj.getFront());
//        System.out.println(obj.isEmpty());
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */


    /**
     *
     * 23. Merge k Sorted Lists
     * Hard
     *
     * 2476
     *
     * 162
     *
     * Favorite
     *
     * Share
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
     *
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length<1) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {

                if(o1.val<o2.val)
                    return -1;
                else if(o1.val>o2.val){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        ListNode result= new ListNode(0);
        ListNode tail = result;

        for(ListNode node:lists){
            if(node!=null)
                queue.add(node);
        }

        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail=tail.next;

            if(tail.next!=null)
                queue.add(tail.next);
        }

        return result.next;
    }
}