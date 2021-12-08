package bobo.learn.algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *
 * 总结：题目太难了，因为以前没有做过拓扑排序相关的题目，也不了解这个思想。答案完全是抄过来的，甚至抄过来都没了解明白。需要接下来花时间继续研究。
 *
 * 三刷总结：queue里面存的是index，一定要记住！  为此，对比代码对比了1个多小时，还是自己没有理解透算法！！
 *
 */
public class CourseScheduleII {

    public static void main(String[] args) {

    }

    public int[] schedule(int numCourses, int[][] prerequisites) {
        //这个list，只是保存了课程之间的关系而已
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;

        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            ++indeg[pre[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[index++] = poll;
            for (int edge : edges.get(poll)) {
                --indeg[edge];
                if (indeg[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return result;

    }

}
