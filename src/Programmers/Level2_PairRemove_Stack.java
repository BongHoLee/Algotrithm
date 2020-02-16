package Programmers;

import java.util.Stack;

public class Level2_PairRemove_Stack {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i=0; i<charArray.length; i++) {
            if (!stack.isEmpty() && stack.peek() == charArray[i])
                stack.pop();
            else
                stack.push(charArray[i]);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
