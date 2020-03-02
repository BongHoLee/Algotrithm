package Programmers;
import java.util.*;
public class Level2_KAKAO_CACHE2 {
    public static void main(String[] args) {

    }
    public int solution(int cacheSize, String[] cities) {
        int hit = 1;
        int miss = 5;
        int searchTime = 0;

        Queue<String> cacheQ = new LinkedList<>();
        for (String each : cities) {
            String city = each.toUpperCase();

            if (cacheQ.contains(city)) {
                cacheQ.remove(city);
                cacheQ.offer(city);
                searchTime += hit;
            } else {
                if (cacheSize > 0) {
                    if (cacheQ.size() < cacheSize) {
                        cacheQ.offer(city);
                    } else {
                        cacheQ.poll();
                        cacheQ.offer(city);
                    }
                }
                searchTime += miss;
            }
        }

        return searchTime;
    }
}
