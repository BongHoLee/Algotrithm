package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_Kakao_sajin {
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(2, data));
    }

    public static int solution(int n, String[] data) {
        int answer = 0;
        String[] fArray = {"A", "C", "F", "J", "M", "N", "R", "T"};
        List<String> friends = new ArrayList<>();
        List<String> permut = new ArrayList<>();
        for (String f : fArray)
            friends.add(f);


        answer = permutation(data, friends, permut, 0, 8);
        return answer;
    }

    public static int permutation(String[] data,  List<String> friends ,List<String> permut, int start, int end) {
        if (permut.size() == end) {
            if (conditionCheck(data, permut))
                return 1;
            else
                return 0;
        } else {
            int cnt = 0;
            for (int i=start; i<end; i++) {
                String tmp = friends.remove(0);
                permut.add(tmp);
                cnt += permutation(data, friends, permut, start+1, end);
                permut.remove(tmp);
                friends.add(tmp);

            }
            return cnt;
        }
    }

    public static boolean conditionCheck(String[] data, List<String> permut) {
        for (int i=0; i<data.length; i++) {
            String condition = data[i];
            String start = Character.toString(condition.charAt(0));
            String end = Character.toString(condition.charAt(2));
            String cond = Character.toString(condition.charAt(3));
            int value = Integer.parseInt(Character.toString(condition.charAt(4)));
            int ganguk = Math.abs(permut.indexOf(start) - permut.indexOf(end));

            if (cond.equals(">")) {
                if (ganguk <= value+1)
                    return false;
            } else if (cond.equals("<")) {
                if (ganguk >= value+1)
                    return false;
            } else {
                if (ganguk != value+1)
                    return false;
            }
        }
        return true;
    }

}
