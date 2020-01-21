import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCode {
    public static void main(String[] args) {
        String[] fArray = {"A", "C", "F", "J", "M", "N", "R", "T"};
        List<String> friends = new ArrayList<>();
        for (String f : fArray)
            friends.add(f);

        String i = friends.remove(2);
        System.out.println(i);
        System.out.println(friends);

    }

}
