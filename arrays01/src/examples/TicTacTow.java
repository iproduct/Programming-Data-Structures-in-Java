package examples;

public class TicTacTow {
	
	

	public static void main(String[] args) {
		TicTacPosition initial = new TicTacPosition();
		System.out.println(initial);
		try {
			TicTacPosition p2 = initial.move(TicTacPosition.MOVE_X, 2, 2);
			System.out.println(p2);
			TicTacPosition p3 = p2.move(TicTacPosition.MOVE_O, 1, 3);
			System.out.println(p3);
		} catch (NoneEmptyPositionException e) {
			System.out.println(e.getMessage());
		}
	}

}
