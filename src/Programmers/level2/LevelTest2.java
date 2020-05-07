package Programmers.level2;

public class LevelTest2 {

    public static void main(String[] args) {
        System.out.println(solution(123));
    }

    public static int solution(int n) {
        int answer = 0;

        while(n > 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

}
