package wumpus.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import wumpus.model.CaveState;
import wumpus.model.Labyrinth;

public class CaveButton extends JPanel {
	public static final String[] IMAGE_FILE_NAMES= {
		"images/Rock.png","images/Pit.png","images/Wumpus.png",
	     "images/Gold.png","images/Hero.png"
	};
	private Labyrinth labyrinth;
	private int posX, posY;
	private Image[] images = new Image[IMAGE_FILE_NAMES.length];


	public CaveButton(Labyrinth labyrinth, int posX, int posY) {
		this.labyrinth = labyrinth;
		this.posX = posX;
		this.posY = posY;
		loadIcons();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x1 = 0, y1 = 0, x2 = getSize().width - 1, y2 = getSize().height - 1;
		g.drawRect(x1, y1, x2, y2);
		switch (labyrinth.getCaves()[posY][posX]) {
			case ROCK:
				g.drawImage(images[0], x1+1, y1+1, x2-1, y2-1, null);
				break;
			case PIT:
				g.drawImage(images[1], x1+1, y1+1, x2-1, y2-1, null);
				break;
			case WUMPUS:
				g.drawImage(images[2], x1+1, y1+1, x2-1, y2-1, null);
				break;
			case GOLD:
				g.drawImage(images[3], x1+1, y1+1, x2-1, y2-1, null);
				break;
			}
	    if (posX == labyrinth.getHeroX() && posY == labyrinth.getHeroY()) {
	    	g.drawImage(images[4], x1+1, y1+1, x2-1, y2-1, null); //Draw hero if in cave
	    }
	}
	
	private void loadIcons(){
		for(int i = 0; i < IMAGE_FILE_NAMES.length; i++) {
			File sourceImage = new File(IMAGE_FILE_NAMES[i]);
			try {
				images[i] = ImageIO.read(sourceImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
