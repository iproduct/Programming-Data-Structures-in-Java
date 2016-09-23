package recursion;

import java.util.Scanner;

public class Fibonacci {

	public static long fib(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static long fibIter(int n) {
		long fn = 1, fnm1 = 1, fnm2 = 1;
		for (int i = 2; i <= n; i++) {
			fn = fnm1 + fnm2;
			fnm2 = fnm1;
			fnm1 = fn;
			
		}
		return fn;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Input n (-1 to finish): ");
			n = sc.nextInt();
			if (n >= 0) {
				System.out.println("fib(" + n + ") = " + fibIter(n));
			}
		} while (n >= 0);
	}
}
