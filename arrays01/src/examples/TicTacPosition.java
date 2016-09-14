package examples;

import java.util.Arrays;

public class TicTacPosition {
	public static final int SIZE = 3;
	public static final int EMPTY = 0;
	public static final int MOVE_X = 1;
	public static final int MOVE_O = 2;
	
	private int[][] position = new int[SIZE][SIZE];

	public TicTacPosition() {
	}
	
	public TicTacPosition(TicTacPosition old){
		for(int i = 0; i < old.position.length; i ++){
			System.arraycopy(old.position[i], 0, position[i], 0, old.position[i].length);
//			for(int j = 0; j < old.position[i].length; j++ ) {
//				position[i][j] = old.position[i][j];
//			}
		}
	}
	
	public TicTacPosition move(int who, int x, int y) throws NoneEmptyPositionException{
		if(position[x - 1][y - 1] != EMPTY)
			throw new NoneEmptyPositionException(x, y, position[x - 1][y - 1]);
		
		// copy constructor
		TicTacPosition newPos = new TicTacPosition(this);
		
		//make move
		newPos.position[x - 1][y - 1] = who;
		return newPos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("+---+---+---+\n");
		for(int[] row: position) {
			sb.append("|");
			for(int elem: row) {
				sb.append(elem == MOVE_X ? " X |": elem == MOVE_O ? " O |" : "   |");
			}
			sb.append("\n+---+---+---+\n");
		}
		return sb.toString();
	}
	
	
}
