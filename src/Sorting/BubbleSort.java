package Sorting;

import java.util.Arrays;
import java.util.List;


// bubble sort
// 고기몰기 식으로 pos와 pos + 1 (j) 를 비교
// pos보다 pos + 1이 더 작다면 교환 (오름차순일시)
// 비교와 교환을 통해 맨 마지막에는 가장 큰 수가 위치
//

public class BubbleSort {
    static Integer[] arr = {2, 3, 59, 28, 1, 4,12, 81,  5, 12, 8, 87, 56};;
    public static void main(String[] args) {
        bublleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bublleSort(Integer[] arr) {
        int last = arr.length-1;

        for(int i=last; i>0; i--) {
            int pos = 0;
            for(int j=1; j<=i; j++) {
                if(arr[pos] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[pos];
                    arr[pos] = tmp;
                    pos = j;
                } else {
                    pos = j;
                }
                 List<Integer> tmp=  Arrays.asList(arr);
                System.out.println(tmp);
            }
        }
    }
}
