package bobo.learn.algorithm.heap;

import java.util.PriorityQueue;

public class TestHeap {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
//        pqueue.add(3);
//        pqueue.add(-60);
//        pqueue.add(9);
//        pqueue.add(-1);
//        pqueue.add(6);
//        pqueue.add(3);
////        System.out.println(pqueue.poll());
//        while(pqueue.size()!=0){
//            System.out.println(pqueue.poll());
//        }
        String name = "轻轻的我走了正如我轻轻的来我轻轻的招手作别西天的云彩docx";

        int endIndex = name.lastIndexOf(".") - 2;


        System.out.println(name.lastIndexOf("."));
    }

    public void heapSort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            //sink(a,k,N)
        }
        while (N > 1) {
            //exch(a,1,N--);
            //sink(a,1,N);
        }
    }
}
