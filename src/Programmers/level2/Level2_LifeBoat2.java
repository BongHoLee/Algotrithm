package Programmers.level2;

import java.util.Arrays;
import java.util.List;

public class Level2_LifeBoat2 {

    public static void main(String[] args) {
        int[] people = {70, 50, 10, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lifeBoats = 0;
        int totalWeight = 0;
        int boarded = 0;

        for (int i=0; i<people.length; i++) {
            int peopleWeight = people[i];
            if (totalWeight + peopleWeight <= limit && boarded < 2) {
                totalWeight += peopleWeight;
                boarded += 1;
            }
            else {
                System.out.println(totalWeight);
                totalWeight = peopleWeight;
                lifeBoats += 1;
                boarded = 1;
            }
        }
        System.out.println(totalWeight);

        return lifeBoats + 1;

    }
}
