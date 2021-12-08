package bobo.learn.algorithm.sort;

/**
 * Created by han on 17-10-27.
 */
public class QuickSort_ {

    public void Qsort(Comparable a[], int lo, int hi) {
        if(lo>=hi) return;
        int mid = partition(a,lo,hi);
        Qsort(a,lo,mid);
        Qsort(a,mid+1,hi);
    }

    public int partition(Comparable a[], int lo, int hi) {
        Comparable v = a[lo];
        int i=lo,j=hi+1;
        while(true){
            while(less(a[++i],v))if(i==hi)break;
            while(less(v,a[--j]))if(j==lo) break;
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    /***************************************************************************
     * Helper sorting function.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private void exch(Comparable a[], int v, int w) {
        Comparable temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }

}
