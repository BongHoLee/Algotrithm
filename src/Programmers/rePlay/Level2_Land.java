package Programmers.rePlay;

import java.util.Arrays;

public class Level2_Land {
    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 10, 7, 8},
                {4, 3, 2, 1}
        };

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];


        int result = landing(land, dp, 0, -1);
        for (int row[] : dp) {
            System.out.println(Arrays.toString(row));
        }
        return  result;

    }

    static int landing(int[][] land, int[][] dp, int curRow, int cannotLandingPoint) {
        if (curRow == land.length) {
            return 0;
        } else {
            int[] curLand = land[curRow];
            int max = 0;

            for (int i=0; i<curLand.length; i++) {
                int curPoint = curLand[i];
                if (i == cannotLandingPoint) continue;
                if (dp[curRow][i] == 0)
                    dp[curRow][i] = curPoint + landing(land, dp, curRow + 1, i);

                max = Math.max(max,dp[curRow][i]);

            }
            return max;
        }
    }
}
