package Programmers.level2;

import java.util.PriorityQueue;

/*
*  힙을 이용한 알고리즘 문제풀이.
*  1. 힙은 완전이진트리로 구현된 자료구조로써 우선순위 큐를 위해 사용되어진다.
*  2. 힙은 느슨한 정렬상태를 유지한다 (부모노드 >= 자식노드)
*  3. 왼쪽 자식노드 인덱스 = 부모노드인덱스 * 2
*  4. 오른쪽 자식노드 인덱스 = (부모노드인덱스 * 2) + 1
*
*  우선적으로 우선순위 큐를 이용하여 문제를 풀어보자.
* */
public class Level2_Scovil {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scovilles, int K) {
        int mixCount = 0;
        int answer = -1;
        PriorityQueue<Integer> priorityScoville = new PriorityQueue<>();
        int firstScoville = 0;
        int secondScoville = 0;

        for (int scovill : scovilles)
            priorityScoville.offer(scovill);

        //mixCount = mixScoville(priorityScoville, K, 0);

        while (priorityScoville.size() > 1) {
            if (priorityScoville.peek() >= K) {
                answer = mixCount;
                break;
            }

            firstScoville = priorityScoville.poll();
            secondScoville = priorityScoville.poll();
            priorityScoville.offer(firstScoville + (secondScoville*2));
            mixCount += 1;
        }

        if (priorityScoville.peek() >= K)
            answer = mixCount;
        return answer;
    }

    private static int mixScoville(PriorityQueue<Integer> priorityScoville, int K, int answer) {
        if (priorityScoville.size() == 1) {
            if (priorityScoville.poll() >= K)
                return answer;
            else
                return -1;
        } else if (priorityScoville.size() == 0) {
            return answer;
        } else {
            if (priorityScoville.peek() >= K)
                return answer;
            else {
                int firstScoville = priorityScoville.poll();
                int secondScoville = priorityScoville.poll();
                int mixedScovill = firstScoville + (secondScoville * 2);

                priorityScoville.offer(mixedScovill);
                return mixScoville(priorityScoville, K,answer + 1);
            }
        }
    }

}
