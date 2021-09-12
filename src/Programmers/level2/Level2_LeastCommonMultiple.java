package Programmers.level2;

import java.util.Arrays;

public class Level2_LeastCommonMultiple {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(solution(arr));
    }

    public static int solution (int[] arr) {
        Arrays.sort(arr);
        int answer = 0;
        int max = arr[arr.length - 1];
        int mul = 1;

        boolean flag = false;
        while (!flag) {
            answer = max * mul;
            for (int i=0; i<arr.length-1; i++) {
                if (answer % arr[i] == 0)
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            mul += 1;
        }

        return answer;
    }
}
