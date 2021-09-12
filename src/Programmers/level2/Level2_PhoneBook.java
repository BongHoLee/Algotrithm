package Programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Level2_PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phones = Arrays.asList(phone_book);

        Collections.sort(phones, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return -1;
                else if (o1.length() > o2.length())
                    return 1;
                else
                    return 0;
            }
        });

        for (int i=0; i<phones.size() && answer; i++) {
            String prefix = phones.get(i);

            for (int j=i+1; j<phones.size() && answer; j++) {
                if (phones.get(j).startsWith(prefix)) {
                    answer = false;
                }
            }

        }


        return answer;
    }
}
