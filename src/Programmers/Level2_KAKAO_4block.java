package Programmers;

public class Level2_KAKAO_4block {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;

        String[] board = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        };



    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        boolean[][] check = new boolean[m][n];
        boolean flag = false;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[m].charAt(n) != 'X') {
                    flag = findBlock(m, n, board, board[m].charAt(n), check);
                }
            }
        }

        if (flag) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (check[j][i]) {
                        board[j]
                        for (int x = 0; x<=j; x++) {
                            char tmp = board[j].charAt(x);

                        }
                    }
                }
            }
        }


        return answer;
    }

    static boolean findBlock(int m, int n, String[] board, char target, boolean[][] check) {
        if (board[m].charAt(n) == 'X' || board[m].charAt(n) != target || m >= board.length || n >= board[m].length())
            return false;
        else {
            if (checkTarget(m+1, n, board, target) && checkTarget(m, n+1, board, target) && checkTarget(m+1, n+1, board, target)) {
                check[m][n] = true;
                check[m+1][n] = true;
                check[m][n+1] = true;
                check[m+1][n+1] = true;
                return true;
            }

        }
        return false;
    }

    static boolean checkTarget(int m, int n, String[] board, char target) {
        if (m >= board.length || n >= board[m].length())
            return false;
        else {
            if (board[m].charAt(n) == target)
                return true;
            else
                return false;
        }
    }

}
