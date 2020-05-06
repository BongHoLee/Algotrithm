package Programmers;

import java.util.Arrays;

public class Level2_LifeBoat3 {
    public static void main(String[] args) {
        int[] people = { 10, 50,50, 70, 80};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lifeBoats = 0;
        int start = 0;
        int last = people.length - 1;
        int lastBoarded = 0;

        while (start <= last) {

            int lightPerson = people[start];
            int heavyPerson = people[last];
            if (start == last) {
                lastBoarded = 1;
                break;
            }

            if (lightPerson + heavyPerson <= limit) {
                lifeBoats += 1;
                start ++;
                last --;
                lastBoarded = 2;

            } else {
                lifeBoats += 1;
                last--;
                lastBoarded = 1;
            }
        }

        return lastBoarded == 1 ? lifeBoats + 1 : lifeBoats;
    }
}
