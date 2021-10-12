package leetcode.medium.graph.leet_1514;

import java.util.*;

// 다익스트라 알고리즘
// start에 대한 갱신만 하면 된다.
// 경로가 '작은' 애들부터 우선 방문해야한다. (그렇지 않으면 최단경로가 이상하게 갱신된다. 방문 순서가 중요)
// 논리를 잘 생각하자. 왜 이런 로직이 나오는지를 이해

// 어떤 경우가 '방문'한 경우인지, 왜 '방문'한 노드는 재방문 하지 않는지
// 머리로는 이해 했지만 말로 설명하면 어렵다. 확실히 설명할 수 있도록 하자.


public class Leet_1514_List {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0,1},
                {1,2},
                {0,2}
        };

        double[] succProb = {
                0.5,
                0.5,
                0.2
        };

        int start = 0;
        int end = 2;

        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] weighted = new double[n][n];
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        preMake(edges, succProb, weighted, graph);

        return 0;
    }

    private static double dijkstra(int start, int end, Map<Integer, List<Integer>> graph, boolean[] visited, double[][] weighted) {
        visited[start] = true;

        return 0;
    }

    private static void preMake(int[][] edges, double[] succProb, double[][] weighted, Map<Integer, List<Integer>> graph) {

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            weighted[edge[0]][edge[1]] = prob;
            weighted[edge[1]][edge[0]] = prob;

            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

}
