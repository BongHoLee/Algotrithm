package Algorithm02;

public class FindMax {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10};
        int result = findMax(data, 0, data.length-1);
        System.out.println(result);


    }

    public static int findMax(int[] data, int begin, int end) {
        if (begin == end) return data[begin];
        else {
            return Math.max(data[begin], findMax(data, begin+1, end));
        }
    }

}
