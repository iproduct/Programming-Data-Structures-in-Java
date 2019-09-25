package examples;

public class Fibonachi {
	
	public static long fibRecursive(long n) {
		if(n <= 1) return 1;
		return fibRecursive(n-1) + fibRecursive(n-2);
	} // Approx 2^n - exponential complexity O(2^n)
	
	public static long fibIterative(long n) {
		long temp = 1;
		long n1 = 1, n2 = 1;
		for(long i = 2; i <= n; i++) {
			temp = n1 + n2;
			n2 = n1;
			n1 = temp;
		}
		return temp;
	} // Approx n iterations - linear complexity O(n)

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
			System.out.println(i + " --> " + fibRecursive(i));
		System.out.println(fibIterative(20));

	}

}
