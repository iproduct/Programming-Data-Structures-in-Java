package examples;

import java.util.Scanner;

public class Array2D {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void printArray2D(int[][] a){
		for(int[] row: a) {
			for(int elem: row) {
				System.out.printf("%4d", elem);
			}
			System.out.println();
		}
	}
	
	public static int[][] inputArray2D(){
		System.out.println("Number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Number of columns: ");
		int cols = scanner.nextInt();
		int[][] a = new int[rows][cols];
		
		//input cells
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.printf("[%d, %d]: ", i, j);
				a[i][j] = scanner.nextInt();
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[][] a = new int [4][];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = new int[a.length - i];
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = i + j;
			}
		}
		
		int[][] b = inputArray2D();
		
		printArray2D(b);

	}

}
