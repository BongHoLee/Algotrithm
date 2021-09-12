package Programmers.rePlay;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Level2_Phonket {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(numsSet.size(), nums.length / 2);
    }
}
