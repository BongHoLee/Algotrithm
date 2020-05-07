package Programmers.level2;

import java.util.*;


/*
*
*  너무 어렵게 생각했음 (사실 가장 직관적으로 생각했음..)
*  구현력이 역시 부족해서 실제 구현도 하지 못했다는 함정.. (이걸로 풀어보자)
*  이걸 구현해서 구현력을 높여보자.
*
*  풀려는 방향은 막대기를 list로 추상하고 레이저는 L로 추상해서 [[[L,L],[L]]] 이런식으로 변환
*  그리고 재귀로 각 list 요소가 L을 담고있으면 그 개수 + 1 만큼 구함
*
*  부딪힌 부분은 위의 구조로 변환하려는 과정에서 '('를 만나면 리스트를 생성하고 'L'을 만나면 생성한 리스트에 삽입,
*  ')'를 만나면 가장 최근에 생성한 List 닫기 순으로 진행하려고 함.
*
*  실제 접근법이 나쁘다기 보다는 구현력이 조금 부족했던 문제이므로 다시 한번 도전해보자.
*
* */

public class Level2_StillStick_FAIL {
    public static void main(String[] args) {
        String str = "()(((()())(())()))(())";
        solution(str);

    }

    public static int solution(String arrangement) {
        int answer = 0;
        Queue<Character> arrangeQ = new LinkedList<>();
        Queue<Object> resultQ = new LinkedList<>();
        arrangement = arrangement.replace("()", "L");

        for(int i=0; i<arrangement.length(); i++)
            arrangeQ.add(arrangement.charAt(i));

        while(arrangeQ.size() > 0) {

            char tmp = arrangeQ.poll();
            if(tmp == '(') {
              List stick = new ArrayList();
              stick.add(makeContents(arrangeQ, 1, stick));
              resultQ.add(stick);
            } else {
                resultQ.add(tmp);
            }

        }

        System.out.println(arrangement);
        System.out.println(resultQ);


        return answer;
    }

    public static List makeContents(Queue<Character> arrangeQ, int pos, List stick) {
        if(pos > 0) {

            char tmp = arrangeQ.poll();
            if(tmp == '(') {
                List nextStick = new ArrayList();
                stick.add(makeContents(arrangeQ, pos+1, nextStick));
                return stick;
            } else if (tmp == 'L') {
                stick.add('L');
                return makeContents(arrangeQ, pos, stick);
            } else if (tmp == ')') {
                return makeContents(arrangeQ, pos-1, stick);
            }

        }
        return stick;

    }




}


