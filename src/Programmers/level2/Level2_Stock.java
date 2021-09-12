package Programmers.level2;

import java.util.Arrays;

/*
*  딱히 어려운 문제가 아니었지만 이상하게 문제를 이해하는데 오래걸림
*
* */

public class Level2_Stock {
    public static void main(String[] args) {

        int[] prices = {1,2,3,2,3};
        int[] answer = solution(prices);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            int price = prices[i];
            int sc = 0;

            for(int j=i+1; j<prices.length; j++) {
                sc += 1;
                int changedPrice = prices[j];
                if(changedPrice < price)
                    break;
            }

            answer[i] = sc;

        }


        return answer;
    }
}
