package kakaobank;

import java.util.*;

// 이진 탐색 트리로 푸는 문제가 아닐까..
public class P4 {
    public static void main(String[] args) {
        //int[] prices = {5, 3, 7, 9, 5, 2, 4, 9, 10, 6};
        //int[] prices = {12, 1, 2, 3, 0, 11, 4};
        //int[] prices =  {4, 11, 0, 3, 2, 1, 12};
        int[] prices = {5, 4, 3, 2, 1, 2, 3, 4, 5};

        int[] revers = new int[prices.length];


        solution(prices);
    }

    static void solution(int[] prices) {
        Map<Integer, Integer> st = new TreeMap<>();

        int[] countLeftGreater = new int[prices.length];

        int totalCount = 0;
        for (int i=prices.length-1; i>=0; i--) {
            totalCount ++;
            st.putIfAbsent(prices[i], 0);
            st.put(prices[i], st.get(prices[i]) + 1);

            int it = 0;

            for (Integer integer : st.keySet()) {
                int count = st.get(integer);
                if (prices[i] < integer) {
                    break;
                }

                it += count;
            }

            countLeftGreater[i] = Math.abs(it - totalCount);

        }

        for (int i=0; i<countLeftGreater.length; i++) {
            System.out.print(countLeftGreater[i] + ", ");
        }

    }
}
