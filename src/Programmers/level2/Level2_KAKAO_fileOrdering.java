package Programmers.level2;

import java.util.*;

public class Level2_KAKAO_fileOrdering {
    public  String[] solution(String[] files) {
        List<String> orderedFiles = Arrays.asList(files);
        Collections.sort(orderedFiles, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1 = o1.toLowerCase();
                String o1sHead = getHead(o1);
                int o1sNumber = getNumber(o1.replaceFirst(o1sHead, ""));

                o2 = o2.toLowerCase();
                String o2sHead = getHead(o2);
                int o2sNumber = getNumber(o2.replaceFirst(o2sHead, ""));

                if (o1sHead.compareToIgnoreCase(o2sHead) > 0)
                    return 1;
                else if (o1sHead.compareToIgnoreCase(o2sHead) < 0)
                    return -1;
                else {
                    if (o1sNumber > o2sNumber)
                        return 1;
                    else if (o1sNumber < o2sNumber)
                        return -1;
                    else
                        return 0;
                }
            }
        });



        return orderedFiles.toArray(new String[orderedFiles.size()]);
    }

    private  String getHead(String fileName) {
        int numericPoint = fileName.length();
        for (int i=0; i<fileName.length(); i++) {
            if (Character.isDigit(fileName.charAt(i))) {
                numericPoint = i;
                break;
            }
        }

        return fileName.substring(0, numericPoint);
    }

    private  int getNumber(String fileName) {
        int charPoint = fileName.length();
        for (int i=0; i<fileName.length(); i++) {
            if (!Character.isDigit(fileName.charAt(i))) {
                charPoint = i;
                break;
            }
        }

        return Integer.parseInt(fileName.substring(0, charPoint));
    }
}