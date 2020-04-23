package BInarySearchTree;

public class Main {
    public static void main(String[] args) {
        Node rootNode = new Node(15);
        BST binarySearchTree = new BST(rootNode);
        binarySearchTree.addNode(new Node(6));
        binarySearchTree.addNode(new Node(3));
        binarySearchTree.addNode(new Node(2));
        binarySearchTree.addNode(new Node(4));
        binarySearchTree.addNode(new Node(7));
        binarySearchTree.addNode(new Node(13));
        binarySearchTree.addNode(new Node(9));
        binarySearchTree.addNode(new Node(18));
        binarySearchTree.addNode(new Node(17));
        binarySearchTree.addNode(new Node(20));


        searchNode(rootNode, 13);


    }

    static void searchNode(Node node, int searchValue) {
        if (node == null || node.getValue() == searchValue) {
            System.out.println("FIND! myValue is " + searchValue);
        } else {
            if (node.getValue() > searchValue)
                searchNode(node.getLeftNode(), searchValue);
            else
                searchNode(node.getRightNode(), searchValue);
        }

    }

}


class BST {
    private Node rootNode;

    public BST(Node rootNode) {
        this.rootNode = rootNode;
    }

    public void addNode(Node node) {
        rootNode.addNode(node);
    }

    public Node getNodeOfValue(int value) {
        return rootNode.getNodeOfValue(value);
    }

    public Node getSuccessor(int value) {
        return null;
    }


}

class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public void addNode(Node node) {
        if (node.getValue() > value) {
            if (rightNode != null) rightNode.addNode(node);
            else rightNode = node;
        } else {
            if (leftNode != null) leftNode.addNode(node);
            else leftNode = node;
        }

    }

    public Node getNodeOfValue(int value) {
        System.out.print("my VALUE IS " + this.value);
        if (this.value == value)
            return this;
        else if (value > this.value) {
            System.out.println(" and im serching for RIGHT NODE");
            if (rightNode == null) return null;
            return rightNode.getNodeOfValue(value);
        }
        else {
            System.out.println(" and im serching for LEFT NODE");
            if (leftNode == null) return null;
            return leftNode.getNodeOfValue(value);
        }
    }

    public Node getSuccessor(int value) {
        return null;

    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }


    public int getValue() {
        return value;
    }

    public void print() {
        String leftValue = leftNode == null ? "null" : Integer.toString(leftNode.getValue());
        String rightValue = rightNode == null ? "null" : Integer.toString(rightNode.getValue());

        System.out.println("My Value is : " + value);
        System.out.println("My LeftNode Value is : " + leftValue);
        System.out.println("My RightNode Value is : " + rightValue);

    }
}
