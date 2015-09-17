package wumpus.controller;

import javax.swing.JFrame;

import wumpus.gui.LabyrinthView;
import wumpus.model.Labyrinth;
import wumpus.model.Position;

public class LabyrinthController {
	private Labyrinth labyrinth;
	private LabyrinthView view;
	
	public LabyrinthController(Labyrinth labyrinth){
		this.labyrinth = labyrinth;
		view = new LabyrinthView("Wumpus Game", labyrinth, this);
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
				}	
			);
		

	}

}
