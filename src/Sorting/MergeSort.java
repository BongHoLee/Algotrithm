package Sorting;

// 분할정복법의 전략을 사용한 Merge sort를 구현
// Merge sort
// 1. 데이터가 저장된 배열을 절반으로 나눔
// 2. 각각을 순환적으로 정렬.
// 3. 정렬된 두 개의 배열을 합쳐 전체를 정렬.
// 2개의 정렬된 배열을 하나의 정렬된 배열로 만드는 Merge 과정이 가장 중요함.

// 각각 정렬된 리스트를 하나로 합치기 위해서는 '추가 리스트' 가 필요함.


// 1. 분할 : 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할.
// 2. 정복 : 각각의 작은 문제를 순환적(recursively) 해결
// 3. 합병 : 작은 문제의 해를 합하여 원래의 문제의 해를 구함.

// 전체의 문제를 해결하는 것과 동일한 방법으로 작은 문제를 해결.
// 분할 정복법은 본질적으로 재귀를 사용.


import java.util.Arrays;

public class MergeSort {
    static int[] data = {1, 4, 2, 6, 9, 29 , 2, 3, 5, 6, 8, 7};
    public static void main(String[] args) {
        int endIdx = data.length - 1;
        mergeSort(data, 0, endIdx);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[] A, int startIdx, int endIdx) {

        // startIndex 가 endIndex보다 커야 의미가 있음.
        if(startIdx < endIdx) {
            int middleIdx = (startIdx + endIdx) / 2;
            mergeSort(A, startIdx, middleIdx);              // 전반부 정렬.
            mergeSort(A, middleIdx + 1, endIdx);    // 후반부 정렬.
            merge(A, startIdx, middleIdx, endIdx);          // 각 정렬된 리스트 합병
        }

    }

    // 마지막 첫 리스트 0 / 0 / 1
    // [4,1]
    public static void merge(int[] A, int startIdx, int middleIdx, int endIdx) {
        int s = startIdx;
        int m = middleIdx + 1;
        int k = startIdx;
        int tmp[] = new int[A.length];                  // 추가 배열.

        while(s <= middleIdx && m <= endIdx) {
            if(A[s] <= A[m]) {
                tmp[k] = A[s];
                k += 1;
                s += 1;
            } else {
                tmp[k] = A[m];
                 k += 1;
                 m += 1;
            }
        }

        while(s <= middleIdx) {
            tmp[k] = A[s];
            k += 1;
            s += 1;
        }

        while(m <= endIdx) {
            tmp[k] = A[m];
            k += 1;
            m += 1;
        }

        for(int i=startIdx; i<=endIdx; i++) {
            A[i] = tmp[i];
        }
    }




}
