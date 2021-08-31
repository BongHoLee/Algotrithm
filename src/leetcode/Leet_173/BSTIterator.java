package leetcode.Leet_173;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    private Queue<TreeNode> iteratorQueue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    public int next() {
        if (iteratorQueue.isEmpty()) {
            return -1;
        } else {
            return iteratorQueue.poll().val;
        }
    }

    public boolean hasNext() {
        return !iteratorQueue.isEmpty();
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }

        iteratorQueue.add(node);

        if (node.right != null) {
            inOrder(node.right);
        }
    }
}
