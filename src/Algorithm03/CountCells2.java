package Algorithm03;

/*
* 현재 이 픽셀이 속한 Blob의 크기를 카운트 하려면
* 1. 현재 픽셀이 image Pixel이 아니라면 0을 반환
*
* */
public class CountCells2 {
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
    static int alreadyCounted = 2;
    static int backgroundPixel = 0;

    public static void main(String[] args) {
        print();
        System.out.println();
        System.out.println(countCells(1, 5));
        System.out.println();
        print();

    }

    static int countCells(int x, int y) {
        int count = 0;

        if(x > N-1 || y > N-1 || x < 0 || y < 0)
            return count;

        else if (grid[x][y] == imagePixel) {

            // 현재 위치 visited 표시 및 count ++;
            count ++;
            grid[x][y] = alreadyCounted;

            // 수학적 귀납의 좋은 예. 인접 pixel의 blob 크기를 구하여 현재 크기에 더한다!!!
            return count +
                    countCells(x+1, y) + countCells(x-1, y) +
                    countCells(x, y+1) + countCells(x, y-1) +
                    countCells(x+1, y+1) + countCells(x+1, y-1) +
                    countCells(x-1, y+1) + countCells(x-1, y-1);
        } else {
            return 0;
        }
    }

    static void print() {
        for(int x=0; x<grid.length; x++) {
            for(int y=0; y<grid[x].length; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }


}
