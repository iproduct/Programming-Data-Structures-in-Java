package examples;

public class NoneEmptyPositionException extends Exception {
	private int x, y, value;
	public NoneEmptyPositionException(int x, int y, int value){
		super(String.format("Position (%d,%d) = %s is not empty.", 
			x, y, 
			(value == TicTacPosition.MOVE_X)? "X" : "O"));
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
	public int getValue() {
		return value;
	}
}
