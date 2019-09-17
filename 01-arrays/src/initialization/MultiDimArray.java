package initialization;

import java.util.Arrays;
import java.util.Random;

public class MultiDimArray {
	public static final int NUM_BOOKS = 4;
	public static final int NUM_MONTHS = 12;
	
	public static String matrixToString(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < NUM_BOOKS; i++) {
			for(int j = 0; j < NUM_MONTHS; j++) {
				sb.append(matrix[i][j]).append(" | ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static int[] getSalesByMonth(int[][] sales) {
		int[] monthTotals = new int[NUM_MONTHS];
		for(int i = 0; i < NUM_MONTHS; i++) {
			int total = 0;
			for(int j = 0; j < NUM_BOOKS; j++) {
				total += sales[j][i];
			}
			monthTotals[i] = total;
		}
		return monthTotals;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		
		int[][] sales = new int[4][12];
		for(int i = 0; i < NUM_BOOKS; i++) {
			for(int j = 0; j < NUM_MONTHS; j++) {
				sales[i][j] = rand.nextInt(900) + 100;
			}
		}
		
		// print sales
		System.out.println(matrixToString(sales));
		System.out.println(Arrays.toString(getSalesByMonth(sales)));
	}

}
