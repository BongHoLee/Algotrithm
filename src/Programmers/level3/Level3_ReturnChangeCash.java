package Programmers.level3;

public class Level3_ReturnChangeCash {
    public static void main(String[] args) {
        int n = 10;
        int[] money = {1, 2, 3, 4, 5};
        System.out.println(solution(n, money));
    }

    public static int solution(int n, int[] money) {
        int answer = 0;

        answer = calcChange(n, 0, 0, money);

        return answer % 1000000007;
    }

    static int calcChange(int goalAmount, int curAmount, int startIdx, int[] money) {
        if (curAmount == goalAmount)
            return 1;
        else if (curAmount > goalAmount)
            return 0;
        else {
            int changeMethods = 0;
            for (int i=startIdx; i<money.length; i++) {
                changeMethods += calcChange(goalAmount, curAmount + money[i], i, money);
            }

            return changeMethods;
        }

    }

}
