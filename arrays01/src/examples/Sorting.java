package examples;

import java.util.Arrays;

public class Sorting {
	private static int[] a = { 7, 3, 1, 19, 0, 3, 5, 2, 11, 19, 6, 3, 1, 11, 7, 16, 5, 13, 2, 1, 1, 5, 18, 3, 19, 4, 0,
			7, 12 };

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void sortMin(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int indexMin = findMinIndex(a, i);
			swap(a, i, indexMin);
		}
	}

	public static void sortBubble(int[] a) {
		boolean isSorted;
		int k = a.length - 1;
		do {
			isSorted = true;
			for (int i = 0; i < k; i++) {
				if (a[i] > a[i + 1]) {
					isSorted = false;
					swap(a, i, i + 1);
				}
			}
			k--;
		} while (!isSorted);
	}

	public static void sortInsertion(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int insertedElement = a[i];
			int j;
			for (j = i - 1; j >= 0 && insertedElement < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = insertedElement;
		}
	}

	private static int findMinIndex(int[] a, int from) {
		int min = a[from], indexMin = from;
		for (int j = from + 1; j < a.length; j++) {
			if (a[j] < min) {
				min = a[j];
				indexMin = j;
			}
		}
		return indexMin;
	}

	public static void main(String[] args) {
		sortInsertion(a);
		System.out.println(Arrays.toString(a));

	}

}
