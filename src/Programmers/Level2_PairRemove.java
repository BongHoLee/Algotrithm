package Programmers;

public class Level2_PairRemove {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 1;
        String[] pairList = {
                "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn",
                "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"
        };

        while (s.length() > 0 && answer == 1) {

            int startLen = s.length();

            for (int i=0; i<pairList.length; i++) {
                s = s.replaceAll(pairList[i], "");
            }

            if (startLen == s.length())
                answer = 0;
        }


        return answer;
    }
}
