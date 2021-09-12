package Algorithm03;

import java.util.Arrays;

public class Nqueen {
    static int[] levelGrid = new int[9];
    static int size = 8;
    public static void main(String[] args) {
        queen(0);
        System.out.println(Arrays.toString(levelGrid));
    }

    static boolean queen(int x) {
        if(!check(x))
            return false;
        else if (x == size)
            return true;
        else {

            for (int i = 1; i <= size; i++) {
                levelGrid[x+1] = i;
                if (queen(x+1))
                    return true;
            }
            return false;
        }
    }

    static boolean check(int x) {
        for(int i=1; i<x; i++) {
            if(levelGrid[i] == levelGrid[x])
                return false;
            else if (x-i == Math.abs(levelGrid[x] - levelGrid[i]))
                return false;
        }
        return true;
    }


}
