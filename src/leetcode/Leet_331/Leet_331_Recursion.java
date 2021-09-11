package leetcode.Leet_331;

public class Leet_331_Recursion {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] orders = preorder.split(",");

        int treeSize = orders.length - 1;
        int curPos = 0;
        curPos = searchRecursively(orders, curPos, treeSize);

        return curPos == treeSize;
    }

    private static int searchRecursively(String[] orders, int curPos, int treeSize) {
        // base case
        // 현재 말단 노드이거나 전체 순회를 다했으면 순회 종료
        if (curPos > treeSize || orders[curPos].equals("#")) {
            return curPos;
        }

        // left subtree
        int leftSubtreeEndedPos = searchRecursively(orders, curPos + 1, treeSize);

        // right subtree
        int rightSubtreeEndedPos = searchRecursively(orders, leftSubtreeEndedPos + 1, treeSize);

        return rightSubtreeEndedPos;
    }


}

