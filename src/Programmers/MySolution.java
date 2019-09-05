package Programmers;

import java.util.Arrays;

public class MySolution {

    static boolean[] DP = new boolean[51];
    static int[] array = {1, 1, 2, 3, 6, 7, 30};

    public static void main(String[] args) {

        solution(array, 1);
        System.out.println(Arrays.toString(DP));
    }

    public static boolean solution(int[] weight, int target) {

        if(!DP[target]) {
            DP[target] = true;

            for (int i=0; i<weight.length; i++) {
                if(weight[i] == target) {
                    return solution(weight, target+1);
                } else if (weight[i] > target){
                    int end = i;
                    int total = 0;
                    for(int j=0; j< end; j++) {
                        total = total + weight[j];
                    }

                    if(solution(weight, total-target)) {
                        return solution(weight, target+1);
                    } else {
                        DP[target] = false;
                        return false;
                    }
                } else if (weight[weight.length-1] < target) {
                    DP[target] = false;
                    return false;
                }
            }


        } else {
            return true;
        }



        return false;
    }

}
