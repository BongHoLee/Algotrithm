package Programmers.highscore_kit;

public class Capet_level2 {
    public static void main(String[] args) {
        Capet_level2 capet_level2 = new Capet_level2();
        int brown = 24;
        int yellow = 24;

        int[] solution = capet_level2.solution(brown, yellow);
        System.out.println("[" + solution[0] + ", " + solution[1] + "]");

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yellowMaxHeight = getMaxHeight(yellow);
        for (int yellowHeight=1; yellowHeight<=yellowMaxHeight; yellowHeight++) {
            if (canRectangleWith(yellow, yellowHeight)) {
                int yellowWidth = yellow / yellowHeight;
                int totalRectangleBlockCount = (yellowWidth + 2) * (yellowHeight + 2);
                int yellowRectangleBlockCount = yellowWidth * yellowHeight;
                int brownRectangleBlockCount = (totalRectangleBlockCount - yellowRectangleBlockCount);

                if (brownRectangleBlockCount == brown) {
                    answer[0] = yellowWidth + 2;
                    answer[1] = yellowHeight + 2;
                    break;
                }
            }
        }

        return answer;
    }

    private int getMaxHeight(int blockNumbers) {
        return (int) Math.sqrt(blockNumbers);
    }

    private boolean canRectangleWith(int blockNumbers, int height) {
        return blockNumbers % height == 0;
    }

}
