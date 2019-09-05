package Algorithm02;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10
                     ,21, 24, 50, 32, 18, 29, 40};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        int result = binarySearch(data, 0, data.length-1, 29);
        System.out.println(result);
        System.out.println(data[result]);
    }

    public static int binarySearch(int[] data, int begin, int end, int target) {
        if(begin > end){
            return -1;
        }

        int curIdx = (begin+end)/2;
        if(data[curIdx] == target) {
            return curIdx;
        } else {
            if (data[curIdx] > target) {
                return binarySearch(data, begin, curIdx, target);
            } else {
                return binarySearch(data, curIdx, end, target);
            }
        }


    }
}
