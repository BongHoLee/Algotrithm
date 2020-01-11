package Programmers;

import java.util.*;

public class Level2_Spy {
    public static void main(String[] args) {
        String[][] clothes = {
                            {"yellow_hat", "headgear"},
                            {"blue_sunglasses", "headgear"},
                            {"green_turban", "headgear"}
                                                        };
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int ans = 1;

        Map<String, Integer> clothMap = new HashMap<>();

        for (String[] clothe : clothes) {
            if (clothMap.containsKey(clothe[1]))
                clothMap.put(clothe[1], clothMap.get(clothe[1]) + 1);
            else
                clothMap.put(clothe[1], 1);
        }

        for (String key : clothMap.keySet()) {
            ans = ans * (clothMap.get(key) + 1);
        }


        return ans-1;
    }

}
