package Programmers;


import java.util.*;

public class Level2_KAKAO_CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}

        };
        Set<String> hasSet = new HashSet<>();
        hasSet.add("3&5");
        hasSet.add("0&3");
        hasSet.add("4");
        hasSet.add("0");
        String columnList = "0&1&2";

        System.out.println(isMinimal(columnList, hasSet));

       // System.out.println(solution(relation));
    }


    public static int solution(String[][] relation) {
        int answer = 0;
        Set<String> candidateSet = new HashSet<>();

        for (int i=0; i<relation[0].length; i++) {
            for (int j=0; j<relation[0].length; j++) {
                answer += getCandidateCount(i + 1, j+1, relation[0].length, relation, Integer.toString(j), candidateSet);
                //System.out.println(getCandidateCount(1, 1, 4, relation, "0", set));
            }
        }
        System.out.println(candidateSet);

        return answer;
    }

    static int getCandidateCount(int columnCount, int start, int end, String[][] relation, String columnList, Set<String> candidateSet) {
        if (candidateSet.contains(columnList)) {
            return 0;
        } else if (columnCount == columnList.split("&").length){
            if (isUnique(columnList, relation)) {
                candidateSet.add(columnList);
                return 1;
            } else
                return 0;
        } else {
            int candidateCount = 0;

            for (int i=start; i<end; i++) {
                String curColumn = columnList + "&" + i;
                if (!isMinimal(curColumn, candidateSet)) continue;

                candidateCount += getCandidateCount(columnCount, i+1, end, relation, curColumn, candidateSet);

            }

            return candidateCount;
        }
    }

    static boolean isUnique(String columnList, String[][] relation) {
        Set<String> tuples = new HashSet<>();
        List<String> columns = Arrays.asList(columnList.split("&"));

        for (int x=0; x<relation.length; x++) {
            String tuple = "";
            for (String column : columns) {
                tuple += relation[x][Integer.parseInt(column)];
            }

            if (tuples.contains(tuple)) {
                return false;
            }

            tuples.add(tuple);

        }
        return true;
    }

    static boolean isMinimal(String columnList, Set<String> candidateSet) {
        List<String> columns = Arrays.asList(columnList.split("&"));

        for (String candidates : candidateSet) {
            List<String> candidate = Arrays.asList(candidates.split("&"));

            for (int i=0; i<candidate.size(); i++) {
                String candi = candidate.get(i);

                if (!columns.contains(candi))
                    break;

                if (i == candidate.size() - 1)
                    return false;
            }
        }

        return true;
    }





}
