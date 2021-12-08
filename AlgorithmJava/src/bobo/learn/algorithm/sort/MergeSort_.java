package bobo.learn.algorithm.sort;

/**
 * Created by han on 17-10-27.
 */
public class MergeSort_ {

    public void MergeQsort(Comparable a[],Comparable aux[], int lo, int hi) {
        if(lo<hi){
            int mid = lo + (hi-lo)/2;
            MergeQsort(a,aux,lo,mid);
            MergeQsort(a,aux,mid+1,hi);
            merge(a,aux,lo,hi,mid);
        }
    }

    public void merge(Comparable a[],Comparable aux[],int lo,int hi,int mid){

        for(int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }

        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++){
            if(i>mid) aux[k] =a[j++];
            else if(j>hi) aux[k] = a[i++];
            else if(less(a[j],a[i])) aux[k] = aux[j++];
            else aux[k] = aux[i++];
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
