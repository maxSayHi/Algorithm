package bobo.learn.algorithm.leetcode;

import java.util.HashSet;

public class Graph {

    /**
     * 200. Number of Islands
     * Medium
     *
     * Favorite
     *
     * Share
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     *
     * https://blog.csdn.net/mine_song/article/details/69362110
     *
     *
     * 给定的一个二维网格的地图（’1’（陆地）和0（水）），计数岛的数量。岛屿是四面环水，是由相邻的陆地水平或垂直连接而形成的。你可以假设该网格的所有四个边都被水包围。
     * 采用深度优先遍历，把访问过的改为‘0’，继续遍历
     *
     *
     * The basic idea of the following solution is merging adjacent lands, and the merging should be done recursively.
     *
     * Each element is visited once only. So time is O(m*n).
     *
     */

    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        // TODO: 19-6-6 添加判断

        int landcount=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    landcount++;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return landcount;
    }

    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.
    public void dfs(char[][] grid,int i,int j,int row,int col){

        if(i<0||i>row||j<0||j>col||grid[i][j]==0)
            return;
        //把访问过的变为0，合并所有相邻的岛屿
        // 也可以才用一个visited数组，标记遍历过的岛屿
        grid[i][j]='0';
        dfs(grid,i+1,j,row,col);
        dfs(grid,i,j+1,row,col);
        dfs(grid,i-1,j,row,col);
        dfs(grid,i,j-1,row,col);
    }


    /**
     *
     * 36. Valid Sudoku
     * Medium
     *
     * 836
     *
     * 312
     *
     * Favorite
     *
     * Share
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * A partially filled sudoku which is valid.
     *
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     *
     * Example 1:
     *
     * Input:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: true
     * Example 2:
     *
     * Input:
     * [
     *   ["8","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being
     *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character '.'.
     * The given board size is always 9x9.
     *
     * 答案：https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
     * 简直太巧妙了！
     *
     */

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                int num = board[row][col];
                if(num!='.'){
                    if(!seen.add(num+"in row"+row)
                            ||!seen.add(num+"in col"+col)
                            ||!seen.add(num+"in block"+row/3+col/3))
                        return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * 79. Word Search
     *
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     * Example:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     *
     * 总结：和之前岛屿合并的问题非常像，要注意边界检查，length-1
     *
     */
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(exist(board,i,j,word,0)){
                    return true;
                }
            }
        return false;
    }

    public boolean exist(char[][] board,int i,int j,String word,int index){
        if(word.length()==index){
            return true;
        }
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||word.charAt(index)!=board[i][j]){
            return false;
        }
        boolean result = false;
        board[i][j]='*';
        result = exist(board,i+1,j,word,index+1)||
                exist(board,i-1,j,word,index+1)||
                exist(board,i,j+1,word,index+1)||
                exist(board,i,j-1,word,index+1);
        board[i][j]=word.charAt(index);
        return result;
    }
}