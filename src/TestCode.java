import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        String s = "cdcd";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (stack.empty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();
        }

        return stack.empty() ? 1 : 0;

    }

}
