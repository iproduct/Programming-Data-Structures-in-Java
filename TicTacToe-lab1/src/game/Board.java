package game;

public class Board {
	private Cell[][] cells;
	
	public Board(int size) {
		cells = new Cell[size][size];
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public void print() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[i].length; j++) {
				System.out.print(cells[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Board board = new Board(3);	
		board.print();
	}

}
