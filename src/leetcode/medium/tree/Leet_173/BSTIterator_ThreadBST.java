package leetcode.medium.tree.Leet_173;

import leetcode.TreeNode;


/*
* Threaded Binary tree를 이용한 중위 순회
* */

public class BSTIterator_ThreadBST {

    private TreeNode cur;

    public BSTIterator_ThreadBST(TreeNode root) {
        this.cur = root;
        init();
    }

    private void init() {
        TreeNode current = cur;
        TreeNode prev;

        while (current != null) {

            if (current.left != null) {
                prev = current.left;

                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    current = current.right;
                }

            } else {
                current = current.right;
            }
        }

        while (cur != null && cur.left != null) {
            cur = cur.left;
        }

    }

    public int next() {
        int result = cur.val;

        TreeNode next = cur.right;
        if (next == null) {
            cur = null;
        } else if (next.left == null || next.left.val > cur.val) {
            cur = next;
            while(cur.left != null) {
                cur = cur.left;
            }
        } else {
            cur.right = null;
            cur = next;
        }


        return result;
    }

    public boolean hasNext() {
        return cur != null;
    }



}
