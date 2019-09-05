package Algorithm02;

public class RecursionMiddleSearch {
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10};
        int target = 19;
        int result = search(data, 0, data.length-1, target);

        //begin : 0, end : 9(n-1)
        System.out.println(result);

    }

    public static int search(int[] data, int begin, int end, int target) {
        if(begin > end) return -1;
        else {

            int middle = (begin + end)/2;
            if (data[middle] == target)
                return middle;

            int index = search(data, begin, middle-1, target);
            if (index != -1)
                return index;
            else
                return search(data, middle+1, end, target);








        }

    }

}
