package leetcode.medium.graph.leet_1514;


// 무방향 가중치 그래프 (undirected weighted graph)
// 분할정복으로 문제를 풀어보자.
// 노드 방문이 아니라 '경로 통과'로 봐야 할듯. -> X
    // '경로 통과'는 pass[start][end]. 즉 start -> end 지났는지 파악 X
// 한 번 실행마다 방문 체크 및 호출 종료시 방문 체크 해제?
// 노드 개수는 100000


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_1514 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
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
        double[] distanceToEnd = new double[n];
        double[][] weighted = new double[n][n];
        boolean[][] passed = new boolean[n][n];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        preMake(n, edges, succProb, weighted, graph);

        return distanceToEnd[end];
    }

    public static void search(
            Map<Integer, List<Integer>> graph,
            double[][] weighted,
            double[] distanceToEnd,
            boolean[][] passed,
            int curNode,
            int end)
    {


        if (curNode != end) {
            List<Integer> searchList = graph.get(curNode);
            double minToNext = Double.MAX_VALUE;
            for (Integer nextNode : searchList) {
                double weightToNext = weighted[curNode][nextNode];

                if (!passed[curNode][nextNode]) {
                    // 순회하기 전에 true 해주자.
                    passed[curNode][nextNode] = true;


                } else {

                }
            }

        }
    }

    private static void preMake(int n, int[][] edges, double[] succProb, double[][] weighted, Map<Integer, List<Integer>> graph) {

        for (int i=0; i<edges.length; i++) {
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
