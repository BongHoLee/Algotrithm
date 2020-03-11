package Programmers;

public class Level2_KAKAO_Njinsu {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));

    }

    public static String solution(int n, int t, int m, int p) {

        StringBuilder totalCode = new StringBuilder();
        StringBuilder tubeCode = new StringBuilder();

        int i = 0;
        while (totalCode.length()/m < t) {
            totalCode.append(convertDecimalToJinsu(n, i));
            i += 1;
        }

        int tubeIndex = p - 1;
        while (tubeCode.length() != t) {
            tubeCode.append(totalCode.substring(tubeIndex, tubeIndex+1));
            tubeIndex += m;
        }

        return tubeCode.toString();


    }

    private static String convertDecimalToJinsu(int jinsu, int originDecimal) {
        String[] jinsuCode = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        StringBuilder sb = new StringBuilder();

        if (originDecimal == 0)
            return "0";
        else {
            while (originDecimal > 0) {

                sb.insert(0, jinsuCode[originDecimal % jinsu]);
                originDecimal /= jinsu;
            }
        }

        return sb.toString();
    }
}
