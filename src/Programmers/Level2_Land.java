package Programmers;

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

        for (int i=0; i<4; i++) {
            int tmp = land[0][i] + landing(land, 1, i);
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    public static int landing(int[][] land, int i, int j) {
        if (i == land.length)
            return 0;
        else {
            int max = 0;
            for (int x=0; x<4; x++) {
                if (x == j)
                    continue;

                int tmp = landing(land, i+1, x);
                max = Math.max(max, tmp);
            }
            int sum = max + land[i][j];
            return sum;
        }

    }
}
