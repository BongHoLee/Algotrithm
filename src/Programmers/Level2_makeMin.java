package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level2_makeMin {
    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {3,4};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] min, int[] max) {
        int answer = 0;
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();

        for (int i=0; i<min.length; i++) {
            minList.add(min[i]);
            maxList.add(max[i]);
        }

        Collections.sort(minList);
        Collections.sort(maxList, Collections.reverseOrder());

        for (int i=0; i<minList.size(); i++) {
            answer += minList.get(i) * maxList.get(i);
        }

        return answer;
    }
}
