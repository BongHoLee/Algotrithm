package Programmers.level2;


// 재귀 복습

/*
* 50, 25, 10, 5, 1의 개수가 무한정이라고 가정할 때 amount를 만들 수 있는 경우의 수 구하기.
* 여타 재귀의 흐름과 마찬가지로 식을 '정의' 함에 집중한다.
* 즉, f(n-1)이 옳다라는 "믿음"으로 f(n) = n + f(n-1) 식을 세운다.
*
* 아래에서도 마찬가지로 count(amount를 현재동전을 포함하여 계산한 경우의 수) + count(amount를 다음 동전들로 계산한 경우의 수)
* 즉, 현재 동전을 포함하여 계산한 경우의 수는 n, 다음 동전들로 계산한 경우의 수는 f(n-1)이 되겠다.
*
* */

public class CentsCounts {
    public static int cents[] = {50, 25, 10, 5, 1};
    public static void main(String[] args) {
        System.out.println(count(6));

    }

    public static int count(int amount) {
        return count(amount, 0);
    }

    public static int count(int amount, int idx) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || idx >= cents.length)
            return 0;
        else
            return count(amount - cents[idx], idx) + count(amount, idx+1);
    }

}
