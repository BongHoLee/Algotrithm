package Programmers.highscore_kit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber_level2 {

    static int count = 0;
    public static void main(String[] args) {
        String numbers = "1234";
        new FindPrimeNumber_level2().getPermutationTest("", numbers);
        System.out.println(count);
    }

    private Set<Integer> set =new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int numbersSize = numbers.length();


        return answer;
    }

    // 자신의 자릿수에 대한 경우만 생각하고 이하 자릿수는 재귀에 위임한다!
    private String getPermutation(String numbers, int originLength) {
        if (numbers.length() == 0) {
            return numbers;
        } else {
            int numbersSize = numbers.length();
            for (int i=0; i<numbersSize; i++) {
                String before = numbers.substring(0, i);
                String center = Character.toString(numbers.charAt(i));
                String after = numbers.substring(i+1, numbersSize);

                String next = before + after;

            }

            return numbers;
        }
    }

    // 자기 부분만 처리하고 나머지 자리들은 하위에 위임!
    public void getPermutationTest(String curNumbers, String existsNumbers) {
        if (existsNumbers.length() == 0) {
            count++;
            System.out.println(curNumbers);
        } else {

            // numbers에 덧붙이는 방식
            int size = existsNumbers.length();
            for (int i=0; i<size; i++) {
                String before = existsNumbers.substring(0, i);
                String added = Character.toString(existsNumbers.charAt(i));
                String after = existsNumbers.substring(i+1, size);

                String nextNumbers = curNumbers + added;
                String nextExistsNumbers = before + after;
                getPermutationTest(nextNumbers, nextExistsNumbers);
            }
        }
    }

    private boolean isPrime(int number) {
        if (set.contains(number)) return false;
        else {
            return true;
        }
    }
}
