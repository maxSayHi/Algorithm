package bobo.learn.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayLearn {


    @Test
    public void testMerge(){
        int numleft[]={1,5,8,9,10,11,12,13};
        int numright[]={2,6,8,30};
        int[] ints = mergeTwoSorted(numleft, numright);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    public int[] mergeTwoSorted(int numsleft[],int numsright[]){
        int result[]=new int[numsleft.length+numsright.length];
        int left=0,right=0;
        for(int i=0;i<result.length;i++){
            if(left>=numsleft.length){//左边取尽取右边
                result[i]=numsright[right++];
            }else if(right>=numsright.length){//右边取尽取左边
                result[i]=numsleft[left++];
            }else if(numsleft[left]>numsright[right]){//左比右大取右边
                result[i]=numsright[right++];
            }else {
                result[i]=numsleft[left++];//其他情况取左边
            }
        }

        return result;
    }

    /**
     *
     * 442. Find All Duplicates in an Array
     * Medium
     *
     * 1079
     *
     * 114
     *
     * Favorite
     *
     * Share
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements that appear twice in this array.
     *
     * Could you do it without extra space and in O(n) runtime?
     *
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     *
     * Output:
     * [2,3]
     *
     */

    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> resultset=new HashSet<>();
        for(Integer i : nums){
            if(!set.add(i)){
                resultset.add(i);
            }
        }
        return new ArrayList<>(resultset);
    }
}
