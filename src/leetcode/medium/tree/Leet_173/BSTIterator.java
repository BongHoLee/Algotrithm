package leetcode.medium.tree.Leet_173;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 트리 중위순회
// 첫 번째 내가 직접 구현한 코드

/*
* 중위 순회의 특성상 경로가 (L-V-R)
* 모든 경로를 우선 (Queue)에 저장먼저 진행
* */

// Acceptance가 되었지만 효율성 측면에서 좋지 않은 점수를 받음
// 다른 코드 참고(BSTIterator_better)



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
