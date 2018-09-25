package recursion;

public class Fibonacci {
//	public static int MAX_N = 1000;
	static long[] cache = new long[2]; // Memoizing (caching) old values
	
	public static long fib(int n) {
		if(n <= 2)
			return 1;
		else if (cache[n % 2] != 0)
			return cache[n % 2];
		else {
			long result = fib(n-1) + fib(n-2);
			cache[n % 2] = result;
			return result;
		}
	}
	
	public static long fibIterative(int n) {
		long prev1 = 1, prev2 = 1;
		for(int i = 3; i <= n; i++) {
			long temp = prev1;
			prev1 += prev2;
			prev2 = temp;
		}
		return prev1;
	}
	
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
		
}
