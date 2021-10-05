package Programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/86971

// 그래프 문제인 듯??
// '트리' 라는 표현을 보니 순환그래프가 아닌 비순환 그래프로 파악하면 될 듯 함.

import java.util.*;

public class Weekly9 {

    public static void main(String[] args) {
        int n = 4;
        int[][] wires = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(solution(n, wires));
    }

    static int min = Integer.MAX_VALUE;
    public static int solution(int n, int[][] wires) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n+1];

        for (int[] wire : wires) {
            if (!graph.containsKey(wire[0])) {
                graph.put(wire[0], new ArrayList<>());
            }

            if (!graph.containsKey(wire[1])) {
                graph.put(wire[1], new ArrayList<>());
            }
            List<Integer> v0List = graph.get(wire[0]);
            List<Integer> v1List = graph.get(wire[1]);
            v0List.add(wire[1]);
            v1List.add(wire[0]);
        }

        int searchedCount = search(wires[0][0], graph, visited, n);
        int divided = Math.abs(Math.abs(n-searchedCount) - searchedCount);
        return Math.min(min, divided);

    }

    private static int search(int curNode, Map<Integer, List<Integer>> graph, boolean[] visited,int n) {

        visited[curNode] = true;
        List<Integer> connected = graph.get(curNode);
        int count = 1;
        for (Integer eachNode : connected) {
            if (!visited[eachNode]) {
                int eachConnectedCount = search(eachNode, graph, visited, n);
                count += eachConnectedCount;
                int divided = Math.abs(Math.abs(n-eachConnectedCount) - eachConnectedCount);
                min = Math.min(min, divided);
            }
        }

        return count;
    }
}
