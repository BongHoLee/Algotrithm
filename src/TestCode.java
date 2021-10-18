import java.util.*;

public class TestCode {
    protected String name;
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        for (Integer integer : pq) {
            System.out.println(integer);
        }
    }
}



