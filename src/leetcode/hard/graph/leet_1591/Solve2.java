package leetcode.hard.graph.leet_1591;

import java.util.*;
public class Solve2 {

    public static void main(String[] args) {
        int[][] targetGrid = {
                {1, 1, 1, 1},
                {1, 1, 3, 3},
                {1, 1, 3, 4},
                {5, 5, 1, 4}
        };

        Solve2 solve2 = new Solve2();
        System.out.println(solve2.isPrintable(targetGrid));
    }

    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, int[]> pos = new HashMap<>();
        int n = targetGrid.length;
        int m = targetGrid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int[] coord = pos.putIfAbsent(targetGrid[i][j], new int[]{n, m, -1, -1});

                coord[0] = Math.min(coord[0], i);
                coord[1] = Math.min(coord[1], j);
                coord[2] = Math.max(coord[2], i);
                coord[3] = Math.max(coord[3], j);

            }
        }

        Set<Integer> colors = new HashSet<>(pos.keySet());
        while (!colors.isEmpty()) {
            Set<Integer> next = new HashSet<>();
            for (int color : colors) {
                if (!erase(targetGrid, pos.get(color), color)) {
                    next.add(color);
                }
            }
            if (colors.size() == next.size()) {
                return false;
            }
            colors = next;
        }
        return true;
    }

    private boolean erase(int[][] targetGrid, int[] coord, int color) {
        for (int i = coord[0]; i <= coord[2]; i++) {
            for (int j = coord[1]; j <= coord[3]; j++) {
                if (targetGrid[i][j] > 0 && targetGrid[i][j] != color) {
                    return false;
                }
            }
        }
        for (int i = coord[0]; i <= coord[2]; i++) {
            for (int j = coord[1]; j <= coord[3]; j++) {
                targetGrid[i][j] = 0;
            }
        }
        return true;
    }
}
