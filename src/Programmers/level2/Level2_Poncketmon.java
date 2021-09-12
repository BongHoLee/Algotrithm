package Programmers.level2;

import java.util.*;

public class Level2_Poncketmon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> poncketmons = new HashSet<>();

        for (int i : nums)
            poncketmons.add(i);

        answer = (nums.length/2) <= poncketmons.size() ? (nums.length/2) : poncketmons.size();


        return answer;
    }

}
