package Programmers;

public class Level2_MaxMin {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String contents : s.split(" ")) {
            max = Math.max(max, Integer.parseInt(contents));
            min = Math.min(min, Integer.parseInt(contents));
        }

        answer = min + " " + max;

        return answer;
    }

}
