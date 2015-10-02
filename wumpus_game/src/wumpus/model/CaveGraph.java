package wumpus.model;

import graph.AbstractGraphImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CaveGraph extends AbstractGraphImpl<CaveVertice> {
	private Labyrinth labyrinth;

	public CaveGraph(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	@Override
	public Collection<CaveVertice> getVertices() {
		List<CaveVertice> cavesList = new ArrayList<>();
		for(int x=0; x < labyrinth.getWidth(); x++)
			for(int y=0; x < labyrinth.getHeight(); y++)
				cavesList.add(new CaveVertice(x, y, labyrinth));
		return cavesList;
	}

}
