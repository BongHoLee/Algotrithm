package Algorithm03;

// N * N 그리드 존재
// 출구는 N-1, N-1

// 총 4개의 state
// Pathway(아직 방문하지 않은 곳, 길)              // 0
// path (방문 했음, 길)                         // 1
// blocked(방문 했고 더이상 출구가 없는 곳)         // 2
// wall (막혀있음)                             // 3


// 미로찾기는 Recursion이 가장 간단.

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

    static int pathWay = 0;
    static int path = 1;
    static int blocked = 2;
    static int wall = 3;

    public static void main(String[] args) {

    }

    // visit시 출구 찾기 성공시 true, 막혔을시(길이 없거나 벽) false
    public static boolean findPath(int x, int y) {

        // 1.
        return false;
    }
}
