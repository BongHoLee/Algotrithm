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
        binarySearchTree.addNode(new Node(19));
        binarySearchTree.addNode(new Node(17));
        binarySearchTree.addNode(new Node(25));
        binarySearchTree.addNode(new Node(23));
        binarySearchTree.addNode(new Node(22));
        binarySearchTree.addNode(new Node(24));
        binarySearchTree.addNode(new Node(27));
        binarySearchTree.addNode(new Node(26));


        //System.out.println(binarySearchTree.findSuccessor(15).getValue());

        binarySearchTree.deleteNode(15);
        binarySearchTree.search();

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

    public Node findNode(int value) {
        return rootNode.findNode(value);
    }

    public Node findSuccessor(int value) {
        Node successor = null;
        Node node = findNode(value);

        if (node.getRightNode() != null) {
            successor =  node.getRightNode().getMinimumNode();
        } else {
            Node parent = node.getParentNode();
            while (parent.getParentNode() != null && node.equals(parent.getRightNode())) {
                node = parent;
                parent = node.getParentNode();
            }
            successor = parent;
        }
        return successor;
    }

    public void search() {
        rootNode.search();
    }

    public void deleteNode(int value) {
        Node deleteTarget = findNode(value);

        if (deleteTarget.getValue() == value) {

            // 1. 자식 노드가 없는 경우
            if (deleteTarget.getLeftNode() == null && deleteTarget.getRightNode() == null) {
                if (deleteTarget.equals(deleteTarget.getParentNode().getLeftNode())) deleteTarget.getParentNode().setLeftNode(null);
                else if (deleteTarget.equals(deleteTarget.getParentNode().getRightNode())) deleteTarget.getParentNode().setRightNode(null);

            // 2. 왼쪽 자식 노드만 갖는 경우 (자식 노드가 1개인 경우)
            } else if (deleteTarget.getLeftNode() != null && deleteTarget.getRightNode() == null) {
                deleteTarget.getParentNode().setLeftNode(deleteTarget.getLeftNode());

            // 3. 오른쪽 자식 노드만 갖는 경우 (자식 노드가 1개인 경우)
            } else if (deleteTarget.getLeftNode() == null && deleteTarget.getRightNode() != null) {
                deleteTarget.getParentNode().setRightNode(deleteTarget.getRightNode());

            // 4. 자식 노드 둘 다 갖지 않는 경우
            } else {
                Node successor = findSuccessor(value);
                int successorValue = successor.getValue();
                deleteNode(successor.getValue());
                deleteTarget.setValue(successorValue);
            }

        }
    }


}

class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;
    private Node parentNode;

    public Node(int value) {
        this.value = value;
    }

    public void addNode(Node node) {
        if (node.getValue() > value) {
            if (rightNode != null) rightNode.addNode(node);
            else {
                rightNode = node;
                node.setParentNode(this);
            }
        } else {
            if (leftNode != null) leftNode.addNode(node);
            else {
                leftNode = node;
                node.setParentNode(this);
            }
        }
    }

    public Node findNode(int value) {
        if (this.value == value)
            return this;
        else if (value > this.value) {
            if (!hasRightNode()) return null;
            return rightNode.findNode(value);
        }
        else {
            if (!hasLeftNode()) return null;
            return leftNode.findNode(value);
        }
    }

    public Node findNode(Node node) {
        if (this.equals(node))
            return this;
        else if (node.getValue() > this.value) {
            if (!hasRightNode()) return null;
            return rightNode.findNode(node);
        } else {
            if (!hasLeftNode()) return null;
            return leftNode.findNode(node);
        }
    }

    public Node getMinimumNode() {
        if (leftNode != null)
            return leftNode.getMinimumNode();
        else
            return this;
    }

    public Node getMaximumNode() {
        if (rightNode != null)
            return rightNode.getMaximumNode();
        else
            return this;
    }


    public void search() {
        System.out.print("Value " + value);
        if (leftNode != null)
            System.out.print(" Left Child " + leftNode.getValue());
        if (rightNode != null)
            System.out.print(" Right Child " + rightNode.getValue());

        System.out.println();

        if (leftNode != null)
            leftNode.search();
        if (rightNode != null)
            rightNode.search();
    }




    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public boolean hasLeftNode() {
        return leftNode != null;
    }

    public boolean hasRightNode() {
        return rightNode != null;
    }

    private void setParentNode(Node node) {
        this.parentNode = node;
    }

    public void setLeftNode(Node node) {
        this.leftNode = node;
    }

    public void setRightNode(Node node) {
        this.rightNode = node;
    }


    public void setValue(int value) {
        this.value = value;
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