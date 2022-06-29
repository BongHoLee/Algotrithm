package Programmers.highscore_kit;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 고득점_KIT level2 '위장' - hash
 *
 */

public class Camouflage_level2_OPTIMIZATION {
    private final static int CATEGORY = 1;

    public static void main(String[] args) {

//        String[][] clothes = {
//                {"yellowhat", "headgear"},
//                {"bluesunglasses", "eyewear"},
//                {"green_turban", "headgear"}
//        };

        String[][] clothes = {
                {"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}
        };



        Camouflage_level2_OPTIMIZATION prov = new Camouflage_level2_OPTIMIZATION();
        System.out.println(prov.solution(clothes));

    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clotheMap = categoryMapOf(clothes);
        Integer[] values = clotheMap.values().toArray(Integer[]::new);

        return combinationCountOf(values);
    }


    private int combinationCountOf(Integer[] values) {

        int result = 1;
        for (Integer value : values) {

            // 각 카데고리에 해당하는 옷들 중 '입지 않는 경우'까지 포함하여 + 1
            result *= (value + 1);
        }

        // 최종적으로 모든 카테고리를 입지 않는 경우인 1을 뺀다.
        // 시간 복잡도가 O(N^2) -> O(N)
        return result - 1;
    }

    private Map<String, Integer> categoryMapOf(String[][] categoriesWithProducts) {
        Map<String, Integer> categoryMap = new HashMap<>();

        for (String[] categoryAndProduct : categoriesWithProducts) {
            String category = categoryAndProduct[CATEGORY];

            if (categoryMap.containsKey(category)) {
                categoryMap.put(category, categoryMap.get(category) + 1);
            } else {
                categoryMap.put(category, 1);
            }
        }

        return categoryMap;
    }
}
