package ohouse;

import java.util.HashSet;
import java.util.Set;

/**
 * 0과 1로만 이루어진 문자열 s와 자연수 n이 있다.
 * 모든 자연수에 대한 이진수 표현이 s의 '부분 문자열'에 있는지 판단하라.
 *
 * 부분 문자열 관련 알고리즘 지식과 인사이트가 부족하여 어떻게 접근해야하는지 너무 헤맸다.
 * 결국 일반적인 부분문자열 알고리즘이 아니라 약간 방향을 달리해서 s로 구할 수 있는 모든 수를 구하는 방향으로 풀었다.
 * 테스트는 통과했는데 아무래도 최적화 등을 신경쓰지 못해서 부분점수만 받을 듯..
 *
 * KMP 문자열 알고리즘에 대한 이해와 학습이 필요할 듯 하다. (근데 난이도가 높은 편이라서 그 전에 쉬운 것들 부터 해야할 듯)
 *
 */
public class P2 {
    public static void main(String[] args) {
        String s = "0110";
        int n = 4;
        P2 p2 = new P2();
        System.out.println(p2.solution(s, n));

    }


    public boolean solution(String s, int n) {
        Set<Long> numberSet = new HashSet<>();
        long totalSum = totalSumOf(n);
        
        long resultSum = 0;
        for (int i=s.length()-1; i>=0; i--) {
            long pos = 0;
            long sum = 0;

            for (int j=i; j>=0; j--) {
                int posNumber = Integer.parseInt(Character.toString(s.charAt(j)));
                if (posNumber == 1) {
                    sum += Math.pow(2, pos);
                    if (sum > n) break;
                    resultSum += numberSet.add(sum) ? sum : 0;
                }
                pos++;
            }
        }

        return totalSum == resultSum;
    }


    private long totalSumOf(int n) {
        long sum = 0;
        if (n % 2 == 0) {
            sum = (long) (1 + n) * (n/2);
        } else {
            sum = (long) (1 + n - 1) * (n/2) + n;
        }
        return sum;
    }


}
