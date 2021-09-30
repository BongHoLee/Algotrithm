package leetcode.leet_1971_graph;

import java.util.*;

public class Leet_1971_faster {
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
        boolean[] visited = new boolean[n];
        boolean found = true;
        visited[start] = true;

        while(!visited[end] && found){
            found = false;

            for(int[] edge : edges){
                if(visited[edge[0]]){
                    if(!visited[edge[1]]){
                        visited[edge[1]] = found = true;
                    }
                }
                else if(visited[edge[1]]){
                    visited[edge[0]] = found = true;
                }
            }
        }
        return visited[end];
    }

}
