package Programmers.rePlay;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Level2_RamenFactory2 {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates =    {4, 10, 15, 20, 40, 50};
        int[] supplies = {20, 5, 10, 7, 28, 199};
        int k = 30;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        int lastDate = 0;
        List<Integer> dateList = Arrays.stream(dates).boxed().collect(Collectors.toList());
        List<Integer> supplyList = Arrays.stream(supplies).boxed().collect(Collectors.toList());


        Collections.sort(dateList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (supplies[dateList.indexOf(o1)] > supplies[dateList.indexOf(o2)])
                    return -1;
                else if (supplies[dateList.indexOf(o1)] < supplies[dateList.indexOf(o2)])
                    return 1;
                else
                    return 0;
            }
        });

        Collections.sort(supplyList, Collections.reverseOrder());


        System.out.println(dateList);
        System.out.println(supplyList);

        while (dateList.size() > 0 && stock < k) {
            int date = dateList.remove(0);
            int supply = supplyList.remove(0);

            if (date < lastDate)
                continue;

            if (stock < date) {
                dateList.add(date);
                supplyList.add(supply);
                continue;
            }


            stock += supply;
            lastDate = date;
            answer += 1;


        }


        return answer;
    }
}
