package examples;

import java.util.Arrays;

public class EratostenBoolean {
	public static final int MAX_NUMBER = 100;

	public static void main(String[] args) {
		boolean[] stroken = new boolean[MAX_NUMBER + 1];
				
		// strike out all numbers that are not prime
		int sqrtN = (int) Math.sqrt(MAX_NUMBER);
		int j = 2;
		while(j < sqrtN){
			// find the next prime  => j (not striked out)
			while( stroken[j] ) {
				j++;
			}
			
			// strike out the numbers that divide on a[j] (only numbers > a[j]*a[j] - others are already stroken out)
			int k = j, indexDel;
			while((indexDel = j * k) <= MAX_NUMBER) {
				stroken[indexDel] = true;
				k++;
			}
			
			// try with next number
			j++;
		}
		
		// print prime number only (not stroken out: a[j] != 0)
		for(int i = 2; i <= MAX_NUMBER; i++)
			if(!stroken[i]  )
				System.out.print(i + ", ");

	}

}
