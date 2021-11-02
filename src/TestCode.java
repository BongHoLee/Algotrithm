import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        pq.add(new int[] {0, 1, 2});
        pq.add(new int[] {1, 2, 0});
        System.out.println(Arrays.toString(pq.poll()));
    }
}



