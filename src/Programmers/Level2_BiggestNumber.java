package Programmers;



import java.util.ArrayList;
import java.util.List;

public class Level2_BiggestNumber {
    public static void main(String[] args) {
        String number = "1231234";
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

        int toGetSize = numArr.length - k;
        searchNum(numArr,resultList, k, 0, toGetSize);

        for (Integer integer : resultList) answer.append(integer);
        return answer.toString();
    }

    public static void searchNum(int[] numArr, List<Integer> resultList, int cutoff, int curIdx, int toGetSize) {
        if (cutoff <=0) {
            for (int i=curIdx; i<numArr.length; i++)
                resultList.add(numArr[i]);
        } else if (resultList.size() < toGetSize) {

            int max = -1;
            int maxIdx = curIdx;

            for (int i=curIdx; i<=cutoff+curIdx; i++) {
                if (numArr[i] == 9) {
                    max = 9;
                    maxIdx = i;
                    break;
                }
                else if (max < numArr[i]) {
                    max = numArr[i];
                    maxIdx = i;
                }
            }


            resultList.add(numArr[maxIdx]);
            cutoff = cutoff - (maxIdx - curIdx);
            maxIdx += 1;

            searchNum(numArr, resultList, cutoff, maxIdx, toGetSize);
        }

    }


}