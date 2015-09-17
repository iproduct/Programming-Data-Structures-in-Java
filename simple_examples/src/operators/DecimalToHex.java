package operators;

import java.util.Scanner;

public class DecimalToHex {
	public static String toHex(int n){
		StringBuilder sb = new StringBuilder();
		while(n != 0) {
			int digit = n & 0B1111;
			String ch = 
				((digit <= 9)? "" + digit : "" + ((char)('A' + digit-10)));
			sb.insert(0, ch);
			n >>>= 4;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input nymber: ");
		int n = sc.nextInt();
		System.out.println("n (10) = " + n);
		System.out.println("n (16) = " + toHex(n));

	}

}
