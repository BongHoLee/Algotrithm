package Programmers;



import java.util.ArrayList;
import java.util.List;

public class Level2_BiggestNumber {
    public static void main(String[] args) {
        String number = "10000";
        int k = 2;

        //775841
        // 4,1,2,2 제거
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();


        int[] numArr = new int[number.length()];
        char[] cs = number.toCharArray();
        List<Integer> resultList = new ArrayList<>();

        for (int i=0; i<number.length(); i++) {
            numArr[i] = ((int)cs[i] - 48);
        }

        int makeSize = numArr.length - k;
        searchNum(numArr,resultList, k, 0, makeSize);
        for (Integer integer : resultList) answer.append(integer);
        return answer.toString();
    }

    public static void searchNum(int[] numArr, List<Integer> resultList, int cutoff, int curIdx, int makeSize) {
        if (cutoff <=0) {
            for (int i=curIdx; i<numArr.length; i++)
                resultList.add(numArr[i]);
            return;
        } else if (resultList.size() >= makeSize ) {
            return;
        } else {

            int max = -1;
            int idx = curIdx;

            for (int i=curIdx; i<=cutoff+curIdx; i++) {
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


            resultList.add(numArr[idx]);
            cutoff = cutoff - (idx - curIdx);
            idx += 1;

            //nums = nums.subList(idx+1, nums.size());
            searchNum(numArr, resultList, cutoff, idx, makeSize);
        }

    }


}