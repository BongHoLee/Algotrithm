package leetcode.medium.tree.Leet_113;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet_113_Others {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        int curSum = 0;
        backtracking(root, targetSum, res, curList, curSum);
        return res;
    }

    public void backtracking(TreeNode root, int targetSum, List<List<Integer>> res, LinkedList<Integer> curList, int curSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && curSum + root.val == targetSum) {
            curList.addLast(root.val);
            res.add(new ArrayList<Integer>(curList));
            curList.removeLast();
            return;
        }

        if (root.left != null) {
            curList.addLast(root.val);
            backtracking(root.left, targetSum, res, curList, curSum + root.val);
            curList.removeLast();
        }
        if (root.right != null) {
            curList.addLast(root.val);
            backtracking(root.right, targetSum, res, curList, curSum + root.val);
            curList.removeLast();
        }
    }
}
