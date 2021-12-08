package bobo.learn.algorithm.leetcode.graph;

import java.util.*;

public class Dijkstra {

    class Node implements Comparator<Node> {

        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    PriorityQueue<Node> queue = new PriorityQueue<>();
    Set<Node> settled = new HashSet<>();
    List<List<Node>> adj = new ArrayList<>();
    int V = 5;
    int[] dist = new int[V];

    public void dijkstra(List<List<Node>> adj, int src) {
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        queue.add(new Node(0, 0));

        while (settled.size() != V) {

            if (queue.isEmpty()) {
                return;
            }

            int remove = queue.remove().node;
            if (settled.contains(remove)) {
                return;
            }
            neighbor(remove);
        }
    }

    public void neighbor(int node) {
        int edgeDistance = -1;
        int newDistance = -1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            Node n = adj.get(node).get(i);
            edgeDistance = n.cost;
            newDistance = dist[node] + edgeDistance;
            if (newDistance < dist[n.node]) {
                dist[n.node] = newDistance;
            }
            queue.add(new Node(n.node, dist[n.node]));
        }
    }

}
