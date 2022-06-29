package Programmers.highscore_kit;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 고득점_KIT level2 '위장' - hash STREAM 사용 버전(다른사람 코드 참고)
 *
 */

public class Camouflage_level2_STREAM {
    public static void main(String[] args) {
        //        String[][] clothes = {
//                {"yellowhat", "headgear"},
//                {"bluesunglasses", "eyewear"},
//                {"green_turban", "headgear"}
//        };

        String[][] clothes = {
                {"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}
        };
        Camouflage_level2_STREAM prov = new Camouflage_level2_STREAM();
        System.out.println(prov.solution(clothes));
    }

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                // groupingBy 메서드의 classifier, downStream을 정의해서 넘겨준다.
                // classifier: 분류 기준
                // downStream: 집계 방식
                // p[1]이 분류 기준 (카테고리)
                // p[0]의 카운트 (집계 방식)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                // n+1인 이유는 '입지 않는 경우' 까지 포함했기 때문 -> '적어도 하나 입어야 한다'와 같이 '모든 경우 - 1' 수행을 위함
                .reduce(1L, (total, n) -> total * (n + 1)).intValue() - 1;
    }
}
