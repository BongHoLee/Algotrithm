package Programmers.level2;


import java.util.*;

public class Level2_KAKAO_CACHE {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {
                "Jeju",
                "Pangyo",
                "Seoul",
                "NewYork",
                "LA"
        };
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int searchTime = 0;


        PriorityQueue<CacheNode> cacheNodes = new PriorityQueue<>();
        Map<String, CacheNode> citiesMap = new HashMap<>();
        int priority = 0;

        for (String city : cities) {
            CacheNode node;
            priority += 1;
            if (citiesMap.containsKey(city.toUpperCase())) {
                node = citiesMap.get(city.toUpperCase());
                node.isHit();
                cacheNodes.remove(node);
                cacheNodes.offer(node);
                searchTime += 1;

            } else {
                node = new CacheNode(priority, city.toUpperCase());

                if (cacheNodes.size() < cacheSize) {
                    cacheNodes.offer(node);
                    citiesMap.put(city.toUpperCase(), node);
                } else {
                    if (cacheNodes.size() > 0) {
                        citiesMap.remove(cacheNodes.poll().getCity().toUpperCase());
                        citiesMap.put(city.toUpperCase(), node);
                        cacheNodes.offer(node);
                    }
                }
                searchTime += 5;
            }
        }

        return searchTime;
    }
}

class CacheNode implements Comparable<CacheNode> {
    private long hitNum;
    private String city;

    public CacheNode(int hitNum, String city) {
        this.hitNum = hitNum;
        this.city = city;
    }

    public void isHit() {
        hitNum += 100000;
    }

    public String getCity() {
        return city;
    }


    @Override
    public int compareTo(CacheNode o) {
        if (this.hitNum > o.hitNum)
            return 1;
        else if (this.hitNum < o.hitNum)
            return -1;
        return 0;
    }
}
