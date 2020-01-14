package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Level2_TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 1;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int curNum = numbers[0];

        answer = search(numbers, curNum, target, 1, numbers.length-1)
                + search(numbers, -curNum, target, 1, numbers.length-1);

        return answer;
    }

    public static int search(int[] numbers, int curNum, int target, int pos, int end) {
        if (pos > end) {
            if (curNum == target)
                return 1;
            else
                return 0;
        } else {

            return search(numbers, curNum + numbers[pos], target, pos+1, end)
                    + search(numbers, curNum - numbers[pos], target, pos+1, end);
        }
    }
}
