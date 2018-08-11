package bobo.learn.algorithm.quick;

/**
 * Created by han on 17-10-27.
 */
public class MergeSort {

    public void MergeQsort(Comparable a[], int lo, int hi) {
        if(lo<=hi) return;
        int mid = lo+(hi-lo)/2;
        MergeQsort(a,lo,mid);
        MergeQsort(a,mid+1,hi);
        merge(a,lo,hi,mid);
    }

    public void merge(Comparable a[],int lo,int hi,int mid){
        int i=lo;
        int j=mid+1;
        Comparable aux[]=new Comparable[a.length];
        for(int k=0;i<a.length;k++){
            aux[k]=a[k];
        }
        for(int k=0;i<a.length;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(a[j],a[i])) a[k]=a[j++];
            else a[k]=a[i++];
        }
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
