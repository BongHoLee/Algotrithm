package Programmers.level2;

import java.util.*;

public class Level2_BigNumber {
    public static void main(String[] args) {
        int[] number = {12,1213};
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
                String o1Str = Integer.toString(o1);
                String o2Str = Integer.toString(o2);

                int o1Jari = o1Str.length();
                int o2Jari = o2Str.length();
                int o1Copy = o1;
                int o2Copy = o2;

                int loopCount = Math.max(o1Jari, o2Jari);

                for (int i=0; i<loopCount; i++) {
                    int o1CompValue = 0;
                    int o2CompValue = 0;

                    if(o1Jari > 1) {
                        o1CompValue = (int) (o1Copy/Math.pow(10, o1Jari - 1));

                        o1Copy = (int) (o1Copy%Math.pow(10, o1Jari - 1));
                        o1Jari -= 1;
                    } else {
                        o1CompValue = (int) (o1Copy%10);
                    }

                    if(o2Jari > 1) {
                        o2CompValue = (int) (o2Copy/Math.pow(10, o2Jari - 1));

                        o2Copy = (int) (o2Copy%Math.pow(10, o2Jari - 1));
                        o2Jari -= 1;
                    } else {
                        o2CompValue = (int) (o2Copy%10);
                    }

                    if (o1CompValue > o2CompValue) {
                        return -1;
                    } else if (o1CompValue < o2CompValue) {
                        return 1;
                    }

                }
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
