package kakaobank;

import java.util.*;

public class P3 {
    public static void main(String[] args) {
        int[] T = {5,8,3,7,10,5,4};
        int[][] R = {{1, 2}, {2, 4}, {1, 4}, {6, 5}, {3, 5}, {4, 6}};
        int K = 5;

        System.out.println(solution(T, R, K));

    }

    static int solution(int[] T, int[][] R, int K) {
        Map<Integer, Queue<Integer>> calcMap = new HashMap<>();
        int[][] mem = new int[T.length+1][T.length+1];

        for (int[] each: R) {
            Queue<Integer> calcQueue = calcMap.computeIfAbsent(each[1], k -> new LinkedList<>());
            calcQueue.add(each[0]);
        }

        int result = find(T, calcMap, mem, K);
        return result;
    }

    static int find(int[] T, Map<Integer, Queue<Integer>> calcMap, int[][] mem,  int K) {
        Queue<Integer> calcQueue = calcMap.get(K);
        int sum = T[K-1];

        if (calcQueue != null && !calcQueue.isEmpty()) {
            int max = 0;
            while (!calcQueue.isEmpty()) {
                Integer next = calcQueue.poll();

                if (mem[K][next] == 0) {
                    mem[K][next] = find(T, calcMap, mem, next);
                }

                max = Math.max(max, mem[K][next]);
            }

            return sum + max;
        } else {
            return sum;
        }
    }


}
