package Programmers.level2;

public class Level2_Land {
    public static void main(String[] args) {
        int[][] land = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int [land.length+1][land[0].length+1];


        for (int i=0; i<4; i++) {
            int tmp = land[0][i] + landing(land, 1, i, dp);
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    public static int landing(int[][] land, int i, int lastj, int[][] dp) {
        if (i == land.length) {
            dp[i-1][lastj] = land[i-1][lastj];
            return 0;
        }
        else {
            int max = 0;
            for (int curj=0; curj<4; curj++) {
                if (curj == lastj)
                    continue;

                int tmp = 0;
                if (dp[i][curj] != 0)
                    tmp = dp[i][curj];
                else
                    tmp = land[i][curj] + landing(land, i+1, curj, dp);

                max = Math.max(max, tmp);
            }
            dp[i-1][lastj] = max + land[i-1][lastj];
            return max;
        }

    }
}
