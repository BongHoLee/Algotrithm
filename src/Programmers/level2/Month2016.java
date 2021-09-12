package Programmers.level2;


// Programmers - LEVEL2

public class Month2016 {
    public static void main(String[] args) {
        String result = Solution(4, 13);
        System.out.println(result);
    }

    public static String Solution(int a, int b) {
        String answer = "";


        int allDay = 0;
        for(int i=1; i<a; i++) {
            if( i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                allDay += 31;
            else if ( i == 2)
                allDay += 29;
            else {
                allDay += 30;
            }
        }
        allDay += b;
        int result = allDay%7;

        //SUN,MON,TUE,WED,THU,FRI,SAT
        if(result == 1)
            answer = "FRI";
        else if (result == 2)
            answer = "SAT";
        else if (result == 3)
            answer = "SUN";
        else if (result == 4)
            answer = "MON";
        else if (result == 5)
            answer = "TUE";
        else if (result == 6)
            answer = "WED";
        else if (result == 0)
            answer = "THU";

        return answer;
    }
}
