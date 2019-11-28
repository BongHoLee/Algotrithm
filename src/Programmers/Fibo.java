package Programmers;

public class Fibo {
    // 0, 1, 1, 2, 3, 5, 8, 13
    public static void main(String[] args) {
        System.out.println(fibo(7));
    }

    public static int fibo(int n) {
        if (n <= 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }
}
