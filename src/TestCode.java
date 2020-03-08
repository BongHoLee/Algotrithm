import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        return combination(nums, 3, 0, 0, 0);
    }

    private static int combination(int[] nums, int toSumCount, int lastIdx, int curSumedCount, int sum) {
        if (toSumCount == curSumedCount) {
            if (isPrime(sum))
                return 1;
            else
                return 0;
        } else {
            int count = 0;
            for (int i=lastIdx; i<nums.length; i++) {
                count += combination(nums, toSumCount, i + 1, curSumedCount + 1, sum + nums[i]);
            }
            return count;
        }
    }

    private static boolean isPrime(int checkNum) {
        if (checkNum  % 2 == 0)
            return false;

        for (int i=2; i*i<=checkNum; i++) {
            if (checkNum % i == 0)
                return false;
        }

        return true;
    }

}
