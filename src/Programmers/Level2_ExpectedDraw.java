package Programmers;

public class Level2_ExpectedDraw {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        return recurToMatch(a, b);
    }

    public static int recurToMatch(int a, int b) {
        if (a == b) {
            return 0;
        } else {
            return 1 + recurToMatch(getNextValue(a), getNextValue(b));
        }
    }

    public static boolean isMatched(int a, int b) {
        if ((a <= b &&  b - a == 0) || (b <= a && a - b == 0))
            return true;
        else
            return false;
    }

    public static int getNextValue(int value) {
        if (value%2 == 0)
            return value/2;
        else
            return value/2 + 1;
    }




}
