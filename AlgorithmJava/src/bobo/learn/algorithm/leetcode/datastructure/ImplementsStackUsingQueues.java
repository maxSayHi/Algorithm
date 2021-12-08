package bobo.learn.algorithm.leetcode.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * <p>
 * 示例：
 *
 * 关键点：脑子里面想象左右两个管子，左面用于存储数据，右面是空的。数据进来的时候加到空罐子里，把左边的数据塞到右边管子中，将最新的元素顶到第一个，最后交换管子。
 *
 */
public class ImplementsStackUsingQueues {
    Queue<Integer> queueL;
    Queue<Integer> queueR;

    public ImplementsStackUsingQueues() {
        queueL = new LinkedList<>();
        queueR = new LinkedList<>();
    }

    public void push(int x) {
        boolean offer = queueR.offer(x);
        while (!queueL.isEmpty()) {
            queueR.add(queueL.poll());
        }
        Queue<Integer> temp = queueL;
        queueL = queueR;
        queueR = temp;
    }

    public int pop() {
        return queueL.poll();
    }

    public int top() {
        return queueL.peek();
    }

    public boolean empty() {
        return queueL.isEmpty();
    }
}
