package Programmers.level2;

//Queue를 이용하여 풀자

import java.util.LinkedList;
import java.util.Queue;

public class Level2_TruckBridge {
    public static void main(String[] args) {
        int length = 2;
        int weight = 4;
        int[] trucks = {1,2,1,2}; // 6 + 4 + 1 + 4 +
        System.out.println(solution(length, weight, trucks));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int timer = 0;
        int totalWeight = 0;
        int passedTruck = 0;

        LimitedQueue<Integer> onBridge = new LimitedQueue<>(bridge_length);
        Queue<Integer> trucks = new LinkedList<>();

        for(int i : truck_weights)
            trucks.add(i);


        onBridge.add(trucks.peek());
        totalWeight += trucks.poll();
        timer += 1;

        while (passedTruck < truck_weights.length) {

            // 1. 다리 위가 꽉 찬 경우.
            if(onBridge.isFull()) {
                timer += 1;

                //onBridge에서 빠져나온게 트럭인 경우
                if (onBridge.peek() != 0) {
                    totalWeight -= onBridge.poll();
                    passedTruck += 1;

                } else {
                    onBridge.poll();
                }

                // 트럭 추가가 가능한 경우.
                if (!trucks.isEmpty() && weight >= totalWeight + trucks.peek()) {
                    totalWeight += trucks.peek();
                    onBridge.add(trucks.poll());
                } else {
                    onBridge.add(0);
                }

                //2. 다리 위가 꽉 차지 않은 경우.
            } else {
                timer += 1;

                // 트럭 추가가 가능한 경우.
                if (!trucks.isEmpty() && weight >= totalWeight + trucks.peek()) {
                    totalWeight += trucks.peek();
                    onBridge.add(trucks.poll());
                } else {
                    onBridge.add(0);
                }

            }
        }


        return timer;
    }
}

class LimitedQueue<Integer> extends LinkedList<Integer> {
    int len;

    public LimitedQueue(int len) {
        this.len = len;
    }

    @Override
    public boolean add(Integer integer) {

        if(isFull())
            return false;

        return super.add(integer);
    }

    public boolean isFull() {
        if (this.size() == len)
            return true;
        else
            return false;
    }
}