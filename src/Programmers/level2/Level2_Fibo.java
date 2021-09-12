package Programmers.level2;

public class Level2_Fibo {
    public static void main(String[] args) {
        System.out.println(solution( 20));
    }

    public static int solution(int n) {
        int answer = 0;
        long[] dp = new long[10000001];

        answer = (int)(fiboDp(n, dp));


        return answer;
    }

    public static long fiboDp(int n, long[] dp) {
        if (n <= 0)
            return 0;
        else if (n == 1) {
            return 1;
        }
        else {
            if (dp[n] == 0) {
                dp[n] = (fiboDp(n - 1, dp) + fiboDp(n - 2, dp)) % 1234567;
                return dp[n];
            }
            else {
                return dp[n];
            }
        }
    }

}
