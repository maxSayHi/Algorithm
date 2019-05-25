package bobo.learn.algorithm.leetcode.Dynamic;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Bag {


    private int weight[]=new int[]{1,4,3,1};
    private int values[]=new int[]{1500,3000,2000,2000};
    private int n=weight.length;
    private int w= 4;
    private int status[][]=new int[n][w];

    public void calMaxValue(){
        for(int col=0;col<w;col++){
            status[0][col]=values[0];
        }

        for(int row=1;row<n;row++){
            for(int col=0;col<w;col++){
                int aboveValue= status[row-1][col];
                if(col+1-weight[row]>0){
                    int currentValue = values[row]+status[row-1][col-weight[row]];
                    status[row][col]=Math.max(
                            aboveValue,
                            currentValue
                    );
                }else if(col+1-weight[row]==0){
                    int currentValue = values[row];
                    status[row][col]=Math.max(
                            aboveValue,
                            currentValue
                    );
                }else {
                    status[row][col] = aboveValue;
                }

                System.out.print(status[row][col]+" ");
            }
            System.out.println();
        }

    }


    /**
     * 想优化成一维数组，关键点在于第59行，必须要从大到小
     */
    public void calMaxValueOptimize(){
        int status[]=new int[w];

        for(int col=0;col<w;col++){
            status[col]=values[0];
        }

        for(int row=1;row<n;row++){
            for(int col=w-1;col>=0;col--){
                int aboveValue= status[col];
                if(col+1-weight[row]>0){
                    int currentValue = values[row]+status[col-weight[row]];
                    status[col]=Math.max(
                            aboveValue,
                            currentValue
                    );
                }else if(col+1-weight[row]==0){
                    int currentValue = values[row];
                    status[col]=Math.max(
                            aboveValue,
                            currentValue
                    );
                }else {
                    status[col] = aboveValue;
                }

                System.out.print(status[col]+" ");
            }
            System.out.println();
        }

    }

    @Test
    public void testCalMaxValue(){
//        calMaxValue();
        calMaxValueOptimize();
    }
}
