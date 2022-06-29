package Programmers.highscore_kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 고득점_KIT level2 '위장' - hash OLD 버전 (재귀 사용)
 *
 */

public class Camouflage_level2_OLD {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> numberList = new ArrayList<>();

        for (int i=0; i<clothes.length; i++) {
            String[] each = clothes[i];
            if (map.containsKey(each[1])) {
                int num = map.get(each[1]);
                map.put(each[1], num + 1 );
            } else {
                map.put(each[1], 1);
            }
        }

        for (String key : map.keySet()) {
            numberList.add(map.get(key));
        }


        for (int i=0; i<numberList.size(); i++) {
            answer += countRecursion(numberList, 1, i+1, 0);
        }

        return answer;
    }

    public int countRecursion(List<Integer> numberList, int result, int remainCountForCalc, int curIdx) {
        if (remainCountForCalc <= 0)
            return result;
        else {
            int curResult = 0;
            for (int i=curIdx; (numberList.size() - i)>=remainCountForCalc; i++) {
                curResult += countRecursion(numberList, result * numberList.get(i), remainCountForCalc-1, i+1);
            }

            return curResult;
        }
    }
}
