package leetcode.easy.graph.leet_1971_graph;

// vertices : 정점(노드)
// vertex : 인접 정점(연결된 정점)
// edges : 간선

import java.util.LinkedList;
import java.util.Queue;

public class Leet_1971_matrix_BFS {
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
        if (n == 1 && start == end) {
            return true;
        }
        int[][] matrix = makeMatrix(n, edges);

        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(start);

        while (!bfsQ.isEmpty()) {
            int node = bfsQ.remove();
            for (int x = 0; x < matrix[node].length; x++) {
                if (matrix[node][x] != 0) {
                    if (x == end) {
                        return true;
                    } else {
                        matrix[node][x] = 0;
                        matrix[x][node] = 0;
                        bfsQ.add(x);
                    }

                }
            }
        }

        return false;
    }

    private static int[][] makeMatrix(int n, int[][] edges) {
        int[][] matrix = new int[n][n];

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        return matrix;
    }
}
