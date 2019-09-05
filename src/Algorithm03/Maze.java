package Algorithm03;

public class Maze {

    static int num = 0;
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
    private static final int PATHWAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    public static void main(String[] args) {
        printMaze();
        System.out.println();
        findMaze(0, 0);
        printMaze();

    }

    public static boolean findMaze(int x, int y) {
        num++;
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        else if (x == N-1 && y == N-1){
            // 탈출 포이이인트!! (base_case. 결국 여기로 수렴)
            System.out.println("findit!");
            return true;

        } else if(maze[x][y] == PATHWAY_COLOR) {
            maze[x][y] = PATH_COLOR;
            printMaze();
            System.out.println();
            if (findMaze(x - 1, y) || findMaze(x, y + 1) || findMaze(x + 1, y) || findMaze(x, y - 1)) {

                System.out.println(x + " " + y);
                return true;
            } else {
                maze[x][y] = BLOCKED_COLOR;
                return false;
            }
        } else {
            return false;
        }

    }


    public static void printMaze() {
        for(int x=0; x<maze.length; x++){
            for(int y=0; y<maze[x].length; y++){
                System.out.print(maze[x][y] + " ");
            }
            System.out.println();
        }

    }



}
