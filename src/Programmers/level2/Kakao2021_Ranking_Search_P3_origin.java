package Programmers.level2;

import java.util.*;

public class Kakao2021_Ranking_Search_P3_origin {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        System.out.println(solution(info, query));
    }

    // info : 개발언어, 직군, 경력, 소울푸드, 점수
    // query : 조
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, Object> langMap = new HashMap<>();
        Set<List<Integer>> sortedList = new HashSet<>();
        for (String s : info) {
            String[] infos = s.split(" ");
            Map<String, Object> jobMap = langMap.containsKey(infos[0]) ? (Map<String, Object>) langMap.get(infos[0]) : new HashMap<>();
            Map<String, Object> careerMap = jobMap.containsKey(infos[1]) ? (Map<String, Object>) jobMap.get(infos[1]) : new HashMap<>();
            Map<String, Object> foodMap = careerMap.containsKey(infos[2]) ? (Map<String, Object>) careerMap.get(infos[2]) : new HashMap<>();
            List<Integer> scoreList = foodMap.containsKey(infos[3]) ? (List<Integer>) foodMap.get(infos[3]) : new ArrayList<>();

            scoreList.add(Integer.parseInt(infos[4]));

            if (!foodMap.containsKey(infos[3])) {
                foodMap.put(infos[3], scoreList);
            }

            if (!careerMap.containsKey(infos[2])) {
                careerMap.put(infos[2], foodMap);
            }

            if (!jobMap.containsKey(infos[1])) {
                jobMap.put(infos[1], careerMap);
            }

            if (!langMap.containsKey(infos[0])) {
                langMap.put(infos[0], jobMap);
            }
        }

        for (int i = 0; i < query.length; i++) {
            String[] qs = query[i].replaceAll(" and ", " ").split(" ");

            Queue<Object> curGroupQ = new LinkedList<>();
            curGroupQ.add(langMap);

            int count = 0;
            for (int y = 0; y < qs.length; y++) {

                if (y != qs.length-1) {
                    int curQSize = curGroupQ.size();
                    for (int qSize = 0; qSize < curQSize; qSize++) {
                        Map<String, Object> curGroup = (Map<String, Object>) (curGroupQ.remove());

                        String curQuery = qs[y];
                        if (curQuery.equals("-")) {
                            curGroupQ.addAll(curGroup.values());
                        } else if(curGroup.containsKey(curQuery)) {
                            curGroupQ.add(curGroup.get(curQuery));
                        }
                    }
                } else {
                    while(!curGroupQ.isEmpty()) {
                        List<Integer> scoreList = (List<Integer>) curGroupQ.remove();
                        if (!sortedList.contains(scoreList)) {
                            Collections.sort(scoreList);
                            sortedList.add(scoreList);
                        }
                        int score = Integer.parseInt(qs[qs.length-1]);

                        int startIdx = 0;
                        int lastIdx = scoreList.size()-1;

                        if (scoreList.get(lastIdx) >= score) {
                            while(lastIdx > startIdx) {
                                int pos = (lastIdx + startIdx) / 2;
                                if (scoreList.get(pos) >= score) {
                                    lastIdx = pos;
                                } else if (scoreList.get(pos) < score) {
                                    startIdx = pos + 1;
                                }
                            }
                            count += scoreList.size() - lastIdx;
                        }
                    }
                }
            }

            answer[i] = count;
        }

        return answer;
    }


}