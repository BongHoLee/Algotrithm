package Programmers;

public class Level2_KAKAO_ZIPPING {
    public  int solution(String s) {
        int answer = s.length();

        for (int i=0; i<s.length(); i++) {
            int zippingLen = i+1;
            answer = Math.min(answer, getZippedRate(zippingLen, s));
        }
        return answer;
    }

    private  int getZippedRate(int zippingLen, String str) {
        int len = 1;
        String coiedStr = str;
        String tmpStr = "";
        StringBuilder zippedStr = new StringBuilder();


        while (coiedStr.length() > 0) {
            if (coiedStr.length() >= zippingLen) {
                if (!"".equals(tmpStr)) {
                    if (tmpStr.equals(coiedStr.substring(0, zippingLen))) {
                        coiedStr = coiedStr.replaceFirst(tmpStr, "");
                        len +=1;
                    } else {
                        zippedStr.append((len == 1 ? "" : len) + tmpStr);
                        tmpStr = "";
                        len = 1;
                    }
                } else {
                    tmpStr = coiedStr.substring(0, zippingLen);
                    coiedStr = coiedStr.replaceFirst(tmpStr, "");
                }
            } else {

                break;
            }
        }

        zippedStr.append((len == 1 ? "" : len) + tmpStr + coiedStr);
        //System.out.println(zippedStr.toString());
        return zippedStr.toString().length();
    }
}
