package leetcode;

public class Leet_101 {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode root = new TreeNode(1);
        TreeNode e2 = new TreeNode(2);
        TreeNode e3 = new TreeNode(3);
        e2.setRight(e3);
        TreeNode ee2 = new TreeNode(2);
        TreeNode ee3 = new TreeNode(3);
        ee2.setRight(ee3);

        root.setLeft(e2);
        root.setRight(ee2);

        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        } else {
            return false;
        }
    }
}
