package Line;

public class Ch2 {
    public static void main(String[] args) {
        String answer_sheet = "4132315142";
        String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
        System.out.println(solution(answer_sheet, sheets));
    }

    static int solution(String answer_sheet, String[] sheets) {
        int answer = -1;

        for (int i=0; i<sheets.length; i++) {
            String comp1 = sheets[i];
            for (int j=i+1; j<sheets.length; j++) {
                String comp2 = sheets[j];

                if (comp1.equals(answer_sheet) || comp2.equals(answer_sheet))
                    continue;

                int compareCheat = cheatPoint(answer_sheet, comp1, comp2);
                answer = Math.max(answer, compareCheat);
            }
        }

        return answer;
    }

    static int cheatPoint (String answer_sheet, String comp1, String comp2) {
        int point = 0;
        int maximumCheat = 0;
        int tmpMaximum = 0;

        for (int i=0; i<answer_sheet.length(); i++) {
            char answer = answer_sheet.charAt(i);
            char comp1Answer = comp1.charAt(i);
            char comp2Answer = comp2.charAt(i);

            if ((comp1Answer == comp2Answer) && (answer != comp1Answer)) {
                point ++;
                tmpMaximum ++;
            } else {
                maximumCheat = Math.max(maximumCheat, tmpMaximum);
                tmpMaximum = 0;
            }
        }

        if (tmpMaximum != 0 ) {
            maximumCheat = Math.max(maximumCheat, tmpMaximum);
        }

        return point + (maximumCheat * maximumCheat);
    }


}
