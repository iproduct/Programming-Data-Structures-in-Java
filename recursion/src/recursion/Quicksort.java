package recursion;

import java.util.Arrays;

public class Quicksort {
	
//	private static int[] a = { 7, 3, 1, 19, 0, 3, 5, 2, 11, 19, 6, 3, 1, 11, 7, 
//			16, 5, 13, 2, 1, 1, 5, 18, 56, 18, 22, 97, 3, 19, 4, 0,	7, 12 };

//	private static int[] a = {2, 11, 12, 12, 14, 23, 112, 79};
	private static int[] a = {7, 10, 15, 12, 7, 10 ,1, 5, 6};
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(int[] a, int start, int end) {
		if(start >= end) return; //recursion bottom
		
		//splitting array in two
		int pivotValue = a[start];
		int left = start;
		int right = end + 1;
		while(true){
			do left++; while(left < end && a[left] <= pivotValue);
			do right--; while(right > start && a[right] >= pivotValue);
			if(right <= left) break;
			swap(a, left, right);
		}
		swap(a, start, right);
		
		//recursion step
		quickSort(a,start, right - 1);
		quickSort(a,right + 1, end);
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args){
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
