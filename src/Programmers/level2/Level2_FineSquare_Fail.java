package Programmers.level2;

public class Level2_FineSquare_Fail {
    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }

    public static long solution(int w, int h) {
        long answer = w == h ? w : (w*h) - sliceSquare(1, w, h);
        return answer;
    }

    private static long sliceSquare(long count, long w, long h) {
        if (w%2 != 0 || h%2 != 0) {
            return count * (w + h - 1);
        } else {
            return sliceSquare(count*2, w/2, h/2);
        }
    }

}
