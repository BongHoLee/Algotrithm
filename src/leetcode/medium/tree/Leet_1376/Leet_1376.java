package leetcode.medium.tree.Leet_1376;

// Tag : Tree
// Difficulty : Medium
// manager[i]는 i의 매니저이다.
// manager[headID] = -1 (head의 매니저는 -1)

// i번째 사람은 informTime[i] 시간이 필요하다 모든 그의 직속 부하들에게 전달하기 위해
// informTIme[i] 시간 뒤에 그의 직속 부하들은 뉴스를 전파할 수 있다.
// 모든 사람들에게 뉴스가 전파되기 위해 필요한 시간을 구하세요

// index, value가 employee : manager 관계
// BFS로 풀어야하나? 이거 트리 맞음?


// 내 풀이 : leaf 노드에서 부터 bottom-up 방식으로 search (트리에서 경로는 단 한개임을 이용)
// 이렇게 하면 어떨까

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 개발자의 가정을 이해하기 힘듦(내가 짰지만 다시봐도 이해하기가 힘듦)
public class Leet_1376 {
    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};

        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }


    static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        boolean[] isVisited = new boolean[n];
        int[] visitSum = new int[n];
        List<Integer> leafNode = IntStream.range(0, informTime.length).boxed()
                .filter(idx -> informTime[idx] == 0)
                .collect(Collectors.toList());

        int max = 0;
        for (int nextVisitNode : leafNode) {
            boolean visitHead = false;

            Map<Integer, Integer> idxValue = new HashMap<>();
            Stack<Integer> idxStack = new Stack<>();
            while (!visitHead) {
                int managerIdx = manager[nextVisitNode];

                if (managerIdx == -1) {
                    visitHead = true;
                    break;
                }

                if (!isVisited[managerIdx]) {
                    idxValue.put(managerIdx, informTime[managerIdx]);
                    idxStack.push(managerIdx);
                    nextVisitNode = managerIdx;
                } else {
                    idxValue.put(managerIdx, visitSum[managerIdx]);
                    idxStack.push(managerIdx);
                    visitHead = true;
                    break;
                }
            }

            int toLeafSum = 0;
            while (!idxStack.isEmpty()) {
                int visitIdx = idxStack.pop();

                if (!isVisited[visitIdx]) {
                    isVisited[visitIdx] = true;
                    toLeafSum += informTime[visitIdx];
                    visitSum[visitIdx] = toLeafSum;
                } else {
                    toLeafSum += visitSum[visitIdx];
                }
            }

            max = Math.max(max, toLeafSum);

        }

        return max;
    }
}
