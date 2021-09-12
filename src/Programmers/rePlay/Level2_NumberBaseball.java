package Programmers.rePlay;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> allCandi = allCandidates();
        for (int[] target : baseball) {
            for (int i=0; i<allCandi.size(); i++) {
                if (!isCandidate(allCandi.get(i), target[0], target[1], target[2])) {
                    allCandi.remove(i);
                    i--;
                }
            }
        }

        System.out.println(allCandi);

        return allCandi.size();
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

        List<String> contentList = new ArrayList<>();
        List<String> targetList = new ArrayList<>();

        for (int i=0; i<3; i++) {
            contentList.add(Integer.toString(content%10));
            targetList.add(Integer.toString(target%10));

            content /= 10;
            target /= 10;
        }

        for (int i=0; i<3; i++) {
            if (contentList.get(i).equals(targetList.get(i))) strike--;
            else if (targetList.contains(contentList.get(i))) ball--;
        }

        return strike == 0 && ball == 0;

    }
}
