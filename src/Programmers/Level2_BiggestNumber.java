package Programmers;



import java.util.ArrayList;
import java.util.List;

public class Level2_BiggestNumber {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        //775841
        // 4,1,2,2 제거
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();


        int[] numArr = new int[number.length()];
        char[] cs = number.toCharArray();
        

        for (int i=0; i<number.length(); i++) {
            numArr[i] = ((int)cs[i] - 48);
        }


        searchNum(numArr,answer, k);
        return answer.toString();
    }

    public static void searchNum(int[] numArr, StringBuilder answer, int cutoff) {
        if (cutoff <= 0) {

            for (int i=0; i<numArr.length; i++)
                answer.append(numArr[i]);
            return;
        } else if (numArr.length - cutoff <= 0) {
            return;
        } else {

            int max = 0;
            int idx = 0;

            for (int i=0; i<=cutoff; i++) {
                if (numArr[i] == 9) {
                    max = 9;
                    idx = i;
                    break;
                }
                else if (max < numArr[i]) {
                    max = numArr[i];
                    idx = i;
                }
            }


            answer.append(numArr[idx]);

            int[] nextArr = new int[numArr.length - idx-1];
            cutoff = cutoff - idx;
            for (int i=0; i<nextArr.length; i++) {
                nextArr[i] = numArr[idx+1];
                idx +=1;
            }

            //nums = nums.subList(idx+1, nums.size());
            searchNum(nextArr, answer, cutoff);
        }

    }


}