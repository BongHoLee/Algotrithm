package Programmers.highscore_kit;


public class Capet_level2_OLD {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = yellow + brown;

        for (int i=1; i*i <= yellow; i++) {
            if (yellow % i == 0) {
                int yellowX = i;
                int yellowY = yellow/yellowX;

                if ((yellowX + 2) * (yellowY + 2) == total) {
                    answer[0] = Math.max(yellowX+2, yellowY+2);
                    answer[1] = Math.min(yellowX+2, yellowY+2);
                    break;
                }
            }
        }


        return answer;
    }
}
