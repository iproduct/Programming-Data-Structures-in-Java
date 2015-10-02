package wumpus.model;

import static wumpus.model.CaveState.*;
import graph.Vertice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

public class CaveVertice implements Vertice<CaveVertice> {
	private int x;
	private int y;
	private Labyrinth labyrinth;	
	
	public CaveVertice(int x, int y, Labyrinth labyrinth) {
		this.x = x;
		this.y = y;
		this.labyrinth = labyrinth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	public void setLabyrinth(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaveVertice other = (CaveVertice) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	

	@Override
	public String toString() {
		return "CaveVertice [x=" + x + ", y=" + y + "]";
	}

	@Override
	public Collection<CaveVertice> getOutVertices() {
		EnumSet<CaveState> nonVisitingCaveStates = EnumSet.of(ROCK, PIT, WUMPUS);
		List<CaveVertice> adjacent = new ArrayList<>();
		if(x-1 >= 0 && !nonVisitingCaveStates.contains(labyrinth.getCaves()[y][x-1]))
			adjacent.add(new CaveVertice(x-1, y, labyrinth));
		if(x+1 < labyrinth.getWidth() && !nonVisitingCaveStates.contains(labyrinth.getCaves()[y][x+1]))
			adjacent.add(new CaveVertice(x+1, y, labyrinth));
		if(y-1 >= 0 && !nonVisitingCaveStates.contains(labyrinth.getCaves()[y-1][x]))
			adjacent.add(new CaveVertice(x, y-1, labyrinth));
		if(y+1 < labyrinth.getHeight() && !nonVisitingCaveStates.contains(labyrinth.getCaves()[y+1][x]))
			adjacent.add(new CaveVertice(x, y+1, labyrinth));
		return adjacent;
	}

}
