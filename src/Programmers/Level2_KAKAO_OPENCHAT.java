package Programmers;

import java.util.*;

public class Level2_KAKAO_OPENCHAT {
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        List<String> noticeList = new ArrayList<>();


        for (String row : record) {
            String[] rowArr = row.split(" ");
            if (rowArr.length > 2)
                nameMap.put(rowArr[1], rowArr[2]);
        }

        for (String row : record) {
            String[] rowArr = row.split(" ");
            if ("Leave".equals(rowArr[0])) {
                noticeList.add(nameMap.get(rowArr[1]) + "님이 나갔습니다.");
            } else if ("Enter".equals(rowArr[0])) {
                noticeList.add(nameMap.get(rowArr[1]) + "님이 들어왔습니다.");
            }
        }



        return noticeList.toArray(new String[noticeList.size()]);
    }
}
