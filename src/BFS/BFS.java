package BFS;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 1, 10}
        };

        boolean[][] checked = new boolean[adjacencyMatrix.length][adjacencyMatrix[0].length];

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0, 0, null));
        checked[0][0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nodex = node.getX();
            int nodey = node.getY();
            int nodelen = node.getLength();
            
            if (nodex + 1 < adjacencyMatrix.length) {
                if (adjacencyMatrix[nodex + 1][nodey] != 0 && !checked[nodex+1][nodey]) {
                    queue.add(new Node(nodex + 1, nodey, nodelen + 1, node));
                    checked[nodex+1][nodey] = true;
                }

            }

            if (nodey + 1 < adjacencyMatrix[0].length) {
                if (adjacencyMatrix[nodex][nodey+1] != 0 && !checked[nodex][nodey+1]) {
                    queue.add(new Node(nodex, nodey + 1, nodelen + 1, node));
                    checked[nodex][nodey+1] = true;
                }

            }

            if (nodex - 1 > 0) {
                if (adjacencyMatrix[nodex-1][nodey] != 0 && !checked[nodex-1][nodey]) {
                    queue.add(new Node(nodex - 1, nodey, nodelen + 1, node));
                    checked[nodex-1][nodey] = true;
                }
            }

            if (nodey - 1 > 0) {
                if (adjacencyMatrix[nodex][nodey-1] != 0 && !checked[nodex][nodey-1]) {
                    queue.add(new Node(nodex, nodey - 1, nodelen + 1, node));
                    checked[nodex][nodey-1] = true;
                }
            }

            if (adjacencyMatrix[nodex][nodey] == 10) {
                System.out.println("FiND!");

                while (node != null) {
                    System.out.print("<-" + "[" + node.getX() + ","  +node.getY() +"]" );
                    node = node.predecessor;
                }
            }




        }


    }
}

class Node {
    int x;
    int y;
    int length;
    Node predecessor;

    public Node(int x, int y, int length, Node predecessor) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.predecessor = predecessor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }
}
