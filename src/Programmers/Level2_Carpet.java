package Programmers;

import java.util.Arrays;

public class Level2_Carpet {
    public static void main(String[] args) {
        int brown = 8;
        int red = 1;
        System.out.println(Arrays.toString(solution(brown, red)));
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int totalSum = brown + red;
        int redGaro = 1;
        int redSero = 1;

        for (int i=1; i<red; i++) {
            if ((redGaro+2) * (redSero+2) == totalSum)
                break;
            else {
                if (red%(red-i) == 0) {
                    redGaro = red - i;
                    redSero = red/redGaro;
                }
            }
        }

        if (redGaro >= redSero) {
            answer[0] = redGaro + 2;
            answer[1] = redSero + 2;
        } else {
            answer[0]  = redSero + 2;
            answer[1] = redGaro + 2;
        }

        return answer;
    }

}
