package examples;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DaysOfWeek {
	public static final int MAX_ELEMENTS = 100;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void printArray(Object[] array) {
		for(int index = 0; index < array.length; index++){
			System.out.printf("Element[%d] = %s\n", index, array[index]);
//			System.out.printf("Element[%2$d] = %1$s\n", array[index], index);
		}
	}
	
	public static void printArrayLine(Object[] array) {
		System.out.print("[");
		for(int index = 0; index < array.length; index++){
			System.out.print(array[index]);
			if(index < array.length - 1 ) { //for all elements except last one
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
	
	public static void reverseArray(Object[] array) {
		for(int i = 0; i <= array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
	}
	
	public static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static String[] inputArray() {
		String[] result = new String[MAX_ELEMENTS];
		int index = 0;
		String input;
		do {
			input = scanner.nextLine();
			result[index] = input;
			index++;
		} while(input.length() > 0);
		return Arrays.copyOf(result, index - 1);
	}
	
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
		return Arrays.copyOf(result, index - 1);
	}
	
	public static void main(String[] args) {
//		String[] daysOfWeek;
//		daysOfWeek = new String[7];
//		daysOfWeek = new String[] {"Monday", "Thuesday", "Wednesday","Thursday", "Friday",
//				"Saturday", "Sunday"};
//		Date[] dates = {new Date(), new Date(32423434234L) };
//		System.out.println(Arrays.toString(daysOfWeek));
//		reverseArray(daysOfWeek);
//		printArrayLine(daysOfWeek);
		
		System.out.println("Please enter elements (<ENTER> for end):");
		String[] array = inputArray();
		printArrayLine(array);
		
//		printArrayLine(dates);
//		System.out.println(daysOfWeek[7]);
	}

}
