package leetcode.Leet_1609;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 재귀가 아닌 while loop를 이용한 풀이
// 시간복잡도는 같지만 실제 수행 시간은 확연히 차이가 있더라(leetcode 기준)
public class Leet_1609_Others {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);



        System.out.println(isEvenOddTree(root));

    }
    public static boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;

        while(q.size() > 0) {
            int size = q.size();
            int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE; // init preVal based on level even or odd

            while(size-- > 0) { // level by level

                root = q.remove();
                if(even && (root.val % 2 == 0 || root.val <= prevVal)) return false; // invalid case on even level
                if(!even && (root.val % 2 == 1 || root.val >= prevVal)) return false; // invalid case on odd level
                prevVal = root.val; // update the prev value

                if(root.left != null) q.add(root.left); // add left child if exist
                if(root.right != null) q.add(root.right); // add right child if exist

            }
            even = !even; // alter the levels
        }

        return true;
    }
}
