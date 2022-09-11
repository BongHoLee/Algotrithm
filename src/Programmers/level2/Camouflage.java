package Programmers.level2;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.Arrays;

/**
 *
 * @author o118014_D
 * @since 2022-09-07
 */

public class Camouflage {
    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values().stream()
                .reduce(1L, (total, each) -> total + (each + 1)).intValue() -1;
    }
}
