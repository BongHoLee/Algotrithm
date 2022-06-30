import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        String numbers = "012345";

        int numbersSize = numbers.length();
        for (int i=0; i<numbersSize; i++) {
            String center = Character.toString(numbers.charAt(i));
            String before = numbers.substring(0, i);
            String after = numbers.substring(i+1, numbersSize);

            System.out.println(before + " | " + center + " | " + after);
        }
    }
}



