package Programmers;

public class IntegerSum {
    public static void main(String[] args) {


        System.out.println(solution(10, -8));
        System.out.println(solution2(10, -8));

    }

    public static long solution(int a, int b) {
        long answer = 0;



        return answer;
    }

    public static long solution2 (int a, int b) {
        long answer = 0;

        if(a == b)
            return a;
        else if (a > b) {
            for(int i=b; i<=a; i++) {
                answer += i;
            }
        } else {
            for (int i=a; i<=b; i++) {
                answer +=i;
            }
        }

        return answer;

    }



}
