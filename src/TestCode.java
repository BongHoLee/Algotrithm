import java.util.*;

public class TestCode {
    public static void main(String[] args) {

        System.out.println(solution(11, 14, 2));
    }
    static int solution(int A, int B, int K) {
        if (A == B) {
            return (A%K == 0) ? 1 : 0;
        }

        if (K > B) {
            return 0;
        }



        int start = (A%K == 0) ? A :  A + ((K - (A%K)));
        int count = 1 + (B-start)/K;

        return count;
    }



}


