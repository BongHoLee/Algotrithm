package Programmers.highscore_kit;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 고득점_KIT level2 '위장' - hash
 *
 */

public class Camouflage_level2 {
    private final static int PRODUCT = 0;
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



        Camouflage_level2 prov = new Camouflage_level2();
        System.out.println(prov.solution(clothes));

    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clotheMap = categoryMapOf(clothes);
        Integer[] values = clotheMap.values().toArray(Integer[]::new);

        return combinationCountOf(values);
    }

    // 이 2중 for문을 이해해야 하는데..
    private int combinationCountOf(Integer[] values) {
        int result = 0;
        for (int i = 0; i< values.length; i++) {        // i 번째 카테고리를 포함했을 때

            int eachCount = values[i];
            for (int j = i+1; j< values.length; j++) {
                // (j번째 카테고리를 포함하지 않는 경우) + (j번째 카테고리를 포함하는 경우)
                eachCount = eachCount + (eachCount * values[j]);
            }

            result += eachCount;
        }

        return result;
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
