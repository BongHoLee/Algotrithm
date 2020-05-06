package Programmers.rePlay;

import java.util.ArrayList;
import java.util.List;

public class Level2_NumberBaseball {
    public static void main(String[] args) {
        int[][] baseball = {
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}
        };


        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        List<Integer> allCandi = allCandidates();

        for (int[] each : baseball) {

        }

        return answer;
    }

    static List<Integer> allCandidates() {
        List<Integer> allCandi = new ArrayList<>();
        for (int x=1; x<10; x++) {
            int first = x * 100;

            for (int y=1; y<10; y++) {
                if (y == x) continue;
                int second = y*10;

                for (int z=1; z<10; z++) {
                    if (z == y || z == x) continue;
                    int third = z;
                    allCandi.add(first + second + third);
                }
            }

        }

        return allCandi;
    }

    static boolean isCandidate(int content, int target, int strike, int ball) {
        boolean candidate = false;

        for (int i=100; i>1; i/=10) {

        }

        return candidate;

    }
}
