package Programmers.level2;

import java.util.*;

public class Kakao2021_Ranking_Search_P3 {
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
        Map<String, List<Integer>> group = new HashMap<>();

        for (String s : info) {
            String[] infos = s.split(" ");

            Queue<String> sq = new LinkedList<>();
            sq.add("-");
            sq.add(infos[0]);
            for (int i=1; i<infos.length; i++) {
                int qSize = sq.size();
                if (i < infos.length-1) {
                    for (int q=0; q<qSize; q++) {
                        String prev = sq.remove();
                        String cur = prev + infos[i];
                        String all = prev + "-";
                        sq.add(cur);
                        sq.add(all);
                    }
                } else {
                    while(!sq.isEmpty()) {
                        String groupKey = sq.remove();
                        List<Integer> list = group.containsKey(groupKey) ? group.get(groupKey) : new ArrayList<>();
                        list.add(Integer.parseInt(infos[i]));
                        group.put(groupKey, list);
                    }
                }
            }
        }

        for (List<Integer> scoreList : group.values()) {
            Collections.sort(scoreList);
        }

        for (int i = 0; i < query.length; i++) {
            String[] qs = query[i].replaceAll(" and ", " ").split(" ");
            int score = Integer.parseInt(qs[qs.length-1]);
            StringBuilder queryKey = new StringBuilder();
            for (int j=0; j<qs.length-1; j++)
                queryKey.append(qs[j]);

            int count = 0;
            if (group.containsKey(queryKey.toString())) {
                List<Integer> scoreList = group.get(queryKey.toString());

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

            answer[i] = count;
        }

        return answer;
    }


}
