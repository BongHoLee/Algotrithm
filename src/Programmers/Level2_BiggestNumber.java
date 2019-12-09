package Programmers;



import java.util.ArrayList;
import java.util.List;

public class Level2_BiggestNumber {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        //775841
        // 4,1,2,2 제거
        System.out.println(solution(number, k));

    }

    public static String solution(String number, int k) {
        String answer = "";
        int size = number.length() - k;
        List<Integer> nums = new ArrayList<>();
        char[] cs = number.toCharArray();

        for (int i=0; i<number.length(); i++) {
            nums.add((int)cs[i] - 48);
        }

        List<Integer> resultNum = new ArrayList<>();
        searchNum(nums, resultNum, k);

        for (int i=0; i<resultNum.size(); i++)
            answer += resultNum.get(i);
        return answer;
    }

    public static void searchNum(List<Integer> nums, List<Integer> resultNum, int cutoff) {
        if (cutoff <= 0) {
            resultNum.addAll(nums);
            return;
        } else if (nums.size() - cutoff <= 0) {
            return;
        } else {

            int max = 0;
            int idx = 0;
            int toLen = nums.size() - cutoff;

            for (int i=0; i<=cutoff; i++) {
                if (max < nums.get(i)) {
                    max = nums.get(i);
                    idx = i;
                }
            }

            resultNum.add(nums.get(idx));
            cutoff = cutoff - idx;
            nums = nums.subList(idx+1, nums.size());
            searchNum(nums, resultNum, cutoff);
        }

    }


}
