package examples;

import java.util.Arrays;

public class Eratosten {
	public static final int MAX_NUMBER = 100;

	public static void main(String[] args) {
		int[] a = new int[MAX_NUMBER - 1];
		for(int i = 0;  i < MAX_NUMBER - 1; i++) {
			a[i] = i +2;
		}
		System.out.println(Arrays.toString(a));
		
		// strike out all numbers that are not prime
		int sqrtN = (int) Math.sqrt(MAX_NUMBER);
		int j = 0;
		while(j < sqrtN){
			// find the next prime  => j (not striked out)
			while( a[j] == 0) {
				j++;
			}
			
			// strike out the numbers that divide on a[j] (only numbers > a[j]*a[j] - others are already stroken out)
			int k = a[j], indexDel;
			while((indexDel = a[j] * k - 2) < MAX_NUMBER) {
				a[indexDel] = 0;
				k++;
			}
			
			// try with next number
			j++;
		}
		
		// print prime number only (not stroken out: a[j] != 0)
		for(int i = 0; i < MAX_NUMBER - 1; i++)
			if(a[i] != 0 )
				System.out.print(a[i] + ", ");

	}

}
