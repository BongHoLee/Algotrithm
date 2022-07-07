package Programmers.highscore_kit;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * begin -> target
 * 한 번에 한 개의 알파벳만 바꿈
 * words에 있는 단어로만 변환 가능
 *
 * begin: hit
 * target: cog
 * words: [hot, dot, dog, lot, log, cog]
 * hit -> hot -> dot -> dog -> cog
 * 총 4단계
 *
 * 구) 최소 몇단계?
 *
 *
 */

public class FindWord_level3 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        FindWord_level3 p = new FindWord_level3();

        System.out.println(p.solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        wordsSet.add(begin);

        Map<String, Set<String>> graph = graphOf(wordsSet);


        return bfs(begin, target, wordsSet, graph);
    }

    private int bfs(String begin, String target, Set<String> wordsSet, Map<String, Set<String>> graph) {
        Queue<String> wordQ = new LinkedList<>();
        Map<String, Integer> countingMap = wordsSet.stream().collect(toMap(each -> each, each -> 0));
        Map<String, Boolean> visited = wordsSet.stream().collect(toMap(each -> each, each -> false));

        wordQ.offer(target);
        while(!wordQ.isEmpty()) {
            String word = wordQ.poll();
            if (countingMap.containsKey(word) && graph.containsKey(word)) {
                int nextCount = countingMap.get(word) + 1;
                for (String linkedWord : graph.get(word)) {

                    if (!visited.get(linkedWord)) {
                        visited.put(linkedWord, true);
                        wordQ.offer(linkedWord);
                        countingMap.put(linkedWord, nextCount);
                    }

                }
            }
        }

        return countingMap.get(begin);
    }

    private Map<String, Set<String>> graphOf(Set<String> wordsSet) {
        return wordsSet.stream()
                .collect(toMap(each -> each, each -> wordsSet.stream().filter(other -> canLink(each, other)).collect(toSet())));
    }

    private boolean canLink(String s1, String s2) {
        int notMatched = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (notMatched > 1) {
                return false;
            }

            if (s1.charAt(i) != s2.charAt(i)) {
                notMatched ++;
            }
        }

        return notMatched == 1;
    }
}
