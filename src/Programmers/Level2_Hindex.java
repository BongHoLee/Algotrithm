package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.
* */
public class Level2_Hindex {
    public static void main(String[] args) {
        int [] citations = {0,0,0,3,3,3};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int size = citations.length;
        List<Integer> citationList = new ArrayList<>();

        for (int i : citations)
            citationList.add(i);

        int index=0;
        int value = 0;

        while (index < size) {
            value = citationList.get(index);
            if ((size-index) > value) {
                index += 1;
            } else {
                value = size - index;
                break;
            }
        }


        answer = value;
        return answer;
    }

}
