package leetcode;

// 배열로 주어졌을 때도 풀어보기.
// 배열인 경우 인덱스 간의 상관 관계가 Tree의 특징을 갖고 있는것 같아.(서치해서 찾아보기)

public class Leet_951 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode e2 = new TreeNode(2);
        TreeNode e3 = new TreeNode(3);
        TreeNode e4 = new TreeNode(4);
        TreeNode e5 = new TreeNode(5);
        TreeNode e6 = new TreeNode(6);
        TreeNode e7 = new TreeNode(7);
        TreeNode e8 = new TreeNode(8);

        root1.setLeft(e2);
        root1.setRight(e3);
        e2.setLeft(e4);
        e2.setRight(e5);
        e5.setLeft(e7);
        e5.setRight(e8);
        e3.setLeft(e6);

        TreeNode root2 = new TreeNode(1);
        TreeNode ee2 = new TreeNode(2);
        TreeNode ee3 = new TreeNode(3);
        TreeNode ee4 = new TreeNode(4);
        TreeNode ee5 = new TreeNode(5);
        TreeNode ee6 = new TreeNode(6);
        TreeNode ee7 = new TreeNode(7);
        TreeNode ee8 = new TreeNode(8);

        root2.setLeft(ee3);
        root2.setRight(ee2);
        ee3.setRight(ee6);
        ee2.setLeft(ee4);
        ee2.setRight(ee5);
        ee5.setLeft(ee8);
        ee5.setRight(ee7);

        System.out.println(solution(root1, root2));
    }

    static boolean solution(TreeNode root1, TreeNode root2) {
        return isEquiv(root1, root2);
    }

    static boolean isEquiv(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else {
            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            } else {



                return ((isEquiv(node1.left, node2.right) && isEquiv(node1.right, node2.left) || isEquiv(node1.left, node2.left) && isEquiv(node1.right, node2.right)) );
            }

        }
    }


}

