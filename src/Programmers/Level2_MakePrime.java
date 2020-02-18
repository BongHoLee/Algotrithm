package Programmers;

public class Level2_MakePrime {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        answer = combination(nums, 0, 0, 0);

        return answer;
    }

    public static int combination(int[] nums, int lastCount, int lastIdx, int sum) {
        if (lastCount == 3) {
            if (isPrime(sum))
                return 1;
            else
                return 0;
        } else {
            int count = 0;
            for (int i=lastIdx; i<nums.length; i++) {
                count += combination(nums, lastCount+1, i+1, sum + nums[i]);
            }

            return count;
        }

    }

    public static boolean isPrime(int checkNum) {

        if (checkNum % 2 == 0)
            return false;

        for (int i=3; i*i<=checkNum; i+=2) {
            if (checkNum % i == 0) {
                return false;
            }
        }


        return true;

    }
}
