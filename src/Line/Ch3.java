package Line;

import java.util.LinkedList;
import java.util.Queue;

public class Ch3 {
    public static void main(String[] args) {
        System.out.println(solution("01110011110011011111", 3));
    }

    // 0 1 1 1 0 0 1 1 1 1 0 0 1 1 0 1 1 1 1 1

    public static int solution (String inputString, int n) {
        int max = 0;
        StringBuilder sb = new StringBuilder(inputString);
        Queue<Integer> indexQueue = new LinkedList<>();
        indexQueue.add(-1);

        for(int roadIndex = 0; roadIndex < sb.length(); roadIndex++) {
            if (sb.charAt(roadIndex) == '0') {
                // 만일 현재 위치의 문자가 '0'이면 위치를 저장
                indexQueue.add(roadIndex);
                if (n <= 0)
                    max = Math.max(max, getOneLen(indexQueue, roadIndex));
                n--;
            }
        }

        max = Math.max(max, getOneLen(indexQueue, inputString.length()));
        return max;
    }

    static int getOneLen(Queue<Integer> indexQueue, int to) {
        int len = 0;
        if (!(indexQueue.isEmpty())) {
            int from = indexQueue.poll();
            len = (to) - (from+1);
        }

        return len;
    }
}
// 01110011110011011111
