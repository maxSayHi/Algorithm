package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class BinSearch {

    @Test
    public void testBinSearch(){
        int arr[]=new int[]{1,3,5,7,9,10};
        System.out.println(binSearch(arr,0));
    }

    public int binSearch(int arr[],int k){
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            if(arr[mid]<k){
                lo=mid+1;
            }else if(arr[mid]>k){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
