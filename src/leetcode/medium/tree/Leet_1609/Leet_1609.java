package leetcode.medium.tree.Leet_1609;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet_1609 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(10);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(12);
//        root.left.left.right = new TreeNode(8);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);
//        root.right.left.left = new TreeNode(6);
//        root.right.right.right = new TreeNode(2);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);


        System.out.println(isEvenOddTree(root));

    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        return traversal(nodeQueue, 0);
    }

    private static boolean traversal(Queue<TreeNode> nodeQueue, int level) {
        int queueSize = nodeQueue.size();
        if (queueSize == 0) {
            return true;
        }

        int last = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        boolean isValid = true;
        for (int i=0; i<queueSize; i++) {
            TreeNode curNode = nodeQueue.poll();
            int curValue = curNode.val;

            if (level % 2 == 0) {
                if (curValue % 2 != 0 && curValue > last) {
                    addQueue(nodeQueue, curNode);
                    last = curValue;
                } else {
                    isValid = false;
                    break;
                }

            } else {
                if (curValue % 2 == 0 && curValue < last) {
                    addQueue(nodeQueue, curNode);
                    last = curValue;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            return traversal(nodeQueue, level + 1);
        } else {
            return false;
        }

    }

    private static void addQueue(Queue<TreeNode> queue, TreeNode curNode) {
        if (curNode.left != null)
            queue.add(curNode.left);
        if (curNode.right != null)
            queue.add(curNode.right);
    }

}
