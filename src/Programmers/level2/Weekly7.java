package Programmers.level2;



import java.util.*;

// Queue / Stack 활용?
// Set으러?!
public class Weekly7 {
    public static void main(String[] args) {
        int[] enter = {1, 4, 2, 3};
        int[] leave = {2, 1, 4, 3};

        int[] result = solution(enter, leave);

        for(int each : result) {
            System.out.print(each + " ");
        }
    }

    public static int[] solution(int[] enter, int[] leave) {
        int[] meetCount = new int[enter.length];
        Set<Integer> room = new HashSet<>();

        int enterPos = 0;
        int leavePos = 0;

        while (enterPos < enter.length && leavePos < leave.length) {
            room.add(enter[enterPos]);

            while (leavePos < leave.length && room.contains(leave[leavePos])) {
                room.remove(leave[leavePos]);

                for (Integer each : room) {
                    meetCount[each-1] += 1;
                }

                meetCount[leave[leavePos]-1] += room.size();
                leavePos++;
            }
            enterPos++;
        }

        return meetCount;
    }

}
