package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumbers {
	public static final int MAX_NUMBER = 1000000;
	
	public static List<Integer> getPrimeNumbersSlow(int maxNumber) {
		List<Integer> primes = new LinkedList<>();
		primes.add(2);
		
		outer:
		for(int n = 3; n <= maxNumber; n++) {
			int limit = (int) Math.sqrt(n);
			for(int d = 2; d < limit;  d++) {
				if(n % d == 0) continue outer;
			}
			primes.add(n);
		}
		return primes;
	}
	
	public static List<Integer> getPrimeNumbers(int maxNumber) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		
		outer:
		for(int n = 3; n <= maxNumber; n++) {
			int limit = (int) Math.sqrt(n);
			int i = 0;
			while( primes.get(i) <= limit && i < primes.size()) {
				if(n % primes.get(i) == 0) continue outer;
				i++;
			}
			primes.add(n);
		}
		return primes;
	}
	
	public static List<Integer> getPrimeNumbersEratosthenes(int maxNumber) {
		boolean[] isStroken = new boolean[maxNumber-1];
		List<Integer> primes = new ArrayList<>();
		
		int limit = (int) Math.sqrt(maxNumber);
		for(int i = 2;  i <= limit; i++) {
			while( isStroken[i - 2] && i < maxNumber) i++;
			int j = 2;
			int k = i * j;
			while( k <= maxNumber) {
				isStroken[k - 2] = true;
				j++;
				k = i * j;
			} ;
		}
		
		// Add all number that are not stroken as primes to the result list
		for(int n = 2; n <= maxNumber; n++ ) {
			if(!isStroken[n-2]) {
				primes.add(n);
			}
		}
		
		return primes;
	}
	
	

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		List<Integer> primes = getPrimeNumbersEratosthenes(MAX_NUMBER);
		long after = System.currentTimeMillis();
		System.out.println(primes);
		System.out.println(primes.size());
		System.out.println("Execution time: " + (after-before) + " ms");

	}

	

}
