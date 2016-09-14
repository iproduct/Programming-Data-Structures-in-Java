package examples;

import java.util.Arrays;
import java.util.Scanner;

public class IntArraySort {
	public static final int MAX_ELEMENTS = 100;
	private static Scanner scanner = new Scanner(System.in);
	
	public static int[] inputIntArray() {
		int[] result = new int[MAX_ELEMENTS];
		int index = 0;
		String input;
		do {
			input = scanner.nextLine();
			try {
				result[index ++] = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				if(input.length() > 0) {
					System.out.println("Error: Invalid number. Please try again.");
				}
				index--;
			}
		} while(input.length() > 0);
		return Arrays.copyOf(result, index);
	}

	public static void main(String[] args) {
		System.out.println("Input numbers (<ENTER> for end):");
		int[] a = inputIntArray();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
