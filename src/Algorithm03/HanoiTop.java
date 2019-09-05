package Algorithm03;

// 하노이탑의 패턴
// n개의 원판을 옮길 시
// 1. n-1개를 other로 옮긴다.
// 2. n번째 (맨 아래) 원판을 to(목적지)로 옮긴다.
// 3. other로 옮겼던 n-1개의 원판을 n번쨰 원판의 위(to)로 옮긴다.


public class HanoiTop {
    public static void main(String[] args) {
        move(5, 1, 3, 2);
    }


    static void move(int n, int from, int to, int other){
        // n : 원판의 개수.
        // from : 시작 기둥
        // to : 목적기 기둥
        // other : 그 외 거쳐가는 기둥.
        if(n < 1) return;

        // n-1개의 원판을 other로 옮긴다.
        move(n-1, from, other, to);

        // 마지막 n번째 원판을 to로 옮긴다 (출력)
        System.out.println("[ " + n + "] 번째 원판을 " + from + " 에서 " + to + "로 이동");

        // other로 옮겼던 n-1개의 원판을 to로 옮긴다
        move(n-1, other, to, from);


    }


}
