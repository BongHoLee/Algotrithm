package Programmers;

import java.util.Arrays;

public class Level2_BiggestSqure_Solution {
    public static void main(String[] args) {

        int[][] board ={
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        } ;

        System.out.println(solution(board));

    }

    public static int solution(int[][] board) {
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        int max = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 1) {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j]) + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }

        return max * max;
    }
}
