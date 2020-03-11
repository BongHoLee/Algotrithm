package Programmers;

import java.util.*;

public class Level2_KAKAO_zip {
    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        System.out.println(Arrays.toString(solution(msg)));
    }

    public static int[] solution(String msg) {
        Map<String, Integer> dic = initDic();
        Stack<String> msgStack = initMsgStack(msg);
        List<Integer> zippedNum = new ArrayList<>();

        while (!(msgStack.isEmpty())) {
            String totStr = msgStack.pop();

            while (!(msgStack.isEmpty())) {
                String nextStr = msgStack.peek();

                if (dic.containsKey(totStr + nextStr)) {
                    totStr += msgStack.pop();
                } else {
                    dic.put(totStr + nextStr, dic.size() + 1);
                    break;
                }
            }
            zippedNum.add(dic.get(totStr));

        }

        return zippedNum.stream().mapToInt(i->i).toArray();

    }

    private static Map<String, Integer> initDic() {
        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Map<String, Integer> dic = new HashMap<>();

        for (int i=0; i<alphabets.length; i++)
            dic.put(Character.toString(alphabets[i]), i+1);

        return dic;
    }

    private static Stack<String> initMsgStack(String msg) {
        Stack<String> s = new Stack<>();

        for (int i=msg.length()-1; i>=0; i--)
            s.push(Character.toString(msg.charAt(i)));

        return s;
    }
}
