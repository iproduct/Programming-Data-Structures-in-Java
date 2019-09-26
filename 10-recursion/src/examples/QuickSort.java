package examples;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void quickSort(int[] a, int start, int end, int level) {
		// trace the recursive execution
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < level; k++)
			sb.append("  ");
		System.out.printf("%s[%d, %d]: %s\n", sb.toString(), start, end,
				Arrays.toString(Arrays.copyOfRange(a, start, end)));
		
		if(end - start <= 1) return; // recursion bottom
		
		int pivot = a[start];
		int left = start + 1;
		int right = end - 1;
		
		// 1. Partition: move smaller to left and bigger to the right of pivot
		while(true) {
			while(left < right && a[left] <= pivot) left++;
			while(left < right && a[right] >= pivot) right--;
			if(left >= right) break;
			swap(a, left++, right--);
		}
		// put pivot where left meets right
		if(a[start] > a[right])
			swap(a, start, right);
		
		// 2. Recursion step
		level++;
		quickSort(a, start, right, level);
		quickSort(a, right, end, level);

	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
//		int[] a = {23, 15, 17, 92, 110, 4, 12, 67, 54, 45};
		Random rand = new Random();
		int[] a = new int[100];
		for(int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(1000);
		}
		quickSort(a, 0, a.length, 0);
		System.out.println(Arrays.toString(a));
	}

}
