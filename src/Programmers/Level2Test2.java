package Programmers;


public class Level2Test2 {
    public static void main(String[] args) {

        System.out.println(solution("-4 -3 -2 -1"));
    }

    public static String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);

        for(int i=1; i<str.length; i++) {
            int tmp = Integer.parseInt(str[i]);

            if(max < tmp)
                max = tmp;

            if(min > tmp)
                min = tmp;

        }
        answer = min + " " + max;

        return answer;
    }
}
