package labirint;

import java.util.Arrays;

public class Labirint {
	public static char[][] labirint = {
			{'.','*','.','.','.','*'},
			{'.','*','*','*','.','*'},
			{'.','.','.','*','.','.'},
			{'.','*','.','*','.','.'},
			{'.','*','.','.','.','*'}
	};
	
	public static final Cell START = new Cell(0, 0, '.');
	public static final Cell END = new Cell(5, 3, '.');
	
	public static Cell[] findPath(char[][] lab, Cell start, Cell target) {
		// Recursion bottom
		if(start.equals(target)) {
			return new Cell[] { target };
		}
		
		// Recursion Step 
		Cell[] emptyNeighbours = findEmptyNeighbours(lab, start);
		
		return new Cell[0];
	}
	
	public static Cell[] findEmptyNeighbours(char[][] lab, Cell cell) {
		Cell[] result = new Cell[4];
		int pos = 0;
		if(cell.x > 0 && lab[cell.y][cell.x - 1] != '*') {
			result[pos++] = new Cell(cell.x - 1, cell.y, lab[cell.y][cell.x - 1]);
		}
		if(cell.y > 0 && lab[cell.y - 1][cell.x] != '*') {
			result[pos++] = new Cell(cell.x, cell.y - 1, lab[cell.y - 1][cell.x]);
		}
		if(cell.x < lab[0].length - 1 && lab[cell.y][cell.x + 1] != '*') {
			result[pos++] = new Cell(cell.x + 1, cell.y, lab[cell.y][cell.x + 1]);
		}
		if(cell.y < lab.length && lab[cell.y + 1][cell.x] != '*') {
			result[pos++] = new Cell(cell.x, cell.y + 1, lab[cell.y + 1][cell.x]);
		}
		return Arrays.copyOf(result, pos);
	}

	public static void main(String[] args) {
		Cell[] path = findPath(labirint, START, END);
		for(Cell c: path) {
			System.out.print("[" + c.x + ", " + c.y + "] -> ");
		}
		System.out.println();
		
		Cell[] neighbours = findEmptyNeighbours(labirint, new Cell(4, 2, '.'));
		System.out.println(Arrays.toString(neighbours));
	}

}
