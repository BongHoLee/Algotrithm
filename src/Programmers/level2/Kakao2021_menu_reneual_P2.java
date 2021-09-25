package Programmers.level2;

import java.util.*;

public class Kakao2021_menu_reneual_P2 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        System.out.println(Arrays.asList(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();


        for (int size : course) {
            Map<String, Integer> menuCount = new HashMap<>();
            for (String order : orders) {
                String[] orderArr = order.split("");
                Arrays.sort(orderArr);
                recursive(orderArr, "", menuCount, size, 0);
            }

            List<String> sortedList = new ArrayList<>(menuCount.keySet());
            sortedList.sort((String key1, String key2) -> {
             return menuCount.get(key2) - menuCount.get(key1);
            });

            int max = sortedList.size() > 0 ? menuCount.get(sortedList.get(0)) : 0;
            for (String s : sortedList) {
                if (menuCount.get(s) >= max && menuCount.get(s) > 1) {
                    max = menuCount.get(s);
                    answer.add(s);
                } else {
                    break;
                }
            }


        }

        Collections.sort(answer);
        String[] strAnswer = new String[answer.size()];
        for (int i=0; i<strAnswer.length; i++) {
            strAnswer[i] = answer.get(i);
        }

        return strAnswer;
    }

    private static void recursive(String[] menus, String curCombMenu, Map<String, Integer> menuCount, int size, int pos) {
        if (curCombMenu.length() == size) {
            if (menuCount.containsKey(curCombMenu)) {
                int count = menuCount.get(curCombMenu);
                menuCount.put(curCombMenu, count + 1);
            } else {
                menuCount.put(curCombMenu, 1);
            }
        } else {
            for (int i=pos; i<menus.length && (menus.length - i) >= (size - curCombMenu.length()); i++) {
                int tmp1 = size - curCombMenu.length(); // size까지 남은 갯수
                int tmp2 = menus.length - i; // 남은 루핑 아이템 갯수
                String nextCombMenu = curCombMenu + menus[i];
                recursive(menus, nextCombMenu, menuCount, size, i + 1);
            }
        }
    }
}
