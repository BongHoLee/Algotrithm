package leetcode.Leet_173;

import leetcode.TreeNode;

public class BSTIteratorMain {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        BSTIterator bst = new BSTIterator(root);

        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
    }
}
