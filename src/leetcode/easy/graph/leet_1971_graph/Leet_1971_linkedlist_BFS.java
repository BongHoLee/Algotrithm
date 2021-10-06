package leetcode.easy.graph.leet_1971_graph;

import java.util.*;

public class Leet_1971_linkedlist_BFS {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int start = 0;
        int end = 5;

        System.out.println(validPath(n, edges, start, end));
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        if (n <= 0 || start == end) {
            return true;
        }
        Map<Integer, List<Integer>> graph = makeGraph(edges);
        boolean[] visit = new boolean[n];

        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(start);
        visit[start] = true;

        while(!bfsQ.isEmpty()) {
            Integer node = bfsQ.remove();

            List<Integer> adjacent = graph.get(node);
            for (Integer each : adjacent) {
                if (!visit[each]) {
                    if (each == end) {
                        return true;
                    } else {
                        visit[each] = true;
                        bfsQ.add(each);
                    }
                }
            }
        }

        return false;
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
