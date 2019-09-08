package Sorting;


// 분할 정복을 활용하는 Quick sort

// 분할 : 배열을 lower part와 upper part로 나눈다.
// 정복 : 각 부분을 순환적으로 정렬한다.
// 합병 : nothing to do

// pivot이 기준값.
// pivot을 기준으로 더 큰 값 / 더 작은 값 재배치 (partiion 이라고도 함)
// partion 들을 마찬가지로 recursion 으로 quick sorting

// 어떻게 partition을 할 것인가가 중요하다.

// merge sort와 다른점
// merge sort : 작은 값들로 나눈 뒤 정렬 후 병합. (작은 것 들 분할)
// quick sort : 먼저 partion을 나눈 후 나눠진 애들을 다시 partion (큰 것 부터 분할)

// 왼쪽 재배치부터 재귀가 들어가므로 왼쪽부터 모두 재배치 되고 그 이후에 pivot 오른쪽으로 재배치 재귀가 들어감 ^^

// baseCase가 중요하다는 것을 다시금 깨달음
// 또한 프로세스를 끝까지 따라가보는것도 좋지만 귀납적으로 n-1까지 논리적으로 이상 없게끔 식을 구성하는 것이 역시 중요 (믿는다.)
// 재귀는 아직 어렵지만 매력적
// 하면 할수록 조금씩 익숙해져가는것이 느껴짐. 조금씩 더 집중하자.


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {31, 8, 48, 15, 11, 3, 20, 29, 65, 73};
        mergeSort(A, 0, A.length-1);

        System.out.println("=========================");

        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int[] A, int startIdx, int endIdx) {
        if (startIdx < endIdx) {

            //먼저 재배치를 수행한다.
            int pivot = partition(A, startIdx, endIdx);

            //재배치가 완료된 A의 왼쪽(작은 값들) 을 다시 재배치
            mergeSort(A, startIdx, pivot-1);

            //재배치가 완료된 A의 오른쪽 (큰 값들)을 다시 재배치
            mergeSort(A, pivot+1, endIdx);



        }

    }


    // 배열 A[ startIdx ... endIdx ] 을 pivot을 기준으로 작은 값, 큰 값들로 나누고 pivot을 return
    public static int partition(int[] A, int startIdx, int endIdx) {

        // 현재 pivot과 비교해서 작은 값들 중 가장 큰 값의 index
        int lastSmallIdx = startIdx - 1;

        // 배열을 비교할 때 기준이 되는 index(pivot)
        int pivot = endIdx;

        // pivot위치의 값과 비교 대상을 searchIdx로 지정 후 하나씩 비교한다.
        for(int searchIdx=startIdx; searchIdx<endIdx; searchIdx++) {

            // pivot과 비교해서 더 작다면 lastSmallIdx + 1 위치의 값과 교체
            if(A[pivot] > A[searchIdx]) {
                lastSmallIdx += 1;
                int tmp = A[lastSmallIdx];
                A[lastSmallIdx] = A[searchIdx];
                A[searchIdx] = tmp;
            }

        }

        // 기준이 되는 pivot과 큰 값들 중 가장 작은 값 (lastSmallIdx + 1 위치)과 change
        int tmp = A[pivot];
        A[pivot] = A[lastSmallIdx + 1];
        A[lastSmallIdx + 1] = tmp;

        // 교체된 위치를 기준으로 재배치가 되었으니 기준 값을 return
        return lastSmallIdx + 1;
    }


}
