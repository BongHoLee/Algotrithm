import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCode {
    public static void main(String[] args) {

        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        tmp1.add(2);

        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(4);
        tmp2.add(5);
        tmp2.addAll(tmp1);

        System.out.println(tmp2);

    }

}
