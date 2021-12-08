package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

/**
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 */
public class CloneGraph {

    public static void main(String[] args) {
        new CloneGraph().test();
    }

    public void test() {

    }

    //太巧妙了!
    public Node clone(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> neighbors = poll.neighbors;
            int size = poll.neighbors.size();
            for (int i = 0; i < size; i++) {
                Node neighbor = neighbors.get(i);
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                visited.get(poll).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    //dfs
    Map<Node, Node> visited = new HashMap<>();

    public Node dfs(Node node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

}