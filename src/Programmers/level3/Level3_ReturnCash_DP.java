package Programmers.level3;

import java.util.Arrays;

public class Level3_ReturnCash_DP {
    public static void main(String[] args) {
        int n = 10;
        int[] money = {5, 1, 2};
        System.out.println(solution(n, money));

    }

    public static int solution(int n, int[] money) {
        int[] returnCash = new int[n + 1];
        //Arrays.sort(money);

        for (int i=1; i<returnCash.length; i++)
            returnCash[i] = i % money[0] == 0 ? 1 : 0;

        for (int eachMoneyIdx = 1; eachMoneyIdx < money.length; eachMoneyIdx++) {
            for (int i=money[eachMoneyIdx]; i<returnCash.length; i++) {
                if (i == money[eachMoneyIdx])
                    returnCash[i]  = (returnCash[i] + 1) % 1000000007;
                else if (money[eachMoneyIdx] < i)
                    returnCash[i] = (returnCash[i] + returnCash[i - money[eachMoneyIdx]]) % 1000000007;
            }
        }

        System.out.println(Arrays.toString(returnCash));
        return returnCash[returnCash.length-1];

    }


}
