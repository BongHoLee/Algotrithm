import java.util.*;

public class TestCode {
    public static void main(String[] args) {
        Cat who = new Tiger();

        who.yawl();

    }
}

class Cat {
    public void yawl() {
        System.out.println("CAT YAWLING : " + yawling());
    }

    public String yawling() {
        return "mew!";
    }
}

class Tiger extends Cat {
    public String yawling() {
        return "cung";
    }
}

