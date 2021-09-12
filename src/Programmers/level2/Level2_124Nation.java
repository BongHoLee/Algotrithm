package Programmers.level2;

public class Level2_124Nation {
    public static void main(String[] args) {

        System.out.println(solution(13));
    }

    public static String solution(int n) {
        StringBuilder sb = calc(n, new StringBuilder());
        return sb.toString();
    }

    // Recursion을 이용한 풀이.
    public static StringBuilder calc(int n, StringBuilder answer) {
        if (n > 0) {
            if(n%3 == 1)
                return calc(n/3, answer).append("1");
            else if (n%3 == 2)
                return calc(n/3, answer).append("2");
            else if (n%3 == 0)
                return calc((n/3)-1, answer).append("4");
        }

        return answer;

    }



}
