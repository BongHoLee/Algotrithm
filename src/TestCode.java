import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String tmp = info[0].replaceAll(" ", "");
        System.out.println(tmp);
    }




}


