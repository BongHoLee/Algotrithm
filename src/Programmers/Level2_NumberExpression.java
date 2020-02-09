package Programmers;

public class Level2_NumberExpression {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 0;

        for (int i=1; i<=n; i++) {
            answer += searchToequal(i, n, 0);
        }

        return answer;
    }

    public static int searchToequal(int start, int end, int sum) {
        if (sum >= end)
            return (sum == end) ? 1 : 0;
        else
            return searchToequal(start + 1, end, sum + start);
    }
}
