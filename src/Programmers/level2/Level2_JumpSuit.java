package Programmers.level2;

public class Level2_JumpSuit {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }

    public static int solution(int n) {
        int count = 1;

        while (n>1) {
            if ( n%2 == 1) {
                count += 1;
                n = n-1;
            }
            n = n / 2;
        }

        return count;
    }
}
