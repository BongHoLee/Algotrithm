package leetcode.medium.graph.leet_1514;


// 무방향 가중치 그래프 (undirected weighted graph)
// 분할정복으로 문제를 풀어보자.
// 노드 방문이 아니라 '경로 통과'로 봐야 할듯. -> X
// '경로 통과'는 pass[start][end]. 즉 start -> end 지났는지 파악 X
// 한 번 실행마다 방문 체크 및 호출 종료시 방문 체크 해제?

// 방문했던 노드는 재방문 하지 않게끔?

// 많이 헷갈린다. 일단 풀기전에 좀 정리해보기.


// DFS에 있어서 방문했던 노드는 다시 방문하지 않는다.
// 현재 경로에서 아직 방문하지 않은 노드 방향으로 일전 경로에서 해당 방향을 방문했다면 그대로 사용
// 방문하지 않았다면 방문
// 각 방향마다 가중치를 갱신한다.(방향마다 pass or not 체크 필요)

// 정확성은 맞지만 "모든 노드에 대해서 방향에 대한 가중치 갱신"에 따른 시간 초과가 발생한다.
// 그래도 깊게 고민해서 풀었다는 것에 상당히 고무적
// 시간 복잡도는 '모든 노드'에 대해서 '통과 가능한 edges'를 탐색하기 때문에 `O(N) * O(E) == O(N) * O(N^2) == O(N^3)임.

// 실제 다익스트라 알고리즘을 이용해서 "start"에 대한 내용만 갱신하면 된다. 즉, 방문하는 노드마다 갱신해야 하는 "재귀적" 로직이 필요 없음.

// 노드 개수는 100000


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_1514_AllPathsFind {
    static int count = 0;
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {0, 4},
                {1, 0},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 0},
                {2, 1},
                {2, 3},
                {2, 4},
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {4, 0},
                {4, 1},
                {4, 2},
                {4, 3},


        };

        double[] succProb = {
                1,
                1,
                2,
                1,
                3,
                2,
                1,
                3,
                1,
                2,
                1,
                3,
                5,
                1,
                7,
                2,
                3,
                1,
                2,
                1
        };

        int start = 0;
        int end = 4;

        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] weighted = new double[n][n];
        boolean[][] passed = new boolean[n][n];
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        preMake(edges, succProb, weighted, graph);

        visited[start] = true;
        double result =search(graph, visited, weighted, passed, start, end);
        System.out.println(count);
        return result;
    }

    public static double search(
            Map<Integer, List<Integer>> graph,
            boolean[] visited,
            double[][] weight,
            boolean[][] passed,
            int curNode,
            int end) {


        if (curNode == end) {
            return 1.0;
        } else {
            double maxPassWeight = 0;
            if (graph.containsKey(curNode)) {
                List<Integer> searchList = graph.get(curNode);
                for (Integer nextNode : searchList) {
                    count++;
                    if (visited[nextNode]) {
                        continue;
                    }

                    if (!passed[curNode][nextNode]) {
                        visited[nextNode] = true;
                        double nextNodePassWeight = search(graph, visited, weight, passed, nextNode, end);
                        weight[curNode][nextNode] = weight[curNode][nextNode] * nextNodePassWeight;
                        passed[curNode][nextNode] = true;
                        visited[nextNode] = false;

                    }
                    maxPassWeight = Math.max(weight[curNode][nextNode], maxPassWeight);
                }
            }

            return maxPassWeight;
        }
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
