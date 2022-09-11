package Programmers.highscore_kit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author o118014_D
 * @since 2022-09-06
 */

public class TelNumberList_HASH_level2 {

    // ["119", "97674223", "1195524421"]  false
    // ["123","456","789"]	true
    // ["12","123","1235","567","88"] false
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        TelNumberList_HASH_level2 tn = new TelNumberList_HASH_level2();
        System.out.println(tn.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));

        for (String eachNumber : phoneSet) {
            for (int i=0; i<eachNumber.length(); i++) {
                String prefix = eachNumber.substring(0, i);
                if (phoneSet.contains(prefix)) return false;
            }
        }

        return true;
    }
}
