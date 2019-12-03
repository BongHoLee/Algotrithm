package Programmers;


import sun.security.x509.SerialNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Level2_FindPrimeNumber {
    public static String num = "";

    public static void main(String[] args) {

        solution("123");
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
        System.out.println(numSet);
        return answer;
    }

    public static void setNumbers(int start, int end, String number, Set<Integer> numSet) {
       // if (numSet.contains(Integer.parseInt(number))) {
      //      return;
      //  } else if (start > end) {
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

    public static String getRemainNumber(String number) {
        String tmpNum = num;
        char[] numberToArr = number.toCharArray();
        for (int i=0; i<numberToArr.length; i++) {
            if (tmpNum.indexOf(numberToArr[i]) != -1) {
                String s = Character.toString(numberToArr[i]);
                tmpNum = tmpNum.replaceFirst(s, "");
            }
        }

        return tmpNum;

    }
}
