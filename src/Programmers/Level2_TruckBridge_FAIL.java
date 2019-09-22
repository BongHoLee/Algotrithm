package Programmers;


// queue를 이용한 문제 풀이
// 실패코드. 패턴을 제대로 파악을 못함. ㅠㅠ
// 너무 Recursion으로 풀려

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_TruckBridge_FAIL {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5};

        System.out.println(solution(bridge_length, weight, truck_weights));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> trucks = new LinkedList<>();
        for (int i : truck_weights)
            trucks.add(i);

        while (!trucks.isEmpty()) {

            answer += passBridge(trucks, 0, 0, 0, bridge_length, weight);
        }

        return answer;
    }

    public static int passBridge(Queue<Integer> trucks, Integer onBridge, Integer totalWeight, Integer timer, Integer len, Integer weight) {


        if (!trucks.isEmpty()) {

            // 1. 현재 다리위 truck과 대기열 1순위 truck의 weight를 검사.
            if (trucks.peek() + totalWeight <= weight) {
                totalWeight += trucks.poll();
                onBridge += 1;
                return passBridge(trucks, onBridge, totalWeight, timer, len, weight);
            } else {
                timer += len + (onBridge > 1 ? onBridge-1 : onBridge);
                return timer;
            }

        } else {
            timer += len + (onBridge > 1 ? onBridge-1 : onBridge);
            return timer;
        }

    }
}
