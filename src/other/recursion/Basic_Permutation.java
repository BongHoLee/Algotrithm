package other.recursion;

import java.util.Arrays;

/**
 *  순서를 갖는 모든 경우의 수를 구하는 순열을 재귀로 구현
 *  주어진 numbers = "0195"일 때 모든 순열을 출력한다.
 */

public class Basic_Permutation {
    public static void main(String[] args) {
        String numbers = "0195";
        Basic_Permutation permutation = new Basic_Permutation();

        permutation.printPermutation(numbers);
    }

    public void printPermutation(String numbers) {
        String[] numberTable = new String[numbers.length()];
        boolean[] isUsed = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            numberTable[i] = Character.toString(numbers.charAt(i));
        }

        printAll(numberTable, isUsed, "");
    }

    private void printAll(String[] numberTable, boolean[] isUsed, String madeNumbers) {
        if (madeNumbers.length() == numberTable.length) {
            System.out.println(madeNumbers);
        } else {
            for (int i = 0; i < numberTable.length; i++) {
                if (!isUsed[i]) {
                    String nextNumbers = numberTable[i] + madeNumbers;
                    isUsed[i] = true;
                    printAll(numberTable, isUsed, nextNumbers);
                    isUsed[i] = false;
                }
            }
        }
    }
}
