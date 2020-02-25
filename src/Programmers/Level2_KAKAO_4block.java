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
        int changed = 1;
        char[][] charBoard = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }


        while (changed > 0) {
            changed = 0;
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (charBoard[i][j] != 'x') {
                        changed += findBlock(i, j, charBoard, charBoard[i][j], check);
                    }
                }
            }

            if (changed > 0) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (check[j][i]) {
                            charBoard[j][i] = 'x';
                            for (int x = j; x > 0; x--) {
                                char tmp = charBoard[x][i];
                                charBoard[x][i] = charBoard[x - 1][i];
                                charBoard[x - 1][i] = tmp;
                            }
                        }
                    }
                }
            }
        }

        for (char[] a : charBoard) {
            for (char b : a) {
                //System.out.print(b + " ");
                if (b == 'x') answer += 1;
            }
            //System.out.println();
        }


        return answer;
    }

    static int findBlock(int m, int n, char[][] charBoard, char target, boolean[][] check) {
        if (charBoard[m][n] == 'x' || charBoard[m][n] != target || m >= charBoard.length || n >= charBoard[m].length)
            return 0;
        else {
            if (checkTarget(m + 1, n, charBoard, target) && checkTarget(m, n + 1, charBoard, target) && checkTarget(m + 1, n + 1, charBoard, target)) {
                check[m][n] = true;
                check[m + 1][n] = true;
                check[m][n + 1] = true;
                check[m + 1][n + 1] = true;
                return 1;
            }

        }
        return 0;
    }

    static boolean checkTarget(int m, int n, char[][] charBoard, char target) {
        if (m >= charBoard.length || n >= charBoard[m].length)
            return false;
        else {
            if (charBoard[m][n] == target)
                return true;
            else
                return false;
        }
    }

}
