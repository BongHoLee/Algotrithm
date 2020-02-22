package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Level2_KAKAO_NewsClustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "E=M*C^2";
        System.out.println(solution(str1, str2));

    }

    // 자카드 유사도
    // (교집합 크기 / 합집합 크기)
    // 대문자 아스키 : 65 ~ 90
    // 소문자 아스키 : 97 ~ 122

    public static int solution(String str1, String str2) {

        List<String> aList = setStrList(str1);
        List<String> bList = setStrList(str2);



        return calcJarcard(aList, bList);
    }

    public static List<String> setStrList(String str) {
        List<String> list = new ArrayList<>();

        for (int i=1; i<str.length(); i++) {
            char c1 = str.charAt(i-1);
            char c2 = str.charAt(i);

            if (isAlphabet(c1) && isAlphabet(c2)) {
                c1 = Character.toLowerCase(c1);
                c2 = Character.toLowerCase(c2);
                list.add(Character.toString(c1) + Character.toString(c2));
            }
        }

        return list;
    }

    public static boolean isAlphabet(char c) {
        if (('a' <= c) && ('z' >= c) || ('A' <= c) && ('Z' >= c) )
            return true;
        else
            return false;
    }

    public static int calcJarcard(List<String> aList, List<String> bList) {
        int kyoNum = 0;
        int hapNum = 0;

        while(aList.size() > 0) {
            String checkStr = aList.get(0);
            int aListCount = getStrCount(aList, checkStr);
            int bListCount = getStrCount(bList, checkStr);

            kyoNum = kyoNum + Math.min(aListCount, bListCount);
            hapNum = hapNum + Math.max(aListCount, bListCount);
        }

        while (bList.size() > 0) {
            bList.remove(0);
            hapNum += 1;
        }

        double jcard = 1.0;
        if (!(kyoNum == 0 && hapNum == 0))
            jcard = (double)kyoNum/(double)hapNum;

        return (int)(jcard * 65536);
    }

    public static int getStrCount(List<String> list, String str) {
        if (!list.contains(str))
            return 0;
        else {
            list.remove(str);
            return 1 + getStrCount(list, str);
        }

    }




}
