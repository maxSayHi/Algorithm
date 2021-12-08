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
 * <p>
 * 总结：回溯的精髓在ans = Math.min这一行，思考中。非常难理解。 终于参透了一点，其实ans一开始大了没关系，表示的是总路程，只要回溯过程中，
 * 产生了总路程小的值，ans就会缩小
 * <p>
 * 太难了，准备画图死磕。
 * 按照程序，画图完毕。发现ans不是引用，只是值！所以不存在存入较小值之后，再也无法变大的问题。
 *
 *坑点：每个员工，只能分配一个自行车！！！  不管车有多少，都只能分配一个。
 *
 * 算法关键点: 遍历所有  车+人  的组合   每一个人都分配不同的自行车
 *
 * 车和人不能对调，长的在for循环中，可以应对用例中的极端情况
 *
 */
public class CampusBike {
    private boolean[] visited;
    private int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] bikes = new int[][]{{1, 3}, {4, 2}, {4, 4},{10,10}};
        int[][] workers = new int[][]{{3, 1}, {1, 4}};
        int i = new CampusBike().assignBikes(workers, bikes);
        System.out.println(i);
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        visited = new boolean[bikes.length];
        return dfs(workers, bikes, 0);
    }

    public int dfs(int[][] workers, int[][] bikes, int index) {
        if (index == workers.length) {
            return 0;
        }
        for (int i = 0; i < bikes.length; i++) {
            if (!visited[i]) {
                int distance = manhatenLength(workers[index], bikes[i]);
                visited[i] = true;
                //当前的人车距离 + 别的人和别的车的距离
                ans = Math.min(ans, distance + dfs(workers, bikes, index + 1));
                visited[i] = false;
            }
        }
        return ans;
    }

    public int manhatenLength(int[] worker, int bike[]) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

}
