package Programmers.level2;

import java.util.Arrays;

// 재귀를 이용함
// 재귀 이용시 최소한의 숙지

public class Level2_ColoringBook {
    public static void main(String[] args) {
        /*
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

         */

        int[][] picture = {
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
                {0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0},
                {0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0},
                {0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0},
                {0,0,1,1,1,1,1,2,2,1,1,1,1,1,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
        };

        int m = picture.length;
        int n = picture[m-1].length;
        int[] answer = solution(m, n, picture);

       System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int m, int n , int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean visit[][] = new boolean[m][n];

        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                int target = picture[x][y];
                if(!visit[x][y] && target != 0) {
                    numberOfArea += 1;
                    int tmpCount = visitingColoringBook(target, x, y, visit, picture);
                    if (tmpCount > maxSizeOfOneArea) {
                        maxSizeOfOneArea = tmpCount;
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;

    }

    // 방문한 곳의
    public static int visitingColoringBook(int target, int x, int y, boolean[][] visit, int[][] picture) {

        //범위에서 벗어난 곳이라면
        if (x >= picture.length || x < 0 || y < 0 || y >= picture[x].length)
            return 0;

        //이미 방문한 곳이라면 return count
        if (visit[x][y])
            return 0;
        else {
            if(picture[x][y] == target) {
                visit[x][y] = true;
                return 1 + visitingColoringBook(target, x-1, y, visit, picture)
                         + visitingColoringBook(target, x+1, y, visit, picture)
                         + visitingColoringBook(target, x, y-1, visit, picture)
                         + visitingColoringBook(target, x, y+1, visit, picture);
            } else {
                return 0;
            }
        }

    }
}
