package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.


 解决问题的办法，大致如下：
 1 使用快速排序的思想，把数组分成左右，知道找到比target大的一边数组个数为k左右，时间复杂度O(n),worest(n^2)
 2 (不推荐)使用快速排序将数组排序，然后找到第K大
 3 使用最大堆，最小堆(目前不理解)
 4 最牛逼的，把数组以5为单位，分成等份，使用中位数，最终效果是最坏情况O(n),同样，不理解这种算法
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            int temp=nums[i];
            nums[i]=nums[nums.length-i-1];
            nums[nums.length-i-1]=temp;
        }
        return nums[k-1];
    }


    @Test
    public void testFindKth(){
        int arr[] = new int[]{12, 3, 5, 7, 4, 19,19,26, 26};
        int k = 5;
        System.out.println(kth(arr,0,arr.length-1,k));
    }

    public int kth(int arr[],int l, int r,int k){
        if(k>0&&k<=r-l+1){
            int pos=partition(arr,l,r);

            if (pos - l == k - 1) {
                return arr[pos];
            }else if( pos -l > k-1){
                return kth(arr,l,pos-1,k);
            }else{
                return kth(arr,pos+1,r,k-(pos-l)-1);
            }
        }
        return Integer.MAX_VALUE;
    }

    public int partition(int arr[],int l,int r){
        int index=l;//the last large index
        int pivot=arr[r];
        for(int i=l;i<r;i++){
            if(arr[i]>=pivot){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                index++;
            }
        }
        int temp = arr[index];
        arr[index]=pivot;
        arr[r]=temp;
        return index;
    }

}
