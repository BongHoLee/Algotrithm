package Programmers.highscore_kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum_level3 {


    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] solution = new BestAlbum_level3().solution(genres, plays);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }

    private static final String TOTAL = "total";
    private static final String PLAY_INDEX = "playIndex";

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresIndexMap = new HashMap<>();
        List<Map<String, Object>> listMap = new ArrayList<>();
        int genreCategoryCount = 0;

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int score = plays[i];

            if (genresIndexMap.containsKey(genre)) {
                int genreIndex = genresIndexMap.get(genre);
                Map<String, Object> genreInfo = listMap.get(genreIndex);
                int genreTotal = (int) genreInfo.get(TOTAL);
                List<Integer> playIndex = (List<Integer>) genreInfo.get(PLAY_INDEX);
                playIndex.add(i);

                genreInfo.put(TOTAL, genreTotal + score);
                genreInfo.put(PLAY_INDEX, playIndex);
            } else {
                genresIndexMap.put(genre, genreCategoryCount++);

                Map<String, Object> genreInfo = new HashMap<>();
                List<Integer> playIndex = new ArrayList<>();
                playIndex.add(i);

                genreInfo.put(TOTAL, score);
                genreInfo.put(PLAY_INDEX, playIndex);

                listMap.add(genreInfo);
            }
        }

        listMap.sort((o1, o2) -> {
            int o1Total = (int) o1.get(TOTAL);
            int o2Total = (int) o2.get(TOTAL);
            return Integer.compare(o2Total, o1Total);
        });

        List<Integer> finals = new ArrayList<>();
        for (Map<String, Object> genreInfo : listMap) {
            List<Integer> playIndex = (List<Integer>) genreInfo.get(PLAY_INDEX);
            playIndex.sort((o1, o2) -> {
                int o1Score = plays[o1];
                int o2Score = plays[o2];
                return Integer.compare(o2Score, o1Score);
            });
            for (int i = 0; (i < playIndex.size() && i < 2); i++) {
                finals.add(playIndex.get(i));
            }
        }

        int[] answer = new int[finals.size()];
        for (int i = 0; i < finals.size(); i++) {
            answer[i] = finals.get(i);
        }

        return answer;
    }
}
