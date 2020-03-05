package algorithm01;

public class CalcLen {
	public static void main(String[] args) {
		String str = "hello";
		int length = len(str);
		
		System.out.println(length);
	}
	
	public static int len(String str) {
		if (str.equals("")) {
			return 0;
		} else {
			return 1 + len(str.substring(1));
		}

	}
}
