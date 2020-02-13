package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_JadenCase {
    public static void main(String[] args) {
        String s = "for  the last week ";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sList = s.split(" ");
        List<Integer> spaceIdx = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ')
                spaceIdx.add(i);
        }


        for (int i=0; i<sList.length; i++) {
            String content = sList[i].trim();
            if (content.length() > 0) {
                String firstS = sList[i].substring(0, 1);
                String otherS = sList[i].substring(1);

                answer.append(firstS.toUpperCase() + otherS.toLowerCase());
            }
        }

        for (int idx : spaceIdx) {
            answer.insert(idx, " ");
        }

        return answer.toString();
    }
}
