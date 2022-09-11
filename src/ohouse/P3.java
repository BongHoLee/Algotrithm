package ohouse;


/**
 * 시간 제한으로 풀지 못함 ㅠㅠ
 * 2번에 시간 소요를 너무 많이했다.
 */

public class P3 {
    public static void main(String[] args) {

    }


    public int solution(String word) {
        return 0;
    }
}

class EachKey {
    int x;
    int y;

    public EachKey(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcDistanceWith(EachKey other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}
