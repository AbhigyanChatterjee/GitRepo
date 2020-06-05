package abhi;
public class Main {
	static int power(int a, int b) {
		int res = 1;
		for(int i = 0; i < b; i++) {
			res *= a;
		}
		return res;
	}
	static int mult(int a, int b) {
		return (a * b);
	}	
	public static void main {
		System.out.println("Abhigyan is the best");
		int a = 10;
		int b = 14;
		System.out.println((a + b)/(2*a - b));
		System.out.println(power(a,b));
		System.out.println(mult(a, b));
		
	}
} 
