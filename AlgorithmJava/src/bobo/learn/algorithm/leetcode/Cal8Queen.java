package bobo.learn.algorithm.leetcode;

import org.junit.Test;

public class Cal8Queen {
    /**
     * 八皇后问题
     */
    @Test
    public void test8Queen(){
        cal8Queen(0);
    }

    int result[]=new int[8];
    public void cal8Queen(int row){
        if(row==8){
            printQueen();
            return;
        }

        for(int col=0;col<8;col++){
            if(checkOk(row,col)){
                result[row]=col;
                cal8Queen(row+1);
            }
        }
    }

    public boolean checkOk(int row,int col){
        int leftup=col-1,rightup=col+1;
        for (int i=row-1;i>=0;i--){
            if(result[i]==col) return false;
            if(leftup>=0){
                if(result[i]==leftup) return false;
            }
            if(rightup<8){
                if(result[i]==rightup) return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public void printQueen(){
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(result[row]==col)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
