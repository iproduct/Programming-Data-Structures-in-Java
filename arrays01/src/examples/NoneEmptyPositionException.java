package examples;
import static examples.TicTacMove.*;

public class NoneEmptyPositionException extends Exception {
	private int x, y;
	private TicTacMove value;
	public NoneEmptyPositionException(int x, int y, TicTacMove value){
		super(String.format("Position (%d,%d) = %s is not empty.", x, y, value.name()));
		this.x = x;
		this.y = y;
		this.value = value;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public TicTacMove getValue() {
		return value;
	}
}
