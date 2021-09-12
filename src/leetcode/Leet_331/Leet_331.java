package leetcode.Leet_331;

// 주어진 String이 preorder를 만족하면 true, 아니면 참
// #은 null node를 의미한다.

// preorder의 규칙을 먼저 알아야 함(ROOT -> LEFT -> RIGHT)


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leet_331 {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));
    }

    public static boolean isValidSerialization(String preorder) {
        RefInt pos = new RefInt(0);
        String[] c = preorder.split(",");

        int treeSize = c.length - 1;

        callit(c, pos, treeSize);

        if (pos.idx == treeSize)
            return true;
        return false;
    }

    //
    public static boolean callit(String[] order, RefInt pos, int treeSize) {
        if (order[pos.idx].equals("#"))
            return true;

        // left subtree is valid
        pos.idx += 1;
        if(pos.idx > treeSize || !callit(order, pos, treeSize))
            return false;

        // right subtree
        pos.idx += 1;
        if (pos.idx > treeSize || !callit(order, pos, treeSize))
            return false;

        return true;
    }
}

class RefInt {
    public Integer idx;

    RefInt(Integer idx) {
        this.idx = idx;
    }
}
