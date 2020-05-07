package Programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



/*
*
* 다른 사람의 접근 방법을 참고함.
* 실제로 접근 방법 자체는 상당히 간단 (패턴이 존재) Queue/Stack 문제인 이유가 있었음.
*
* 아쉬운 점은 직관적으로 패턴을 파악하지 못했다는 점.
*
* */

public class Level2_StillStick {
    public static void main(String[] args) {
        String str = "()(((()())(())()))(())";
        System.out.println(solution(str));

    }

    public static int solution(String arrangement) {
        Queue<Character> arrangeQueue = new LinkedList<>();
        arrangement = arrangement.replace("()", "L");

        for(int i=0; i<arrangement.length(); i++)
            arrangeQueue.add(arrangement.charAt(i));

        int answer = 0;
        int newStick = 0;
        int stick = 0;

        while(arrangeQueue.size() > 0) {

            char pollVal = arrangeQueue.poll();
            if(pollVal == '(') {
                newStick += 1;
                stick += 1;
            } else if (pollVal == 'L') {
                answer = answer + newStick + stick;
                newStick = 0;
            } else if (pollVal == ')') {
                stick -= 1;
            }

        }


        return answer;
    }





}


