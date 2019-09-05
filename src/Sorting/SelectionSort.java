package Sorting;

// 선택 정렬 - Selection Sort 알고리즘
// 가장 큰 값을 찾아서 last 위치로 보냄
// 그리고 1 ~ last-1 까지의 배열을 대상으로 다시 시작.
// 모든 경우에 대해서 반복하기 때문에 최선/평균/최악 모두 O(n^2) 의 시간복잡도가 발생


import java.sql.SQLOutput;
import java.util.Arrays;

public class SelectionSort {


    static int[] arr = {2, 3, 1, 4, 5, 8, 7, 6};

    public static void main(String[] args) {
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void selectSort(int array[]){
        int last = array.length - 1;
        for(int i=last; i>0; i--) {

            int max = i;
            for(int j=i-1; j>=0; j--) {
                if(array[max] < array[j])
                    max = j;
            }

            int tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;


        }

    }

}
