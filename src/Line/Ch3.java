package Line;

import java.util.LinkedList;
import java.util.Queue;

public class Ch3 {
    public static void main(String[] args) {
        //System.out.println(solution("11101111001111101111110001111111111111111", 3));
        System.out.println(solution("001100", 3));
    }

    static int solution(String road, int n) {
        int max = 0;
        int tmpMax = 0;
        Queue<Integer> fixedIdxQueue = new LinkedList<>();
        fixedIdxQueue.add(-1);

        for (int i=0; i<road.length(); i++) {
            char roadIdx = road.charAt(i);

            if (roadIdx != '0' && i != road.length()-1) continue;

            if (n > 0) {
                road.replaceFirst("0", "1");
                fixedIdxQueue.add(i);
                n --;
            } else {
                int firstIdx = fixedIdxQueue.poll();
                tmpMax = i - (firstIdx + 1);
                max = Math.max(max, tmpMax);
                fixedIdxQueue.add(i);
            }

            if (i == road.length()-1){
                int firstIdx = fixedIdxQueue.poll();
                tmpMax = road.length() - (firstIdx + 1);
                max = Math.max(max, tmpMax);
                fixedIdxQueue.add(i);
            }

        }

        return max;
    }
}
