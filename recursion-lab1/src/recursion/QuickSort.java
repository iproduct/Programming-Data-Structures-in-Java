package recursion;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] a, int start, int end) {
		
		if(end - start <= 1) return; //recursion bottom
		
		int pivot = a[start];
		int left = start + 1;
		int right = end - 1;
		
		while(true) {
			while(left < right && a[left] <= pivot) left++;
			while(left < right && a[right] >= pivot) right--;
			if(left >= right) break;
			swap(a, left++, right--);
		}
		swap(a, start, right);
		
		//recursion step 
		quickSort(a, start, right);
		quickSort(a, right + 1, end);	
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 123, 12, 3, 34, 12, 234, 19, 27, 24, 18, 129, 7 };
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length);
		System.out.println(Arrays.toString(a));
	}

}
