package ohouse;

/**
 *  {A, B, C, D, E, F}
 *  {G, H, I, J, K, L}
 *  {M, N, O, P, Q, R}
 *  {S, T, U, V, W, X}
 *  {Y, Z}
 */

/**
 *  (x1, y1), (x2, y2) -> |x2 - x1| + |y2 - y1|
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * two fingers, calc sum of min distance
 * word = "HAPPY" -> 6
 * 1 H -> 0
 * 1 A -> 2 (H ~ A)
 * 2 P -> 0
 * 2 P -> 0
 * 1 Y -> 4 (A ~ Y)
 */
public class P3 {
    private static final String[][] keyboard = {
            {"A", "B", "C", "D", "E", "F"},
            {"G", "H", "I", "J", "K", "L"},
            {"M", "N", "O", "P", "Q", "R"},
            {"S", "T", "U", "V", "W", "X"},
            {"Y", "Z"}
    };

    private static class Coordinate {

        private final int x;
        private final int y;
        private final int distance;

        private Coordinate(int y, int x, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public Coordinate moveTo(Coordinate target) {
            if (target.isEmpty()) {
                throw new IllegalArgumentException("target coordination is empty");
            }

            if (isEmpty()) {
                return Coordinate.of(target.y, target.x);
            }

            int accumulatedDistance = distance + Math.abs(target.y - this.y) + Math.abs(target.x - this.x);
            return new Coordinate(target.y, target.x, accumulatedDistance);
        }

        public int getDistance() {
            return this.distance;
        }

        public static Coordinate of(int y, int x) {
            return new Coordinate(y, x, 0);
        }

        public static Coordinate createEmpty() {
            return new Coordinate(-1, -1, 0);
        }

        private boolean isEmpty() {
            return x < 0 || y < 0;
        }
    }
    public static void main(String[] args) {
        P3 p3 = new P3();
        String word = "HAPPYKZ";
        System.out.println(p3.solution(word));
    }

    public int solution(String word) {
        Map<String, Coordinate> coordinateMap = getCoordinateMap();
        String firstWord = Character.toString(word.charAt(0));
        Coordinate left = coordinateMap.get(firstWord);

        return recursion(coordinateMap, word, 1, left, Coordinate.createEmpty());
    }

    private int recursion(Map<String, Coordinate> coordinateMap, String word, int curIdx, Coordinate left, Coordinate right) {
        if (curIdx == word.length()) {
            return left.getDistance() + right.getDistance();
        } else {
            String nextChar = Character.toString(word.charAt(curIdx));
            Coordinate target = coordinateMap.get(nextChar);

            int leftResult = recursion(coordinateMap, word, curIdx + 1, left.moveTo(target), right);
            int rightResult = recursion(coordinateMap, word, curIdx + 1, left, right.moveTo(target));
            return Math.min(leftResult, rightResult);
        }
    }

    private Map<String, Coordinate> getCoordinateMap() {
        Map<String, Coordinate> coordinateMap = new HashMap<>();
        for (int y=0; y<keyboard.length; y++) {
            for (int x=0; x<keyboard[y].length; x++) {
                coordinateMap.put(keyboard[y][x], Coordinate.of(y, x));
            }
        }

        return coordinateMap;
    }


}


