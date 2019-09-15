package Backjoon;

// 백준 알고리즘 재귀 문제 - 1019번
// 수학적 접근이 필요.

// A ~ B 까지의 페이지일 때
// A++ => 마지막 수가 9, B-- => 마지막 수가 0이 되도록 해주고.
// (B/10 - A/10 + 1) * (자릿수) 을 해주면 각 페이지에서 나타나는 수를 구할 수 있다.

// N%10 => 1의 자리 , N/10 => 1의 자리를 제외한 나머지 수
// ex (1158 % 10 == 5), (1158 / 10 == 115)


import java.io.*;

//백준 1019
public class BookPage {


    static void plus(int end, int jari, int[] numbers) {
        while(end > 0) {
            numbers[end%10]+=jari;
            end/=10;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int end = Integer.parseInt(br.readLine());          // 총 페이지 수
        int[] numbers = new int[10];                        // 0 ~ 9의 횟수
        int jari = 1;                                       // 페이지의 자릿수
        int start = 1;                                      // 시작 페이지 수

        while(end >= start) {

            // 마지막 페이지의 1의 자리를 9로 맞출때 까지 end-- 로 해준다.
            // 또한 그에 따라 제외된 페이지를 고려하여 plus를 통해 numbers를 갱신한다.
            while(end%10 != 9 && end >= start) {
                plus(end, jari, numbers);
                end--;
            }

            if(start > end) {
                break;
            }

            while(start%10 != 0 && end >= start) {
                plus(start, jari, numbers);
                start++;
            }

            end /=10;
            start /=10;

            for(int i =0;i<=9;i++) {
                numbers[i] += (end-start +1)*jari;
            }

            jari*=10;
        }
        for(int i=0;i<=9;i++) {
            System.out.print(numbers[i] + " ");
        }

    }

}
