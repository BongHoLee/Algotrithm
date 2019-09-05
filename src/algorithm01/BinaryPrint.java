package algorithm01;

public class BinaryPrint {
	public static void main(String[] args) {
		binaryPrint(12341234);
	}
	
	public static void binaryPrint(int n) {
		if(n<2)
			System.out.print(n);
		else {
			binaryPrint(n/2);
			System.out.print(n%2);
		}
		
	}
}
