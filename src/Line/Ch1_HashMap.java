package Line;

import java.util.*;

public class Ch1_HashMap {
    public static void main(String[] args) {
        String inputString = "([)]<<(>)>";

        System.out.println(solution(inputString));
    }

    static int solution(String inputString) {
        int answer = 0;
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');

        ArrayList<Character> list = new ArrayList<>();

        for (char c : inputString.toCharArray()) {
            if (brackets.containsValue(c)) {
                list.add(c);
            } else if (brackets.containsKey(c)) {
                if (list.contains(brackets.get(c))) {
                    list.remove(brackets.get(c));
                    answer ++;
                } else {
                    return -1;
                }
            }
        }

        return answer;
    }
}
