package Programmers.highscore_kit;

import java.util.*;

public class FindPrimeNumber_level2_OLD {
    public int solution(String numbers) {
        List<String> charList = new ArrayList<>();
        Set<Integer> numberCandidates = new HashSet<>();

        for (char c : numbers.toCharArray()) {
            charList.add(Character.toString(c));
        }

        for (int toCount=1; toCount<=charList.size(); toCount++)
            searchCandidates(charList, numberCandidates, "", 0, toCount);



        return getPrimeNumberCount(numberCandidates);
    }

    public void searchCandidates(List<String> charList, Set<Integer> numberCandidates, String curStr, int curCount, int countTo) {
        if (curCount == countTo)
            numberCandidates.add(Integer.parseInt(curStr));
        else {
            for (int i=0; i<charList.size(); i++) {
                String removed = charList.remove(i);
                searchCandidates(charList, numberCandidates, curStr + removed, curCount + 1, countTo);
                charList.add(i, removed);
            }
        }
    }

    public int getPrimeNumberCount(Set<Integer> candidates) {
        int total = 0;
        for (Integer each : candidates) {
            boolean isPrime = each == 2 || each == 3;

            for (int i=2; i*i<=each; i++) {
                if (each % i != 0) {
                    isPrime = true;
                } else {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                total += 1;
                System.out.println(each);
            }

        }

        return total;
    }
}