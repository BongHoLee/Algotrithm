package algorithm01;

public class Code01 {
	public static void main(String[] args) {
		int n = 5;
		func(n);
	}
	
	public static void func(int n) {
		
		if(n <= 0)
			return;
		
		System.out.println("Hello");
		func(n-1);
			
	}
	

}
