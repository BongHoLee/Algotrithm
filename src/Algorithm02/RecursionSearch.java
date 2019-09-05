package Algorithm02;

public class RecursionSearch {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10};
        int target = 11;
        int result = search(data, 0, data.length - 1, target);

        System.out.println(result);

    }

    public static int search(int[] data, int begin, int end, int target) {
        if(begin > end)
            return -1;
        else if (data[begin] == target)
            return begin;
        else
            return search(data, begin + 1, end, target);
    }

}
