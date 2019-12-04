package Programmers;


import java.util.*;


public class Level2_FindPrimeNumber {
    public static String num = "";

    public static void main(String[] args) {

        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;
        num = numbers;

        int end = num.length();
        Set<Integer> numSet = new HashSet<>();

        for (int i=0; i<numbers.length(); i++) {
            String startNum = Character.toString(numbers.charAt(i));
            setNumbers(0, end, startNum, numSet);
        }

        List<Integer> sortedNums = new ArrayList<>();
        sortedNums.addAll(numSet);
        Collections.sort(sortedNums);

        int largestNum = sortedNums.get(sortedNums.size()-1);
        int untilNum = (int) Math.floor(Math.sqrt(largestNum));

        return countPrimeNumber(sortedNums, untilNum + 1);
    }

    // 가장 중요한 부분 중 하나. number 순서로 만들 수 있는 경우의 수 구하기 (재귀로 구현)
    public static void setNumbers(int start, int end, String number, Set<Integer> numSet) {
        if(start > end) {
            return;
        } else {
            numSet.add(Integer.parseInt(number));
            String remainNum = getRemainNumber(number);

            for(int i=0; i<remainNum.length(); i++) {
                String addedNumber = number + remainNum.charAt(i);

                setNumbers(start+1, end, addedNumber, numSet);
            }
        }
    }

    // number를 제외한 남은 수 목록을 구하는 메서드 (ex. number: 123, remainNum : 45)
    public static String getRemainNumber(String number) {
        String remainNum = num;
        char[] curNums = number.toCharArray();
        for (int i=0; i<curNums.length; i++) {
            if (remainNum.indexOf(curNums[i]) != -1) {
                String s = Character.toString(curNums[i]);
                remainNum = remainNum.replaceFirst(s, "");
            }
        }

        return remainNum;
    }

    // 중요한 부분 중 하나 에라토스테네스의 체 활용하여 소수 구하기.
    public static int countPrimeNumber(List<Integer> numbers, int untilNum) {
        boolean[] eratos = new boolean[numbers.get(numbers.size()-1)+1];
        int answer = 0;

        for (int i=2; i<=untilNum; i++) {
            if (!eratos[i])
                continue;
            for(int j=i+i; j<eratos.length; j+=i) {
                eratos[j] = true;
            }
        }

        for(int i=0; i<eratos.length; i++) {
            if(!eratos[i]) {
                if(numbers.contains(i) && i > 1) {
                    System.out.print(i + " ");
                    answer += 1;
                }
            }
        }



        return answer;

    }
}
