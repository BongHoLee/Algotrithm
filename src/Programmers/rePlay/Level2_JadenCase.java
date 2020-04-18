package Programmers.rePlay;

public class Level2_JadenCase {
    public static void main(String[] args) {
        System.out.println(solution("3for  the last week "));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean canUpper = true;
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (isAlphabet(c)) {
                if (canUpper) {
                    c = Character.toUpperCase(c);
                    canUpper = false;
                }
            } else {
                if (c == ' ')
                    canUpper = true;
                else
                    canUpper = false;
            }
            sb.append(c);
        }

        return sb.toString();
    }
    public static boolean isAlphabet(char c) {
        return c >= 97 && c <= 122;
    }
}
