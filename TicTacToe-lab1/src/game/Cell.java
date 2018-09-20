package game;

import static game.CellState.*;

public class Cell {
	private CellState state = EMPTY;

	public CellState getState() {
		return state;
	}

	public void setState(CellState state)  {
		if (this.state == EMPTY) {
			this.state = state;
		} else {
			throw new InvalidOperationException("Can not change non-empty cell again.");
		}
	}
	
	@Override
	public String toString() {
		return "[" + state.toString() + "]";
	}

}
