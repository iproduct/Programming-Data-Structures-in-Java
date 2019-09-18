package labirint;

import java.util.Arrays;

public class Labirint {
	public static int[][] labirint = {
			{-1,-2,-1,-1,-1,-2},
			{-1,-2,-2,-2,-1,-2},
			{-1,-1,-1,-2,-1,-1},
			{-1,-2,-1,-2,-1,-1},
			{-1,-2,-1,-1,-1,-2}
	};
	
	public static final Cell START = new Cell(0, 0);
	public static final Cell END = new Cell(5, 3);
	
	public static Cell[] findPath(int[][] lab, Cell start, Cell target, int len) {
		lab[start.y][start.x] = (char) ('0' + len);
		System.out.println(start);
		printLabirint(lab);
		// Recursion bottom
		if(start.equals(target)) {
			lab[target.y][target.x] = 0;
			return new Cell[] { target };
		}
		
		// Recursion Step 
		Cell[] emptyNeighbours = findEmptyNeighbours(lab, start);
		
		for(Cell nbr: emptyNeighbours) {
			if(lab[nbr.y][nbr.x] == '.') {
				Cell[] path = findPath(lab, nbr, target, len+1);
//				if(path.length < lab[nbr.y][nbr.x] - '0') {
//					lab[nbr.y][nbr.x] = (char) ('0' + path.length);
//					
//				}
			}
		}
		
		return new Cell[0];
	}
	
	public static Cell[] findEmptyNeighbours(int[][] lab, Cell cell) {
		Cell[] result = new Cell[4];
		int pos = 0;
		if(cell.x > 0 && lab[cell.y][cell.x - 1] != -2) {
			result[pos++] = new Cell(cell.x - 1, cell.y);
		}
		if(cell.y > 0 && lab[cell.y - 1][cell.x] != -2) {
			result[pos++] = new Cell(cell.x, cell.y - 1);
		}
		if(cell.x < lab[0].length - 1 && lab[cell.y][cell.x + 1] != -2) {
			result[pos++] = new Cell(cell.x + 1, cell.y);
		}
		if(cell.y < lab.length-1 && lab[cell.y + 1][cell.x] != -2) {
			result[pos++] = new Cell(cell.x, cell.y + 1);
		}
		return Arrays.copyOf(result, pos);
	}
	
	public static void printLabirint(int[][] lab) {
		for(int[] row: lab) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Cell[] path = findPath(labirint, START, END, 0);
		for(Cell c: path) {
			System.out.print("[" + c.x + ", " + c.y + "] -> ");
		}
		System.out.println();
		
		Cell[] neighbours = findEmptyNeighbours(labirint, new Cell(4, 2));
		System.out.println(Arrays.toString(neighbours));
	}

}
