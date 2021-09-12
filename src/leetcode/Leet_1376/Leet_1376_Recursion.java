package leetcode.Leet_1376;


// Recursion을 이용한 풀이.
// Top-Down 방식
// manager[]과 informTime[]의 관계를 잘 파악해야함.
public class Leet_1376_Recursion {

    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};

        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }


    static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;

        for (int i=0; i<n; i++) {
            max = Math.max(max, dfs(i, manager, informTime));
        }

        return max;
    }

    static int dfs(int curNodeIdx, int[] manager, int[] informTime) {
        // not visited
        int sumOfInformTime = informTime[curNodeIdx];

        if (manager[curNodeIdx] != -1) {
            sumOfInformTime += dfs(manager[curNodeIdx], manager, informTime);
            informTime[curNodeIdx] = sumOfInformTime;
            manager[curNodeIdx] = -1;
        }

        return sumOfInformTime;

    }

}
