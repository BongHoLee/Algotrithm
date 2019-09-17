package Programmers;

public class IntegerSum {
    public static void main(String[] args) {


        long result = solution(10000000, 1);
        long result2 = solution2(10000000, 1);

        System.out.println(result);
        System.out.println(result2);

    }

    public static long solution(int a, int b) {
        long answer = 0;
        long longA = a;
        long longB = b;

        if (longA == longB)
            return longA;
        else if (longA > longB) {
            long minValue = ((longB-1) * (longB)) / 2;
            answer = ((longA*(longA+1)) / 2) - minValue;
        } else if (longB > longA){
            long minValue = ((longA-1) * (longA)) / 2;
            answer = ((longB* (longB+1)) / 2) - minValue;
        }

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
