package Programmers.highscore_kit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author o118014_D
 * @since 2022-09-06
 */

public class TelNumberList_SORTING_AND_BRUTE_level2 {

    // ["119", "97674223", "1195524421"]  false
    // ["123","456","789"]	true
    // ["12","123","1235","567","88"] false
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        TelNumberList_SORTING_AND_BRUTE_level2 tn = new TelNumberList_SORTING_AND_BRUTE_level2();
        System.out.println(tn.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
