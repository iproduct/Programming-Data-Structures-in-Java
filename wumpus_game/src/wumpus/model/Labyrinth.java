package wumpus.model;

import static wumpus.model.CaveState.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Labyrinth {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private int width = WIDTH;
	private int height = HEIGHT;
	private CaveState[][] caves;
	private int heroX = 0;
	private int heroY = 0;

	public Labyrinth() {
		this(WIDTH, HEIGHT);
	}
	
	public Labyrinth(int width, int height) {
		this.width = width;
		this.height = height;
		caves = new CaveState[height][];
		for (int i = 0; i < caves.length; i++) {
			caves[i] = new CaveState[width];
			for(int j = 0; j < caves[i].length; j++)
				caves[i][j] = EMPTY;
		}
	}

	public Labyrinth(int width, int height, Position wumpusPos, Position goldPos,
			Position[] pitsPos) {
		this(width, height); // Call already defined constructor without arguments
		caves[wumpusPos.getY()][wumpusPos.getX()] = WUMPUS;
		caves[goldPos.getY()][goldPos.getX()] = GOLD;
		for(int i = 0; i < pitsPos.length; i++) {
			caves[pitsPos[i].getY()][pitsPos[i].getX()] = PIT;
		}
	}
	
	public Labyrinth(int width, int height, Position wumpusPos, Position goldPos,
			Position[] pitsPos, Position[] rocksPos) {
		this(width, height, wumpusPos, goldPos, pitsPos); // Call already defined constructor without arguments
		for(int i = 0; i < rocksPos.length; i++) {
			caves[rocksPos[i].getY()][rocksPos[i].getX()] = ROCK;
		}
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public CaveState[][] getCaves() {
		return caves;
	}

	public void setCaves(CaveState[][] caves) {
		this.caves = caves;
	}

	public int getHeroX() {
		return heroX;
	}

	public void setHeroX(int heroX) {
		this.heroX = heroX;
	}

	public int getHeroY() {
		return heroY;
	}

	public void setHeroY(int heroY) {
		this.heroY = heroY;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < caves.length; i++) {
			result += "|";
			for (int j = 0; j < caves[i].length; j++) {
				switch(caves[i][j]){
				case EMPTY : result += " "; break;
				case ROCK: result += "#"; break;
				case PIT: result += "O"; break;
				case WUMPUS: result += "W"; break;
				case GOLD: result += "G"; break;
				default: result += "!";				
				}
			}
			result += "|\n";
		}
		return result;
	}
	
	public void printStatistics(){
		List<CaveState> cavesList = new ArrayList<>();
		for(CaveState[] row: caves)
			for(CaveState cave: row)
				cavesList.add(cave);
		cavesList.stream()
			.filter(c -> c != EMPTY)
//			.forEach((CaveState c) -> System.out.println(c));
			.sorted()
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Labyrinth lab = new Labyrinth(
				WIDTH, HEIGHT, //Labyrinth size
				new Position(5,4), //Wumpus
				new Position(9,7), //Gold
				new Position[] { // Pits
					new Position(2,4), 
					new Position(6,9), 
					new Position(2,7), 
					new Position(8,3), 
				}	
			);
		lab.printStatistics();
	}
}
