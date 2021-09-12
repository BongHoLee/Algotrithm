package Programmers.level2;

// Greedy 알고리즘

public class Level2_Joistick {
    public static void main(String[] args) {
        String name = "BBBBAAAABA";
        //String name = "AZAAAZ";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        boolean[] visit = new boolean[name.length()];
        char[] names = name.toCharArray();
        int visitCount = 0;
        int pos = 0;


        // name중 'A'가 있는 위치는 미리 방문 완료 및 방문 횟수를 늘려줌
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) == 'A') {
                visit[i] = true;
                visitCount += 1;
            } else {
                visit[i] = false;
            }
        }

        //
        while (visitCount < visit.length) {

            // 현재 방문한 위치가 첫 방문일 시 조이스틱 위/아래 계산
            if(!visit[pos]) {

                if(names[pos] < 'N')                        // 방문한 곳의 값이 'N'보다 작을 경우 위로 이동 횟수를 더해줌
                    answer += names[pos] - 'A';
                else if (names[pos] > 'N')                  // 방문한 곳의 값이 'N'보다 클 경우 아래로 이동 횟수를 더해줌
                    answer += 'Z' - names[pos] + 1;
                else                                        // 중간 값일 경우 13을 더해줌
                    answer += 13;

                visitCount += 1;                             // 방문 횟수를 더해줌
                visit[pos] = true;                          // 방문 표시를 해줌

            // 현재 방문한 위치가 이미 방문한 곳일 경우
            } else {

                // 왼쪽으로 이동하여 첫 방문한 위치를 찾을 때 까지 이동 횟수
                int lCount = getLpos(visit, pos, 0);

                // 오른쪽으로 이동하여 첫 방문한 위치를 찾을 때 까지 이동 횟수
                int rCount = getRpos(visit, pos, 0);

                if(lCount <= rCount) {
                    pos = getLindex(visit, pos, lCount);
                    answer += lCount;
                } else {
                    pos = getRindex(visit, pos, rCount);
                    answer += rCount;
                }
            }

        }

        return answer;
    }

    //
    public static int getLpos(boolean[] visit, int curPos, int count) {

        if(curPos < 0)
            curPos = visit.length-1;

        if(!visit[curPos])
            return count;
        else {
            return getLpos(visit, curPos - 1, count + 1);
        }

    }

    public static int getRpos(boolean[] visit, int curPos, int count) {

        if(curPos > visit.length - 1)
            curPos = 0;

        if(!visit[curPos])
            return count;
        else {
            return getRpos(visit, curPos + 1, count + 1);
        }

    }

    public static int getLindex(boolean[] visit, int curPos, int count) {

        int idx = curPos - count;

        if(idx < 0)
            idx = visit.length + idx;


        return idx;

    }

    public static int getRindex(boolean[] visit, int curPos, int count) {
        int idx = curPos + count;

        if(idx > visit.length-1)
            idx = idx - visit.length;

        return idx;
    }




}
