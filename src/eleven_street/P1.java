package eleven_street;

/**
 * 정수 N이 주어졌을 때 N보다 크면서 각 자리수의 합이 N과 일치하는 최솟값 구하기
 */
public class P1 {

    public static void main(String[] args) {
        int N = 1000;
        P1 p1 = new P1();

        System.out.println(p1.solution(N));

    }

    private static final int MAX = 50000;

    public int solution(int N) {
        int result = 0;
        int compare = digitSumOf(N);

        for (int i = N+1; i <= MAX; i++) {
            if (digitSumOf(i) == compare) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int digitSumOf(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }
}
