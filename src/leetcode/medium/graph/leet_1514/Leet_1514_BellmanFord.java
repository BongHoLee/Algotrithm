package leetcode.medium.graph.leet_1514;

import java.util.*;


// https://leetcode.com/problems/path-with-maximum-probability/discuss/731767/JavaPython-3-2-codes%3A-Bellman-Ford-and-Dijkstra's-algorithm-w-brief-explanation-and-analysis.

// 그래프 최단거리 경로 찾기 - Bellman Ford 알고리즘 사용
// 가중치에 '음수'가 있을 경우에도 유효하게 동작함.
// 다익스트라 알고리즘에 비해 속도가 느림.
// Queue에 동시에 같은 노드가 여러개 들어갈 수 있음. (불필요 연산이 생길 수 있다)
    // 이건 내가 구현한 것과 동일?!!!!!
// 내가 벨만 포드다!



public class Leet_1514_BellmanFord {
    public static void main(String[] args) {
        int n = 500;
        int[][] edges = {
                {193, 229},
                {133, 212},
                {224, 465}
        };

        double[] succProb = {
                0.91,
                0.78,
                0.64
        };

        int start = 4;
        int end = 364;

        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 각 노드 별 {다른 노드, 다른 노드와의 거리}
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0; i< edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            graph.computeIfAbsent(node1, adjacent -> new ArrayList<>()).add(new int[] {node2, i});
            graph.computeIfAbsent(node2, adjacent -> new ArrayList<>()).add(new int[] {node1, i});
        }

        // start로부터 다른 노드까지의 최단거리 기록
        double[] startTo = new double[n];
        startTo[start] = 1D;

        // 정점(cur)에 대해 연결된 모든 간선(curToNodeProbIdx)에 대해서 relax(가중치 갱신)이 된 경우 연결된 정점(node)을 queue에 넣음
        // queue에 넣는 순서는 우선순위가 따로 없음.
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] nodeWithProbIdx : graph.getOrDefault(cur, Collections.emptyList())) {
                int node = nodeWithProbIdx[0];
                int curToNodeProbIdx = nodeWithProbIdx[1];

                if (startTo[node] < startTo[cur] * succProb[curToNodeProbIdx]) {
                    startTo[node] = startTo[cur] * succProb[curToNodeProbIdx];
                    q.offer(node);
                }
            }
        }

        return startTo[end];
    }
}
