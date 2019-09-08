package Sorting;

import java.util.Arrays;

public class QuickRecursion {
    public static void main(String[] args) {
        int[] A = {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};

        int result = partition(A, A.length-1, -1, 0, A.length-1);
        System.out.println("===================");
        System.out.println(result);
        System.out.println(Arrays.toString(A));

    }

    public static int partition (int[] A, int pivot, int lastSmallIdx, int searching, int endIdx) {

        //검색 위치가 pivot에 다달으면 모두 검색했으니 return
        if(searching >= pivot-1) {
            int tmp = A[lastSmallIdx + 1];
            A[lastSmallIdx + 1] = A[pivot];
            A[pivot] = tmp;
            return lastSmallIdx + 1;
        } else {

            if(A[pivot] > A[searching]) {
                lastSmallIdx += 1;
                int tmp = A[lastSmallIdx];
                A[lastSmallIdx] = A[searching];
                A[searching] = tmp;
            }

            System.out.println(Arrays.toString(A));
            return partition(A, pivot, lastSmallIdx, searching+1, endIdx);

        }

    }
}
