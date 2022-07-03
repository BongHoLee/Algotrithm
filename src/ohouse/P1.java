package ohouse;

public class P1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new P1().solution(arr));
    }

    public int solution(int[] arr) {
        int answer = 0;

        for (int numberPos = 0; numberPos < arr.length; numberPos++) {
            int sum = 0;
            for (int each = numberPos; each < arr.length; each++) {
                sum += arr[each];
                answer += isOdd(sum) ? 1 : 0;
            }
        }

        return answer;
    }

    private boolean isOdd(int number) {
        return number%2 != 0;
    }


}
