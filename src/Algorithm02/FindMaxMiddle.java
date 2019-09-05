package Algorithm02;

public class FindMaxMiddle {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10, 20, 125, 2, 5, 6, 2, 3, 5, 6, 2, 5, 1, 7, 9, 5, 2, 1};
        int result = findMax(data, 0, data.length-1);
    }

    public static int findMax(int[] data, int begin, int end) {
        if (begin == end)
            return data[begin];                 //base case
        else {
            int middle = (begin + end) / 2;
            int max1 = findMax(data, begin, middle);
            int max2 = findMax(data, middle+1, end);

            return Math.max(max1, max2);
        }
    }
}
