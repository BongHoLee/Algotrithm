package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Level2_lastMusic {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {
                "12:00","12:14","HELLO","C#DEFGAB",
                "13:00","13:05","WORLD","ABCDEF"
        };

        solution(m, musicinfos);

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        for (int i=0; i<musicinfos.length; i+=4) {

            int playTime = totalPlayTime(musicinfos[i], musicinfos[i+1]);
            String title = musicinfos[i+2];
            List<String> totalMusicMelody = toList(musicinfos[i+3]);
            List<String> realMelody = realPlayMelody(playTime, totalMusicMelody);
            System.out.println(playTime + " " + realMelody);



        }

        return answer;
    }

    private static int totalPlayTime(String startTime, String endTime) {
        int totalHours = Integer.parseInt(endTime.substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2));
        int totalMinutes = Integer.parseInt(endTime.substring(3)) - Integer.parseInt(startTime.substring(3));

        return (totalHours*60) + totalMinutes;
    }

    private static List<String> realPlayMelody(int realPlayTime, List<String> totalMusicMelody) {
        if (realPlayTime > totalMusicMelody.size()) {
            int extraTime = realPlayTime - totalMusicMelody.size();
            totalMusicMelody.addAll(realPlayMelody(extraTime, totalMusicMelody));
            return totalMusicMelody;
        } else {
            List<String> extraMelody = new ArrayList<>();
            for (int i=0; i<realPlayTime; i++)
                extraMelody.add(totalMusicMelody.get(i));

            return extraMelody;
        }
    }

    private static List<String> toList(String totalMusicMelody) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<totalMusicMelody.length(); i++) {
            if (i < totalMusicMelody.length()-1 && totalMusicMelody.charAt(i+1) == '#') {
                list.add(Character.toString(totalMusicMelody.charAt(i)) + "#");
                i += 1;
            } else {
                list.add(Character.toString(totalMusicMelody.charAt(i)));
            }
        }

        return list;
    }

}
