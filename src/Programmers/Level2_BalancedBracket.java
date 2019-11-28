package Programmers;


// 2020 카카오 블라인드 채용 테스트.

/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
* */


import java.util.HashMap;
import java.util.Map;

public class Level2_BalancedBracket {
    public static void main(String[] args) {
        System.out.println( solution("()))((()"));
    }

    public static String solution(String p) {
        StringBuilder answer = new StringBuilder();


        if ("".equals(p))
            return p;
        else {
            answer.append(balancing(p));
        }

        return answer.toString();
    }

    public static String balancing(String p) {
        if ("".equals(p))
            return p;
        else
            return balancing(depart(p));

    }

    public static String balancing(Map<String, String> depart) {

        String u = depart.get("u");
        String v = depart.get("v");


        // u가 올바른 괄호라면 v에 대해 balancing 재수행하여 결과를 붙임.
        if (checkRight(u)) {
            return u + balancing(v);
        } else {
            // u가 올바르지 않은 괄호라면
            v = balancing(v);
            u = u.substring(1);
            u = u.substring(0, u.length()-1);

            String revert = "";
            for (int i=0; i<u.length(); i++) {
                char c = u.charAt(i);

                if (c == '(')
                    revert += ")";
                else
                    revert += "(";
            }

            return "(" + v + ")" + revert;

        }



    }

    public static Map<String, String> depart(String p) {
        int flag = 0;
        Map<String, String> depart = new HashMap<>();

        String u = "";
        String v = "";

        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(')
                flag += 1;
            else
                flag -= 1;

            if (flag == 0) {
                u = p.substring(0, i + 1);
                v = i+1 >= p.length() ? "" : p.substring(i+1);
                depart.put("u", u);
                depart.put("v", v);
                break;
            }
        }

        return depart;
    }

    public static boolean checkRight(String u) {
        int flag = 0;

        for(int i=0; i<u.length(); i++) {
            char c = u.charAt(i);

            if (c == '(')
                flag +=1;
            else
                flag -=1;

            if (flag < 0)
                return false;
        }

        return true;

    }


}
