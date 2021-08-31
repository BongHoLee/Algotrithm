package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }
}
