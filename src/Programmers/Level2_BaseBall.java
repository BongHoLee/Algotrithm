package Programmers;

import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Level2_BaseBall {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));

    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        List<String> tmp = new ArrayList<>();

        Stack<String> baseballBox = new Stack<>();
        permutation(baseballBox, 10, 1, 3);

        while(!baseballBox.isEmpty()) {
            String baseNumber = baseballBox.pop();

            if (check(baseNumber, baseball, 0, baseball.length)) {
                answer +=1;
                tmp.add(baseNumber);
            }

        }

        //System.out.println(tmp);
        return answer;
    }

    // 순열을 구하기 위한 Recursion 함수
    private static void permutation(Stack<String> permStack, int toLen, int depth, int toDepth) {

        String perm = permStack.isEmpty() ? "" : permStack.pop();

        for (int i = 1; i < toLen; i++) {
            if (perm.contains(Integer.toString(i)))
                continue;

            String nextPerm = perm + i;
            permStack.push(nextPerm);

            if (depth < toDepth)
                permutation(permStack, toLen, depth+1, toDepth);
        }
    }

    // 각 baseNumber(스택에 저장된 전체 경우)가 주어진 baseball과 비교했을때 후보가능 여부 체크
    private static boolean check(String baseNumber, int[][] baseball, int pos, int toLen) {
        if (pos >= toLen)
            return true;
        else {
            String target = Integer.toString(baseball[pos][0]);
            int targetStrike = baseball[pos][1];
            int targetBall = baseball[pos][2];

            if ((targetStrike == getStrike(baseNumber, target)) && (targetBall == getBall(baseNumber, target)))
                return check(baseNumber, baseball, pos+1, toLen);
            else
                return false;

        }
    }

    private static int getStrike(String baseNumber, String target) {
        int strike = 0;

        char[] baseNumbers = baseNumber.toCharArray();
        char[] targets = target.toCharArray();

        for (int i=0; i<baseNumbers.length; i++) {
            char baseC = baseNumbers[i];
            char targetC = targets[i];
            if (baseC == targetC)
                strike += 1;
        }

        return strike;
    }

    private static int getBall(String baseNumber, String target) {
        int ball = 0;
        char[] baseNumbers = baseNumber.toCharArray();
        char[] targets = target.toCharArray();

        for (int i=0; i<baseNumbers.length; i++) {
            char baseC = baseNumbers[i];

            for (int j=0; j<targets.length; j++) {
                char targetC = targets[j];
                if (i == j) continue;
                if (targetC == baseC) {
                    ball += 1;
                    break;
                }


            }
        }
        return ball;
    }


}

