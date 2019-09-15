package Programmers;

import java.util.Arrays;

public class LevelTest3 {
    public static void main(String[] args) {
        int[] arr = {5, 8, 2, 1, 6, 4};

        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] arr) {
        int[] answer = {};

        if(arr.length > 1) {
            answer = new int[arr.length-1];
            int minIdx = 0;

            for(int i=1; i<arr.length; i++) {
                if(arr[i] < arr[minIdx])
                    minIdx = i;
            }

            for(int i=0, j=0; i<arr.length; i++, j++) {
                if (i == minIdx) {
                    j -= 1;
                    continue;
                } else {
                    answer[j] = arr[i];
                }

            }

        } else {
            answer = new int[]{-1};
        }

        return answer;


    }

}
