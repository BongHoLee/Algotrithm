package leetcode.easy.graph.leet_997;

import java.util.ArrayList;
import java.util.List;

public class Leet_997 {
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {
                {1, 2}
        };

        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return n;
        }

        int[] trustCount = new int[n+1];
        int result = -1;

        for (int[] each : trust) {
            trustCount[each[1]] ++;
            trustCount[each[0]] --;
        }


        for (int i=1; i< trustCount.length; i++) {
            if (trustCount[i] == n-1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
