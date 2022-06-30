package Programmers.highscore_kit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Class desc.
 *
 * @author o118014_D
 * @since 2022-06-30
 */

public class TruckBridge_level2 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weight = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(new TruckBridge_level2().solution(bridge_length, weight, truck_weight));

    }

    private static final Integer EMPTY_TRUCK = 0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        Queue<Integer> waitTrucks = Arrays.stream(truck_weights).boxed()
//                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> waitTrucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for (int each : truck_weights)
            waitTrucks.offer(each);


        int passedTruck = 0;
        int timer = 0;
        int bridgeWeight = 0;
        while (passedTruck < truck_weights.length) {
            if (bridge.size() == bridge_length) {
                int passedTruckWeight = bridge.poll();
                if (passedTruckWeight != EMPTY_TRUCK) {
                    passedTruck += 1;
                    bridgeWeight -= passedTruckWeight;
                }
            }

            if (!waitTrucks.isEmpty()) {
                int nextTruckWeight = waitTrucks.peek() + bridgeWeight > weight ? EMPTY_TRUCK : waitTrucks.poll();
                bridge.offer(nextTruckWeight);
                bridgeWeight += nextTruckWeight;
            } else {
                bridge.offer(EMPTY_TRUCK);
            }

            timer += 1;
        }

        return timer;
    }
}

