package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Level2_LifeBoat {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        List<Integer> lifeBoat = new ArrayList<>();
        
        for (int i=0; i<people.length; i++) {
            int peopleWeight = people[i];
            if (peopleWeight / 2 >= limit) {
                lifeBoat.add(peopleWeight);
                continue;
            }

            if (lifeBoat.size() == 0) lifeBoat.add(peopleWeight);
            else {
                boolean boarded = false;
                for (int boat = 0; boat<lifeBoat.size(); boat++) {
                    int boatWeight = lifeBoat.get(boat);
                    if (boatWeight + peopleWeight <= limit) {
                        lifeBoat.set(boat, boatWeight + peopleWeight);
                        boarded = true;
                        break;
                    }
                }
                if (!boarded) lifeBoat.add(peopleWeight);
            }

        }

        System.out.println(lifeBoat);
        return lifeBoat.size();

    }
}
