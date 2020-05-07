package Programmers.level2;

public class Level2_FineSquare_solution {
    public static void main(String[] args) {
        System.out.println(solution(4,5));
    }

    public static long solution(long w, long h) {
        long gcd = calcGcd(Math.max(w, h), Math.min(w, h));
        long totalSquare = w * h;
        w = w/gcd;
        h = h/gcd;

        return totalSquare - (gcd * (w + h - 1));
    }

    private static long calcGcd(long large, long small) {
        if (small == 0)
            return large;
        else
            return calcGcd(small, large%small);
    }
}
