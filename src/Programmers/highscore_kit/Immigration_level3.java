package Programmers.highscore_kit;

import java.util.Arrays;

/**
 * 이분 탐색 문제
 * 시간에 대한 이분 탐색을 하는것이 포인트다.
 * 이 부분을 캐치하지 못해 블로그를 참고했다.
 */
public class Immigration_level3 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(new Immigration_level3().solution(n, times));
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long peoples = n;
        long left = 1;
        long right = times[times.length - 1] * peoples;


        while (left <= right) {
            long timeLimit = (left + right) / 2;

            if (doneInTime(peoples, times, timeLimit)) {
                answer = timeLimit;
                right = timeLimit - 1;
            } else {
                left = timeLimit + 1;
            }

        }

        return answer;
    }

    // 이부분 계산이 조금 신경써야함.
    // 아마 방향을 몰랐다면 이부분에서 '이렇게 푸는게 아니다'라는 생각으로 시간을 허비했을 듯?
    // 각 time 별로 timeLimit 내에 몇 명을 통과시킬 수 있는지 구해야함.
    // 그리고 통과시킬 수 있는 수가 peoples보다 크다면 시간을 더 단축시킬 수 있는것이고 작다면 시간이 더 필요하다는 의미
    private boolean doneInTime(long peoples, int[] times, long timeLimit) {
        for (int time : times) {
            // time 별로 timeLimit 내에 통과시킬 수 있는 사람의 수를 감산해준다.
            peoples = peoples - (timeLimit/time);

            if (peoples <= 0) {
                break;
            }
        }

        return peoples <= 0;
    }
}
