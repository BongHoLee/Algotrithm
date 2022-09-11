package eleven_street;

/**
 * 주어진 함수는 배열 A와 정수 K를 이용한다.
 * A에 1..K 까지의 정수가 존재 시 true,  아니면 false를 반환한다.
 * 두 줄을 고쳐서 함수를 오류 없이 만들어라.
 */
public class P2 {
    public static void main(String[] args) {
//        int[] A = {1, 2, 2, 3, 3};
//        int K = 3;

        int[] A = {1, 2, 3, 2, 3};
        int K = 3;

        P2 p2 = new P2();
        System.out.println(p2.solution(A, K));

    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }
}
