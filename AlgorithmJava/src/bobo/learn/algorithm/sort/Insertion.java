package bobo.learn.algorithm.sort;

import static bobo.learn.algorithm.sort.MergeSort.exch;
import static bobo.learn.algorithm.sort.MergeSort.less;

public class Insertion {

    public void sort(Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public void binaryInsertionSort(Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            int lo = 0, hi = i;
            int mid = lo + (hi - lo) / 2;
            Comparable v = a[i];
            while(lo<hi){
                if(less(v,a[mid])){
                    hi = mid;
                }else {
                    lo = mid+1;
                }
            }
            for(int j=i;j>lo;j--){
                a[j] = a[j-1];
            }
            a[lo] =v;
        }
    }
}
