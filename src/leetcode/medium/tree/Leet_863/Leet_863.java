package leetcode.medium.tree.Leet_863;


import leetcode.TreeNode;

import java.util.*;



// target의 조상노드들 각각과 target 사이의 거리(distance)를 구하고

// 1. target의 하위 노드에 대해서 dfs로 거리와 k가 일치하는 노드들 찾음

// 2. 사전에 구한 조상 노드들에 대해서
// 2-1. target과 거리(distance)가 일치하면 해당 조상 노드를 list에 삽입
// 2-2. 조상 노드의 LEFT, RIGHT 중 target과 다른 경로에 대해서 dfs를 진행


public class Leet_863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(3);


        TreeNode target = root.right;
        int k = 2;
        System.out.println(distanceK(root, target, k));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> kthList = new ArrayList<>();
        Map<TreeNode, DistancePath> parentMap = new HashMap<>();
        findParent(root, target, parentMap);

        for (Map.Entry<TreeNode, DistancePath> entry : parentMap.entrySet()) {
            TreeNode ancestorNode = entry.getKey();
            DistancePath distancePath = entry.getValue();
            if (distancePath.distance == k) {
                kthList.add(ancestorNode.val);
            } else {
                if (distancePath.path.equals("LEFT"))
                    dfs(ancestorNode.left, kthList, k, distancePath.distance + 1);
                else
                    dfs(ancestorNode.right, kthList, k, distancePath.distance + 1);
            }
        }

        dfs(target, kthList, k, 0);

        return kthList;
    }

    private static int findParent(TreeNode root, TreeNode target, Map<TreeNode, DistancePath> parentMap) {
        if (root == null) {
            return 0;
        }

        if (root.val == target.val) {
            return 1;
        }


        if (root.left != null) {
            int leftDistance = findParent(root.left, target,  parentMap);
            if (leftDistance > 0) {
                parentMap.put(root, new DistancePath(leftDistance, "RIGHT"));
                return leftDistance + 1;
            }
        }

        if (root.right != null) {
            int rightDistance = findParent(root.right, target,  parentMap);
            if (rightDistance > 0) {
                parentMap.put(root, new DistancePath(rightDistance, "LEFT"));
                return rightDistance + 1;
            }
        }

        return 0;
    }

    private static void dfs(TreeNode root, List<Integer> list, int k, int distance) {
        if (root != null) {
            if (k == distance) {
                list.add(root.val);
            } else {
                if (root.left != null) {
                    dfs(root.left, list, k, distance + 1);
                }

                if (root.right != null) {
                    dfs(root.right, list, k, distance + 1);
                }
            }
        }
    }
}

class DistancePath {
    int distance;
    String path;

    public DistancePath(int distance, String path) {
        this.distance = distance;
        this.path = path;
    }
}
