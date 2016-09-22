package examples;

public class SlowPrimes {
	public static final int MAX_NUMBER = 100;
	
	public static void main(String[] args){
		for(int i = 2; i <= MAX_NUMBER; i++){
			boolean isPrime = true;
			int sqareRootN = (int) Math.sqrt(i);
			for(int j = 2; j <= sqareRootN; j++) {
				if( i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				System.out.printf("%d, ", i);
		}
	}
}
