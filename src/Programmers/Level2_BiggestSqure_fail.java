package Programmers;

public class Level2_BiggestSqure_fail {
    public static void main(String[] args) {
        int[][] board = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}

        };

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int biggestSize = 0;

        int maxTo = 0;
        boolean flag = false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 1) {
                    flag = true;
                    int to = calcTo(board[i], j);
                    int tmpTo = calcMaxTo(board, i, j, maxTo, to);
                    if (maxTo < tmpTo) {
                        j = j + to + 1;
                        maxTo = tmpTo;
                    }


                }
            }
        }

        if (flag)
            biggestSize = (maxTo+1) * (maxTo+1);
        else
            biggestSize = 0;
        return biggestSize;
    }

    public static int calcMaxTo(int[][] board, int i, int j, int maxTo, int to) {
        int xMax = -1;
        int yMax = -1;
        if (maxTo >= to)
            return maxTo;
        else {
            boolean checkFlag = true;
            for (int x=i; x<=i+to && x<board.length; x++) {
                yMax = -1;
                for (int y=j; y<=j+to && y<board[i].length;  y++) {
                    if (board[x][y] == 0) {
                        checkFlag = false;
                        break;
                    }
                    yMax += 1;
                }

                xMax += 1;
                if (!checkFlag)
                    break;


            }

            return xMax < yMax ? xMax : yMax;
        }
    }

    private static int calcTo(int[] board, int iStart) {
        int to = 0;
        for (int i=iStart+1; i<board.length; i++) {
            if (board[i] == 1)
                to += 1;
            else
                break;
        }

        return to;
    }
}
