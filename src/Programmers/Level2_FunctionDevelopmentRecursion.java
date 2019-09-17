package Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42586


/*
*
*  Recursion으로 구현해보고 싶었어요.
*  BaseCase를 생각하자구요.
*  수학적 귀납법도 생각합시다요 (f(n) = n + f(n-1))
* */

import java.util.Arrays;

public class Level2_FunctionDevelopmentRecursion {
    public static void main(String[] args) {
        int[] progress = {93,30,55};
        int[] speeds = {1,30,5};

       int[] result =  solution(progress, speeds);
        System.out.println(Arrays.toString(result));
    }

    public static  int[] solution(int[] progress, int[] speeds) {

        Stackk answer = new Stackk(new int[0]);
        Stackk progressStackk = new Stackk(progress);
        Stackk speedStackk = new Stackk(speeds);

        while(progressStackk.size() > 0) {
            int count = 0;
            count += countSuccess(progressStackk, speedStackk, count);
            if(count > 0)
                answer.push(count);

        }

        return answer.getStackArray();
    }

    // recursion 메서드.
    // progress가 100 이상이 되는 요소들을 반환한다.
    public static int countSuccess (Stackk progress, Stackk speeds, int count) {
        if(progress.size() > 0) {
            int topValue = progress.get(0);
            if(topValue >= 100) {
                count += 1;
                progress.pop();
                speeds.pop();
                count += countSuccess(progress, speeds, 0);
            } else {
                for (int i = 0; i< progress.size(); i++) {
                    int tmp = progress.pop();
                    tmp += speeds.get(i);
                    progress.push(tmp);
                }
            }

        }
        return count;
    }


}

// 필요한 스택을 배열로 직접 구현하자.
class Stackk {
    private int[] stackArr;

    public Stackk(int[] arr) {
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
