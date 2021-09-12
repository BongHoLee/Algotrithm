package Programmers.rePlay;

import java.util.*;


public class Level2_RamenFactory2 {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        return sol1(stock, dates, supplies, k);
    }

    static int sol1(int stock, int[] dates, int[] supplies, int k) {
        int sol1 = 0;

        while (stock < k) {
            int maxDatesIdx = 0;

            for (int i=0; i<dates.length; i++) {
                if (dates[i] > stock)
                    break;
                else
                    maxDatesIdx = supplies[maxDatesIdx] < supplies[i] ? i : maxDatesIdx;
            }

            stock += supplies[maxDatesIdx];
            supplies[maxDatesIdx] = -1;
            sol1 += 1;
        }

        return sol1;
    }

    static int sol2(int stock, int[] dates, int[] supplies, int k) {
        int sol2 = 0;
        PriorityQueue<Integer> prQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i=0; i<dates.length; i++) {
            stock -= dates[i];


        }


        return sol2;
    }
}
