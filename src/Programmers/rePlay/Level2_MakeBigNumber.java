package Programmers.rePlay;

// 프로그래머스 https://programmers.co.kr/learn/courses/30/lessons/42883


import java.util.ArrayList;
import java.util.List;

public class Level2_MakeBigNumber {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        System.out.println(solution(number, k));
    }

    static String solution(String number, int k) {
        StringBuilder resultSb = new StringBuilder();
        int toGetSize = number.length() - k;
        List<Integer> resultList = new ArrayList<>();

        makeBiggestNmber(number, toGetSize, 0, resultList);

        for (Integer each : resultList)
            resultSb.append(each);

        return resultSb.toString();
    }

    static void makeBiggestNmber(String number, int toGetSize, int startIdx, List<Integer> resultList) {

        while (toGetSize > 0) {
            int max = -1;
            int maxIdx = -1;
            int toSearch = number.length() - toGetSize;

            for (int i=startIdx; i<=toSearch; i++) {
                int c = Character.getNumericValue(number.charAt(i));
                if (c > max) {
                    max = c;
                    maxIdx = i;
                    if (c == 9) break;
                }
            }

            toGetSize -= 1;
            resultList.add(max);
            startIdx = maxIdx + 1;
        }

    }
}
