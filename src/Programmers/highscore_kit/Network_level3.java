package Programmers.highscore_kit;

public class Network_level3 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(new Network_level3().solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findEachNodesLinks(i, computers, visited);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void findEachNodesLinks(int curNode, int[][] computers, boolean[] visited) {
        visited[curNode] = true;
        int[] eachLinks = computers[curNode];

        for (int i = 0; i < eachLinks.length; i++) {
            if (!visited[i] && eachLinks[i] == 1) {
                findEachNodesLinks(i, computers, visited);
            }
        }
    }
}
