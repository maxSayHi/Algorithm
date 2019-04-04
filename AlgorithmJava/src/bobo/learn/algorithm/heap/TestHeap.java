package bobo.learn.algorithm.heap;

import java.util.PriorityQueue;

public class TestHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        pqueue.add(3);
        pqueue.add(-60);
        pqueue.add(9);
        pqueue.add(-1);
        pqueue.add(6);
        pqueue.add(3);
//        System.out.println(pqueue.poll());
        while(pqueue.size()!=0){
            System.out.println(pqueue.poll());
        }
    }
}
