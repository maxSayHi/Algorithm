package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

public class TheMaze {
    /**
     * 490. 迷宫
     * 由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
     * 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，其中 start = [startrow, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以，返回 true ；否则，返回 false 。
     * <p>
     * 你可以 假定迷宫的边缘都是墙壁（参考示例）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
     * 输出：true
     * 解释：一种可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
     * 示例 2：
     * <p>
     * <p>
     * 输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
     * 输出：false
     * 解释：不存在能够使球停在目的地的路径。注意，球可以经过目的地，但无法在那里停驻。
     * 示例 3：
     * <p>
     * 输入：maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == maze.length
     * n == maze[i].length
     * 1 <= m, n <= 100
     * maze[i][j] is 0 or 1.
     * start.length == 2
     * destination.length == 2
     * 0 <= startrow, destinationrow <= m
     * 0 <= startcol, destinationcol <= n
     * 球和目的地都在空地上，且初始时它们不在同一位置
     * 迷宫 至少包括 2 块空地
     */

    public static void main(String[] args) {

    }

    public void hasBreath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == destination[0] && poll[1] == destination[1]) {
                return;
            }
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x = x + dir[0];
                    y = y + dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    visited[x - dir[0]][y - dir[1]] = true;
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }

    }
}