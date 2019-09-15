package Programmers;

public class Level2Test1 {

    public static void main(String[] args) {
        solution("(())()())))((");
    }

    public static boolean solution(String s) {
        int check = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                check += 1;
            else
                check -= 1;

            if(check < 0) {
                return false;
            }
        }

        if(check == 0)
            return true;
        else
            return false;
    }
}
