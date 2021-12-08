package bobo.learn.algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * 总结：题目太难了，因为以前没有做过拓扑排序相关的题目，也不了解这个思想。答案完全是抄过来的，甚至抄过来都没了解明白。需要接下来花时间继续研究。
 */
public class CourseScheduleII_ {

    public static void main(String[] args) {
        int[] order = new CourseScheduleII_().findOrder(2, new int[][]{});
        int[] order1 = new CourseScheduleII_().new Solution().findOrder(2, new int[][]{});
        System.out.println(order[0]);
        System.out.println(order1[0]);
    }

    public int[] schedule(int numCourses, int[][] prerequisites) {
        return null;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList());
        }
        int[] indegrees = new int[numCourses];
        for(int[] pre:prerequisites){
            list.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }



        int[] result = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList();
        for(Integer course : indegrees){
            if(indegrees[course] == 0){
                queue.add(course);
            }
        }
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            result[index++] = course;
            for(Integer c : list.get(course)){
                indegrees[c]--;
                if(indegrees[c] == 0){
                    queue.add(c);
                }
            }
        }

        if(index != numCourses){
            return new int[0];
        }

        return result;
    }

    class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 存储每个节点的入度
        int[] indeg;
        // 存储答案
        int[] result;
        // 答案下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            // 将所有入度为 0 的节点放入队列中
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                // 从队首取出一个节点
                int u = queue.poll();
                // 放入答案中
                result[index++] = u;
                for (int v: edges.get(u)) {
                    --indeg[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }
    }

}
