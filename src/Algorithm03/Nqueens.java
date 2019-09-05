package Algorithm03;


/*
* N-Queens Problem
*  1. no match equally row
*  2. no match equally col
*  3. no match equally diagonal
*
* */

import java.util.Arrays;

public class Nqueens {
    static int N = 8;
    static int[] cols = new int[N+1];
    public static boolean queens(int level) {
        // not match condition (row || col || diagonal)
        if(!promise(level))
            return false;
        else if (level == N)            //validate promise ->
            return true;
        else {
            // visit child recursivley
            for(int i=1; i<=N; i++) {
                cols[level+1] = i;
                if(queens(level+1))
                    return true;
            }
            return false;
        }
    }

    public static boolean promise(int level){
        for(int i=1; i<level; i++) {
            if(cols[i] == cols[level]) {
                return false;
            } else if (level-i == Math.abs(cols[level]-cols[i]))
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(queens(0));
        System.out.println(Arrays.toString(cols));


    }


}
