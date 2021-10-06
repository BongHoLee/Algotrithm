package leetcode.easy.graph.leet_1971_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_1971_linkedlist_dfs {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int start = 0;
        int end = 5;

        System.out.println(validPath(n, edges, start, end));

    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = makeGraph(edges);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        return dfs(graph, visited, start, end);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curNode, int end) {
        if (curNode == end) {
            return true;
        } else {
            List<Integer> dfsSearchList = graph.get(curNode);
            boolean found = false;
            for (int eachNode : dfsSearchList) {
                if (!visited[eachNode]) {
                    visited[eachNode] = true;
                    found = dfs(graph, visited, eachNode, end);

                    if (found) break;
                }
            }

            return found;
        }
    }

    private static Map<Integer, List<Integer>> makeGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
