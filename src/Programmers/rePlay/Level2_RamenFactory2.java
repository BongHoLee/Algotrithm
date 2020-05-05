package Programmers.rePlay;

import java.util.*;
import java.util.stream.Collectors;

public class Level2_RamenFactory2 {
    public static void main(String[] args) {


//        입력값 〉 4, [4, 10, 15], [20, 5, 10], 30
//        기댓값 〉 2
//
//        입력값 〉 10, [5, 10], [1, 100], 110
//        기댓값 〉 1
//
//        입력값 〉 4, [1, 2, 3, 4], [10, 40, 20, 30], 100
//        기댓값 〉 4
//
//        입력값 〉 2, [1], [10], 10
//        기댓값 〉 1


        int stock = 4;
        int[] dates =    {1, 2, 3, 5 };
        int[] supplies = {10, 0, 20, 30};
        int k = 100;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        int lastDate = 0;
        List<Integer> dateList = Arrays.stream(dates).boxed().collect(Collectors.toList());
        List<Integer> tmpDataList = new ArrayList<>(dateList);
        List<Integer> supplyList = Arrays.stream(supplies).boxed().collect(Collectors.toList());


        Collections.sort(dateList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (supplyList.get(tmpDataList.indexOf(o1)) > supplyList.get(tmpDataList.indexOf(o2)))
                    return -1;
                else if (supplyList.get(tmpDataList.indexOf(o1)) < supplyList.get(tmpDataList.indexOf(o2)))
                    return 1;
                else
                    return 0;
            }
        });

        Collections.sort(supplyList, Collections.reverseOrder());
//
//
//        System.out.println(dateList);
//        System.out.println(supplyList);

        while (dateList.size() > 0 && stock < k) {
            int date = dateList.remove(0);
            int supply = supplyList.remove(0);

            if (stock < date) {
                dateList.add(date);
                supplyList.add(supply);
                continue;
            }
            stock += supply;
            answer += 1;
        }


        return answer;
    }
}
