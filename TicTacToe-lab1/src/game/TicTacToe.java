package game;

import java.util.Scanner;
import static game.CellState.*;

public class TicTacToe {
	public static final int DEFAULT_SIZE = 3;
	private static final Scanner sc = new Scanner(System.in);
	
	private Board board;
	
	public TicTacToe() {
	}
	
	public void init() {
		int size = inputIntWithValidation("Input board size [Enter for default]: ", true);
		if(size == 0) {
			size = DEFAULT_SIZE;
		}
		board = new Board(size);
	}
	
	public CellState getWinner() {
	
		
		return EMPTY;
	}
	
	public void printBoard() {
//		board.print();
		System.out.println(board);
	}

	private static int inputIntWithValidation(String message, boolean allowEmptyAnswer) {
		int value = 0;
		do {
			System.out.print(message);
			String lenStr = sc.nextLine();
			if(allowEmptyAnswer && lenStr.length() == 0) return 0;
			
			try {
				value = Integer.parseInt(lenStr);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid value. Try again.");
			}
		} while (value <= 0);
		return value;
	}

	
	private void play(CellState firstPlayer) {
		CellState player = firstPlayer;
		do {
			int x = inputIntWithValidation("Player [" + player + "] move X: ", false);
			int y = inputIntWithValidation("Player [" + player + "] move Y: ", false);
			try {
				board.setCell(player, x - 1, y - 1);
				System.out.println(board);
			} catch (InvalidOperationException e) {
				System.out.println("Invalid move! Try again.");
				continue;
			}
			player = (player == X) ? O : X;
		} while(getWinner() == EMPTY);
		System.out.println("Congratulations " + getWinner() + "! YOU WIN!!!" );
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.init();
		game.play(O);
		game.printBoard();
	}



}
