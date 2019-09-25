package examples;

import java.math.BigDecimal;

public class Factoriel {
	public static final int NUMBER_ITERATIONS = 1000;
	
	public static BigDecimal factRecursive(long n) {
		if(n == 1) return new BigDecimal(1); // recursion bottom
		return new BigDecimal(n).multiply(factRecursive(n - 1)); // recursion step
	} // Number operations = 2*n-1 => Complexity = O(n)

	public static BigDecimal factIterative(long n) {
		BigDecimal fact = new BigDecimal(1);
		for(long i = 2; i <= n; i++) {
			fact = fact.multiply(new BigDecimal(i));
		}
		return fact;	
	} // Number operations = n => Complexity = O(n)
	
	public static void main(String[] args) {
		long startRecursive = System.nanoTime();
		BigDecimal recursive = new BigDecimal(0);
		for(int i = 0; i < NUMBER_ITERATIONS; i ++) {
			recursive = recursive.add(factRecursive(100));
		}
		long endRecursive = System.nanoTime();
		System.out.println("Recursive: " 
				+ (recursive.divide(new BigDecimal(NUMBER_ITERATIONS)) ) 
				+ ", time(ns): " + (endRecursive - startRecursive)/NUMBER_ITERATIONS);
		
		long startIterative = System.nanoTime();
		BigDecimal iterative = new BigDecimal(0);
		for(int i = 0; i < NUMBER_ITERATIONS; i ++) {
			iterative = iterative.add(factIterative(100));
		}
		long endIterative = System.nanoTime();
		System.out.println("Iterative: " 
				+ iterative.divide(new BigDecimal(NUMBER_ITERATIONS)) 
				+ ", time(ns): " + (endIterative - startIterative)/NUMBER_ITERATIONS);
	}

}
