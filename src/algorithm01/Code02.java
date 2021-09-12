package algorithm01;

public class Code02 {
	public static void main(String[] args) {
		int n = 4;
		int result = func(n);
		
		System.out.println(result);
	}
	
	public static int func(int n) {
		if (n <= 0 ) {
			return 0;
		} else {
			return n + func(n-1);
		}
		
		
	}
}
