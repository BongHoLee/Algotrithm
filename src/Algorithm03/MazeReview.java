package Algorithm03;

// N * N 그리드 존재
// 출구는 N-1, N-1

// 총 4개의 state
// Pathway(아직 방문하지 않은 곳, 길)              // 0
// path (방문 했음, 길)                         // 3
// blocked(방문 했고 더이상 출구가 없는 곳)         // 2
// wall (막혀있음)                             // 1


// 미로찾기는 Recursion이 가장 간단.

import java.util.Arrays;

public class MazeReview {
    private static int[][] maze = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,0,1,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,0,0},
            {0,1,1,1,0,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,1,1,0,1,0,0}
    };

    private static int N = 8;

    static int pathWay = 0;
    static int path = 3;
    static int blocked = 2;
    static int wall = 1;

    public static void main(String[] args) {
        findPath(0, 0);

    }

    // visit시 출구 찾기 성공시 true, 막혔을시(길이 없거나 벽) false
    public static boolean findPath(int x, int y) {

        // 1. 미로 경로를 넘어가면 false
        if (x > N-1 || y > N-1 || x < 0 || y < 0) {
            return false;
        }
        // 2. 현재 열린 길이 아니면 갈 필요가 없으므로 false.
        else if (maze[x][y] != pathWay) {
            return false;
        }
        // 3. 최종 목적지에 다달으면 비로소 true
        else if (x == N-1 && y == N-1) {
            print();
            return true;
        } else {

            // 현재 최종 목적지도 아니고 경로 이탈도 아니며 열린 위치 이므로 일단 방문 표시 (path)
            maze[x][y] = path;

            // 상하좌우 탐색.
            if (findPath(x-1, y)) return true;
            if (findPath(x, y-1)) return true;
            if (findPath(x, y+1)) return true;
            if (findPath(x+1, y)) return true;

            // 더이상 길이 없다면 blocked 표시 후 false
            maze[x][y] = blocked;
            return false;
        }

    }

    public static void print() {
        for(int[] x : maze) {
            for(int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();

        }
    }
}
