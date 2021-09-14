package leetcode.Leet_113;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet_113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);


        System.out.println(pathSum(root, -5));

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            isTargetSum(root, list, new ArrayList<>(), 0, targetSum);
        }

        return list;
    }

    private static boolean isTargetSum(TreeNode curNode, List<List<Integer>> list, List<Integer> curList, int curSum, int targetSum) {
        curSum += curNode.val;
        List<Integer> copiedList = new ArrayList<>(curList);
        copiedList.add(curNode.val);
        // is leaf
        if (curNode.left == null && curNode.right == null) {
            if (curSum == targetSum) {
                list.add(copiedList);
                return true;
            } else {
                return false;
            }
        }

        if (curNode.left != null) {
            isTargetSum(curNode.left, list, copiedList, curSum, targetSum);
        }

        if (curNode.right != null) {
            isTargetSum(curNode.right, list, copiedList, curSum, targetSum);
        }

        return true;
    }

}
