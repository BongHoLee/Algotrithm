package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_lastMusic {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {
                "12:00,12:14,HELLO,C#DEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
        };

        System.out.println(solution(m, musicinfos));

    }

    public  static String solution(String m, String[] musicinfos) {

        int maxPlayTime = 0;
        String targetTitle = "";


        for (String info : musicinfos) {
            String[] musicInfos = info.split(",");

            for (int i=0; i<musicInfos.length; i+=4) {

                int playTime = totalPlayTime(musicInfos[i], musicInfos[i + 1]);
                String title = musicInfos[i + 2];
                String totalMusicMelody = parsing(musicInfos[i + 3]);

                String listenedMelody = parsing(m);
                String realMelody = realPlayMelody(playTime, totalMusicMelody);

                if (isMatched(listenedMelody, realMelody) && maxPlayTime < playTime) {
                    maxPlayTime = playTime;
                    targetTitle = title;
                }
            }
        }

        return "".equals(targetTitle) ? "(None)" : targetTitle;
    }

    private  static int totalPlayTime(String startTime, String endTime) {
        int totalHours = Integer.parseInt(endTime.substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2));
        int totalMinutes = Integer.parseInt(endTime.substring(3)) - Integer.parseInt(startTime.substring(3));

        return (totalHours*60) + totalMinutes;
    }

    private  static String realPlayMelody(int realPlayTime, String totalMusicMelody) {
        if (realPlayTime > totalMusicMelody.length()) {
            int extraTime = realPlayTime - totalMusicMelody.length();
            return totalMusicMelody + (realPlayMelody(extraTime, totalMusicMelody));
        } else {
            return totalMusicMelody.substring(0, realPlayTime);
        }
    }

    private  static boolean isMatched(String listenedMelody, String realMelody) {
        return realMelody.indexOf(listenedMelody) > -1 ? true : false;
    }

    private static String parsing(String totalMusicMelody) {
        totalMusicMelody = totalMusicMelody.replaceAll("A#", "H")
                .replaceAll("C#", "I")
                .replaceAll("D#", "J")
                .replaceAll("F#", "K")
                .replaceAll("G#", "L");

        List<String> list = new ArrayList<>();
        for (int i=0; i<totalMusicMelody.length(); i++) {
            if (i < totalMusicMelody.length()-1 && totalMusicMelody.charAt(i+1) == '#') {
                list.add(Character.toString(totalMusicMelody.charAt(i)) + "#");
                i += 1;
            } else {
                list.add(Character.toString(totalMusicMelody.charAt(i)));
            }
        }

        return totalMusicMelody;
    }

}
