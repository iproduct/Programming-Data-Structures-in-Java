package wumpus.controller;

import java.util.List;

import wumpus.gui.LabyrinthView;
import wumpus.model.CaveGraph;
import wumpus.model.CaveVertice;
import wumpus.model.Labyrinth;
import wumpus.model.Position;

public class LabyrinthController { //Controller
	private Labyrinth labyrinth; //Model
	private LabyrinthView view; //View
	private CaveGraph graph;
	
	public LabyrinthController(Labyrinth labyrinth){
		this.labyrinth = labyrinth;
		view = new LabyrinthView("Wumpus Game", labyrinth, this);
		graph = new CaveGraph(labyrinth);
	}

	public void moveDown() {
		int hx = labyrinth.getHeroX();
		int hy = labyrinth.getHeroY();
		if (hy < labyrinth.getHeight() - 1) {
			labyrinth.setHeroY(hy + 1);
		}
		System.out.println("Hero X=" + labyrinth.getHeroX() 
		+ ", Y=" + labyrinth.getHeroY());		
	}
	
	public void moveUp() {
		int hx = labyrinth.getHeroX();
		int hy = labyrinth.getHeroY();
		if (hy > 0) {
			labyrinth.setHeroY(hy - 1);
		}
		System.out.println("Hero X=" + labyrinth.getHeroX() 
		+ ", Y=" + labyrinth.getHeroY());		
		
	}

	public void moveLeft() {
		int hx = labyrinth.getHeroX();
		int hy = labyrinth.getHeroY();
		if (hx > 0) {
			labyrinth.setHeroX(hx - 1);
		}
		System.out.println("Hero X=" + labyrinth.getHeroX() 
		+ ", Y=" + labyrinth.getHeroY());		
		
	}

	public void moveRight() {
		int hx = labyrinth.getHeroX();
		int hy = labyrinth.getHeroY();
		if (hx < labyrinth.getWidth() - 1) {
			labyrinth.setHeroX(hx + 1);
		}
		System.out.println("Hero X=" + labyrinth.getHeroX() 
		+ ", Y=" + labyrinth.getHeroY());		
		
	}

	public void startSearch(String algorithm) {
		if(algorithm.equals(LabyrinthView.SEARCH_ALGORITHMS[0])) { //DFS
			graph.depthFirstStart(new CaveVertice(0, 0, labyrinth));
			System.out.println("Starting Depth First Search (DFS).");
		}
	}
	
	public void nextStep() {
		graph.depthFirstStep();
		System.out.println("Next step path: " + graph.getCurrentPath() 
				+ "\n visited: " + graph.getVisitedVertices() );
		List<CaveVertice> currentPath =  graph.getCurrentPath();
		CaveVertice currentVertice = currentPath.get(currentPath.size()-1);
		labyrinth.setHeroX(currentVertice.getX());
		labyrinth.setHeroY(currentVertice.getY());
//		if() { //DFS
//			graph.depthFirstStart(new CaveVertice(0, 0, labyrinth));
		
	}
	
	public static void main(String[] args) {
		Labyrinth lab = new Labyrinth(
				Labyrinth.WIDTH, Labyrinth.HEIGHT, //Labyrinth size
				new Position(5,4), //Wumpus
				new Position(9,7), //Gold
				new Position[] { // Pits
					new Position(2,4), 
					new Position(6,9), 
					new Position(2,7), 
					new Position(8,3), 
				},	
				new Position[] { // Rocks
					new Position(3,1), 
					new Position(3,2), 
					new Position(3,3), 
					new Position(4,3), 
					new Position(5,3), 
					new Position(3,3), 
					new Position(4,3), 
					new Position(5,3), 
					new Position(5,4), 
					new Position(5,5), 
					new Position(4,5)
				}
			);
		
		LabyrinthController c = new LabyrinthController(lab);
	}


}
