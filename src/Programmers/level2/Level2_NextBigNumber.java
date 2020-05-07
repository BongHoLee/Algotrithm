package Programmers.level2;

public class Level2_NextBigNumber {
    public static void main(String[] args) {
        solution(78);
    }

    public static int solution(int n) {
        int check = calcBinary(n);

        int nextCheck = 0;
        while (nextCheck != check) {
            n += 1;
            nextCheck = calcBinary(n);

        }

        return n;

    }

    static int calcBinary(int n) {
        int check = 0;

        while (n > 0) {
            if (n%2 != 0)
                check +=1;
            n = n/2;

        }

        return check;
    }
}
