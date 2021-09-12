package Programmers.level2;

import java.util.*;

public class Level2_BigNumberRe {

    public static void main(String[] args) {
        int[] number = {3, 30, 34, 5, 9};
        System.out.println(solution(number));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        List<Integer> numbersList = new ArrayList<>();
        Arrays.sort(numbers);

        for (int number : numbers) {
            numbersList.add(number);
        }

        //정렬
        Collections.sort(numbersList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o1Str = Integer.toString(o1) + Integer.toString(o2);
                String o2Str = Integer.toString(o2) + Integer.toString(o1);

                int o1Value = Integer.parseInt(o1Str);
                int o2Value = Integer.parseInt(o2Str);

                if(o1Value > o2Value)
                    return -1;
                else if (o1Value < o2Value)
                    return 1;
                else
                    return 0;
            }
        });

        for(int i : numbersList)
            answer += Integer.toString(i);
        if(answer.startsWith("0"))
            return "0";
        else
            return answer;
    }

}