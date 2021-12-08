package bobo.learn.algorithm.leetcode.reallife;

/**
 * 1066. 校园自行车分配 II
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。
 * <p>
 * 我们为每一位工人分配一辆专属自行车，使每个工人与其分配到的自行车之间的曼哈顿距离最小化。
 * <p>
 * p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 * <p>
 * 返回每个工人与分配到的自行车之间的曼哈顿距离的最小可能总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * 输出：6
 * 解释：
 * 自行车 0 分配给工人 0，自行车 1 分配给工人 1 。分配得到的曼哈顿距离都是 3, 所以输出为 6 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：4
 * 解释：
 * 先将自行车 0 分配给工人 0，再将自行车 1 分配给工人 1（或工人 2），自行车 2 给工人 2（或工人 1）。如此分配使得曼哈顿距离的总和为 4。
 */
public class CampusBike_ {

    private boolean[] vis;
    private int result;

    public int assignBikes(int[][] workers, int[][] bikes) {
        vis = new boolean[bikes.length];
        return 0;
    }

    public int dfs(int[][] workers, int[][] bikes, int index) {
        return result;
    }

    public int manhaton(int[] worker, int[] bike) {
        return 0;
    }
}
