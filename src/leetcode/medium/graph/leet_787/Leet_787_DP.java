package leetcode.medium.graph.leet_787;

import java.util.Arrays;

// dp를 사용하는데 인덱스가 k를 표현하는 점이 좀 참신했음.


public class Leet_787_DP {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 2;
        int k = 0;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k+2][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        // dp[i][j] = Distance to reach 'j' using at most 'i' edges from src

        for(int i=0; i<=k+1; i++) {
            dp[i][src] = 0; // Dist to reach src always zero
        }

        for (int i=1; i<=k+1; i++) {

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if (dp[i-1][u] != Integer.MAX_VALUE) {
                    dp[i][v] = Math.min(dp[i][v], dp[i-1][u] + w);
                }
            }
        }

        return dp[k+1][dst] == Integer.MAX_VALUE ? -1 : dp[k+1][dst];
    }

}
