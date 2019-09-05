package Programmers;

import java.util.Arrays;

public class Solution {
// [1, 1, 2, 3, 6, 7, 30]


    public static void main(String[] args) {
        int[] weight = {3, 1, 6, 2, 7, 30, 1};



    }

    public int solution(int[] weight) {
        int add = 0;
        int size = weight.length;
        int[] addedWeights = new int[size];

        Arrays.sort(weight);
        for(int i=0; i<size; i++) {
            add += weight[i];
            addedWeights[i] = add;
        }

        for(int i=0; i<size - 1; i++) {
            if(weight[i+1] > addedWeights[i] + 1) {
                return addedWeights[i] + 1;
            }
        }

        return addedWeights[size -1] + 1;
    }


}
