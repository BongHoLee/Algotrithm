package Programmers.level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int[] answer = {};
        String[] t1 = {"cpp", "java", "python", "-"};
        String[] t2 = {"backend", "frontend", "-"};
        String[] t3 = {"junior", "senior", "-"};
        String[] t4 = {"chicken", "pizza", "-"};

        Map<String, // 개발언어(cpp, java, python, -)
                Map<String, // 직군(backend, frontend, -)
                        Map<String, // 경력 (junior, senior)
                                Map<String, //소울 푸드 (chicken, pizza)
                                        Map<String, Integer> // 점수에 따른 인원수.
                                        >
                                >
                        >
                > tree = new HashMap<>();

        for (String s1 : t1) {
            Map<String, Map<String, Map<String,Map<String, Map<String, Integer>>>>> map1 = new HashMap<>();
            for (String s2 : t2) {
                Map<String, Map<String,Map<String, Map<String, Integer>>>> map2 = new HashMap<>();
                for (String s3 : t3) {
                    Map<String,Map<String, Map<String, Integer>>> map3 = new HashMap<>();
                    for (String s4 : t4) {
                        Map<String, Map<String, Integer>> map4 = new HashMap<>();
                        map4.put(s4, null);
                        map3.put(s3, map4);
                    }
                    map2.put(s2, map3);
                }
                map1.put(s1, map2);
            }
        }

        for (String s : info) {
            String[] infos = s.split(" ");
            Map<String, Map<String, Map<String, Map<String, Integer>>>> map1;
            if (infos[0].equals("-")) {
                map1  = tree.get("-");
            } else {
                map1 = tree.get("-");
                map1 = tree.get(infos[0]);
            }

            Map<String, Map<String, Map<String, Integer>>> map2;
            if (infos[1].equals("-")) {
                map2 =  map1.get("-");
            } else {
                map2 = map1.get(infos[1]);
            }

            Map<String, Map<String, Integer>> map3;
            if (infos[2].equals("-")) {
                map3=map2.get("-");
            } else {
                map3=map2.get("-");
                map3=map2.get(infos[2]);
            }


        }

        return answer;
    }





}
