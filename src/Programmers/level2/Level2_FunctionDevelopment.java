package Programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42586


/* 모범 답안.

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
* */

import java.util.Arrays;

public class Level2_FunctionDevelopment {
    public static void main(String[] args) {
        int[] progress = {93,30,55};
        int[] speeds = {1,30,5};

       int[] result =  solution(progress, speeds);
        System.out.println(Arrays.toString(result));
    }

    public static  int[] solution(int[] progress, int[] speeds) {

        Stackk answer = new Stackk(new int[0]);
        Stackk progressStack = new Stackk(progress);
        Stackk speedStack = new Stackk(speeds);

        while(progressStack.size() > 0) {
            int count = 0;

            int topValue = progressStack.get(0);

            if(topValue < 100) {
                for (int i=0; i<progressStack.size(); i++) {
                    int tmp = progressStack.pop();
                    tmp += speedStack.get(i);
                    progressStack.push(tmp);
                }
            } else {
                int size = progressStack.size();
                for (int i=0; i<size; i++) {
                    if(progressStack.get(i) >= 100) {
                        progressStack.pop();
                        speedStack.pop();
                        count+=1;
                        i -= 1;
                    } else {
                        break;
                    }
                }

                if(count > 0)
                    answer.push(count);
            }

        }

        return answer.getStackArray();
    }


}

// 필요한 스택을 배열로 직접 구현하자.
class SStack {
    private int[] stackArr;

    public SStack(int[] arr) {
        cloneToStack(arr);
    }

    public int size() {
        return stackArr.length;
    }

    public int pop() {
        int popValue = -1;
        if(stackArr.length > 0) {
            popValue = stackArr[0];
            delStack();
        }

        return popValue;
    }

    private void delStack() {
        int[] tmpStack = new int[stackArr.length - 1];

        for(int i=0; i<tmpStack.length; i++) {
            tmpStack[i] = stackArr[i+1];
        }

        stackArr = tmpStack;
    }

    public int get(int idx) {
        if(idx > stackArr.length - 1) {
            return -1;
        }
        else {
            return stackArr[idx];
        }
    }

    public void push(int pushValue) {
        int[] tmpStack = new int[stackArr.length + 1];

        for(int i=0; i<stackArr.length; i++) {
            tmpStack[i] = stackArr[i];
        }
        tmpStack[stackArr.length] = pushValue;
        stackArr = tmpStack;
    }

    private void cloneToStack(int[] arr) {
        this.stackArr = arr;
    }

    public void print() {
        System.out.println(Arrays.toString(this.stackArr));
    }

    public int[] getStackArray() {
        return this.stackArr;
    }


}
