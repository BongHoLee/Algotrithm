package Algorithm02;

/*
* 기본적인 순차 탐색
* */
public class  Search{
    public static void main(String[] args) {
        int[] data = {2, 3, 1, 5, 4, 8, 9, 11, 19, 10};
        int target = 11;
        int result = search(data, data.length, target);

        System.out.println(result);
    }

    public static int search(int[] data, int n, int target) {
        for(int i=0; i<n; i++) {
            if(data[i] == target) {
                return i;
            }
        }

        return -1;
    }

}
