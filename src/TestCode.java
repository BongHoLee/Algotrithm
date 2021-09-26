import java.util.*;

public class TestCode {
    public static void main(String[] args) {

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        String[] query1 = query[0].split(" and ");
        for (String s : query1) {
            System.out.print(s);
        }
    }




}


