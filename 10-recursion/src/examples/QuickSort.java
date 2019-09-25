package examples;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] a, int start, int end) {
		if(end - start <= 1) return; // recursion bottom
		
		
		int pivot = a[start];
		int left = start + 1;
		int right = end - 1;
		
		// move smaller to left and bigger to the right of pivot
		while(true) {
			while(left < right && a[left] <= pivot) left++;
			while(left < right && a[right] >= pivot) right--;
			if(left >= right) break;
			swap(a, left++, right--);
		}
		// put pivot where left meets right
		if(a[start] > a[right])
			swap(a, start, right);
		
		// recursion step
		quickSort(a, start, right);
		quickSort(a, right, end);

	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {23, 15, 17, 92, 110, 4, 12, 67, 54, 45};
		quickSort(a, 0, a.length);
		System.out.println(Arrays.toString(a));
	}

}
