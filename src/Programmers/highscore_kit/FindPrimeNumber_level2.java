package Programmers.highscore_kit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPrimeNumber_level2 {

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        String numbers = "002";
        System.out.println(new FindPrimeNumber_level2().solution(numbers));
        System.out.println(list);

    }

    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        return permutationAndCheckPrime("", numbers);
    }

    // 자신의 자릿수에 대한 경우만 생각하고 이하 자릿수는 재귀에 위임한다!
    private int permutationAndCheckPrime(String numbers, String originNumbers) {
        int curPositionsPrimeCount = 0;
        if (originNumbers.length() > 0) {
            for (int i=0; i<originNumbers.length(); i++) {
                String before = originNumbers.substring(0, i);
                String after = originNumbers.substring(i+1);
                String addedNumber = Character.toString(originNumbers.charAt(i));

                String curPositionNumbers = numbers + addedNumber;
                String nextNumbers = before + after;

                curPositionsPrimeCount += isPrime(Integer.parseInt(curPositionNumbers)) ? 1 : 0;
                curPositionsPrimeCount += permutationAndCheckPrime(curPositionNumbers, nextNumbers);
            }
        }

        return curPositionsPrimeCount;
    }

    private boolean isPrime(int number) {
        if (number < 2 || set.contains(number)) return false;
        set.add(number);

        if (number == 2) {
            return true;
        } else {

            int sqrt = (int)(Math.sqrt(number) + 1);
            for (int i=2; i<=sqrt; i++) {
                if (number%i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
