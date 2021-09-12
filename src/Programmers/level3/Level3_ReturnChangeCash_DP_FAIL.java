package Programmers.level3;

import java.util.Arrays;

public class Level3_ReturnChangeCash_DP_FAIL {
    public static void main(String[] args) {
        int n = 10;
        int[] money = {1, 2, 5};
        System.out.println(solution(n, money));
    }

    public static int solution(int n, int[] money) {
        int[] returnCash = new int[n+1];
        Arrays.sort(money);

        for (int i=1; i<returnCash.length; i++) {

            for (int eachMoneyIdx=0; eachMoneyIdx<money.length; eachMoneyIdx++) {
                if (money[eachMoneyIdx] == i)
                    returnCash[i] = returnCash[i] + 1;
                else if (money[eachMoneyIdx] < i)
                    returnCash[i] = returnCash[i] + returnCash[i - money[eachMoneyIdx]];
            }
        }

        System.out.println(Arrays.toString(returnCash));

        return 0;


    }
}
