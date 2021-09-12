package Programmers.level2;

public class Level2_MatrixMult {
    public static void main(String[] args) {
        int[][] arr1 = {
                {2,3,2},
                {4,2,4},
                {3,1,4}
        };

        int[][] arr2 = {
                {5,4,3},
                {2,4,1},
                {3,1,1}
        };

        int[][] result = solution(arr1, arr2);

        for (int[] x : result) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i=0; i<arr1.length; i++) {

            for (int j=0; j<arr2[0].length; j++) {

                int sum = 0;

                for (int x=0; x<arr2.length; x++) {
                    sum += arr1[i][x] * arr2[x][j];
                }

                answer[i][j] = sum;

            }
        }

        return answer;
    }
}
