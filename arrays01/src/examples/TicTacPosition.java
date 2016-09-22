package examples;

import static examples.TicTacMove.*;

public class TicTacPosition {
	public static final int SIZE = 3;
	
	private TicTacMove[][] position = new TicTacMove[SIZE][SIZE];

	public TicTacPosition() {
		for(int i = 0; i < position.length; i++)
			for(int j = 0; j< position[i].length; j++)
				position[i][j] = EMPTY;
	}
	
	public TicTacPosition(TicTacPosition old){
		for(int i = 0; i < old.position.length; i ++){
			System.arraycopy(old.position[i], 0, position[i], 0, old.position[i].length);
//			for(int j = 0; j < old.position[i].length; j++ ) {
//				position[i][j] = old.position[i][j];
//			}
		}
	}
	
	public TicTacPosition move(TicTacMove move, int x, int y) throws NoneEmptyPositionException{
		if(position[x - 1][y - 1] != EMPTY)
			throw new NoneEmptyPositionException(x, y, position[x - 1][y - 1]);
		
		// copy constructor
		TicTacPosition newPos = new TicTacPosition(this);
		
		//make move
		newPos.position[x - 1][y - 1] = move;
		return newPos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("+---+---+---+\n");
		for(TicTacMove[] row: position) {
			sb.append("|");
			for(TicTacMove elem: row) {
				sb.append(" ").append(elem).append(" |");
			}
			sb.append("\n+---+---+---+\n");
		}
		return sb.toString();
	}
	
	
}
