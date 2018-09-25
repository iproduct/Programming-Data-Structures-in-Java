package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationsDemo {
	private static final Scanner sc = new Scanner(System.in);

	public static int[] inputIntArray() {
		int length = inputIntWithValidation("Input array length: ");
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = inputIntWithValidation("Input element [" + i + "]: ");
		}
		return array;
	}

	private static int inputIntWithValidation(String message) {
		int value = 0;
		do {
			System.out.print(message);
			String lenStr = sc.nextLine();
			try {
				value = Integer.parseInt(lenStr);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid value. Try again.");
			}
		} while (value <= 0);
		return value;
	}

	public static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - 1 - i);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static long calculateSum(int[] array) {

		return 0;
	}

	public static void bubbleSort(int[] a) {
		boolean sorted;
		int iteration = 0;
		do {
			sorted = true;
			iteration++;
			for (int i = 0; i < a.length - iteration; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					sorted = false;
				}
			}
		} while (!sorted);
	}

	public static int findIndexMin(int[] a, int fromIndex) {
		int minElem = a[fromIndex];
		int minIndex = fromIndex;
		for (int i = fromIndex + 1; i < a.length; i++) {
			if (a[i] < minElem) {
				minElem = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void sortMinSelect(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			swap(a, i, findIndexMin(a, i));
		}
	}

	public static int findIndexMax(int[] a, int toIndexIncluded) {
		int maxElem = a[0];
		int maxIndex = 0;
		for (int i = 1; i <= toIndexIncluded; i++) {
			if (a[i] > maxElem) {
				maxElem = a[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void sortMaxSelect(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, findIndexMax(a, i));
		}
	}

	public static void sortInsertion(int[] a) {
		for (int i = 1; i < a.length; i++) {

			// find insertion index j
			int j = 0;
			while (j < i && a[i] >= a[j]) {
				j++;
			}
			
			// insert a[i] in position j
			int temp = a[i];
			for (int k = i - 1; k >= j; k--) {
				a[k + 1] = a[k];
			}
			a[j] = temp;
		}
	}

	public static void main(String[] args) {
//		int[] a = inputIntArray();
		int[] a = { 123, 12, 3, 34, 12, 234, 19, 27, 24, 18, 129, 7 };
		System.out.println(Arrays.toString(a));
		System.out.println("Sum = " + calculateSum(a));
		int indexMax = findIndexMax(a, a.length - 1);
		System.out.println(indexMax);
		sortInsertion(a);
//		reverse(a);
		System.out.println(Arrays.toString(a));
	}

}
