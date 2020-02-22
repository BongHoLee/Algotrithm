package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_Words {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {
	            "hello", "one",
                "even", "never",
                "now", "world", "draw"
        };



        System.out.println(Arrays.toString(solution(n, words)));

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> used = new ArrayList<>();
        used.add(words[0]);

        for (int i=1; i<words.length; i++) {
            String word = words[i];

            if (used.contains(word) ||  used.get(i-1).charAt(used.get(i-1).length() -1) != word.charAt(0)) {
                answer = checkOut(answer, i, n);
                break;
            }

            used.add(word);
        }

        return answer;
    }

    public static int[] checkOut(int[] answer, int i, int n) {
        answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
        answer[1] = (i + 1) % n == 0 ? (i + 1)/n : (i + 1)/n + 1;

        return answer;
    }


}
