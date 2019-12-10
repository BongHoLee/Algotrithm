import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCode {
    public static void main(String[] args) {

        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        tmp1.add(1);
        tmp1.add(2);
        tmp1.add(3);

        tmp2.addAll(tmp1.subList(0, 2));
        tmp2.sort(Collections.reverseOrder());


        System.out.println(tmp2);
        System.out.println(tmp1);

    }

}
