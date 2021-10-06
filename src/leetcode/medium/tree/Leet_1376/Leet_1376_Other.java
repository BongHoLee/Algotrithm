package leetcode.medium.tree.Leet_1376;

// root node부터 내려오는 TOP-DOWN 방식
// manager[]과 informTime[]의 관계를 잘 파악해야함.
public class Leet_1376_Other {
    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};

        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int res = 0;
        for (int i = 0; i < n; i++){
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    static  int dfs(int i, int[] manager, int[] informTime) {

        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}
