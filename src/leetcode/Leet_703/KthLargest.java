package leetcode.Leet_703;

import java.util.PriorityQueue;

// k'th largest elements get
// 3'th largest element of [2, 4, 5, 8] -> 4

// use 'heap'
public class KthLargest {
    private final int k;

    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
        }

        while (pq.size() > k) {
            pq.remove();
        }
    }

    public int add(int val) {
        pq.offer(val);

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
