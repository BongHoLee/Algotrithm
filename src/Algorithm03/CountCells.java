package Algorithm03;

public class CountCells {
    static int[][] grid =
            {
                    {1, 0, 0, 0, 0, 0, 0, 1},
                    {0, 1, 1, 0, 0, 1, 0, 0},
                    {1, 1, 0, 0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0, 1, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 1},
                    {0, 1, 1, 0, 0, 1, 1, 1}
            };
    static int N = 8;
    static int imagePixel = 1;
    static int backgroundPixel = 0;
    static int total = 0;

    public static void main(String[] args) {
        print();
        System.out.println();
        countCell(1, 5);
        print();
        System.out.println(total);

    }

    static void print() {
        for(int i=0; i<grid.length; i++) {
            for(int y=0; y<grid[i].length; y++) {
                System.out.print(grid[i][y] + " ");
            }
            System.out.println();
        }
    }

    //좌, 우, 대칭
    public static boolean countCell(int x, int y) {
        if(x > N-1 || y > N-1 || x < 0 || y < 0) {
            return false;
        } else if (grid[x][y] == imagePixel) {
            grid[x][y] = backgroundPixel;
            total++;
            if(countCell(x+1, y)
                    || countCell(x-1, y) || countCell(x, y+1)
                    || countCell(x, y-1)  || countCell(x+1, y+1)
                    || countCell(x-1, y-1 ) || countCell(x+1, y-1)
                    || countCell(x-1, y+1) ) {
                System.out.println("its true");
                return false;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
