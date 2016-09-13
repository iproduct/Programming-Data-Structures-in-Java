package examples;

public class Array2D {
	
	public static void printArray2D(int[][] a){
		for(int[] row: a) {
			for(int elem: row) {
				System.out.printf("%4d", elem);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = new int [4][];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = new int[a.length - i];
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = i + j;
			}
		}
		
		printArray2D(a);

	}

}
