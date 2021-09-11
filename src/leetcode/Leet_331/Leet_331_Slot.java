package leetcode.Leet_331;

public class Leet_331_Slot {
    public static void main(String[] args) {
        String preorder = "#,7,6,9,#,#,#";
        System.out.println(isValidSerialization(preorder));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] orders = preorder.split(",");
        int slot = 1;
        int pos = 0;
        boolean isValid = true;

        while (pos < orders.length) {
            if (slot == 0) {
                isValid = false;
                break;
            }
            if (orders[pos++].equals("#")) {
                slot -= 1;
            } else {
                slot += 1;
            }
        }

        if (isValid) {
            return slot == 0;
        } else {
            return false;
        }
    }
}
