package wumpus.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wumpus.controller.LabyrinthController;
import wumpus.model.CaveState;
import wumpus.model.Labyrinth;
import wumpus.model.Position;
import static wumpus.model.CaveState.*;

public class LabyrinthView extends JFrame{
	private Labyrinth labyrinth;
	private LabyrinthController controller;
	private CaveButton[] caveButtons;
	
	//Swing components
	JPanel mainPanel = new JPanel(); //main game panel
	JPanel buttonPanel = new JPanel(); //bottom button panel
	
	
	public LabyrinthView(String title, Labyrinth labyrinth, LabyrinthController controller) throws HeadlessException {
		super(title);
		this.labyrinth = labyrinth;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		
		// Main game panel
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		int width = labyrinth.getWidth(), height = labyrinth.getHeight();
		mainPanel.setLayout(
				new GridLayout(Labyrinth.WIDTH, Labyrinth.HEIGHT, 2, 2));
		
		//fill the caves as buttons
		caveButtons = new CaveButton[labyrinth.getWidth() * getHeight()];
		CaveState[][] caves = labyrinth.getCaves();
		for(int i = 0; i < caves.length; i++) {
			for(int j = 0; j < caves[i].length; j++){
				EnumSet<CaveState> states = EnumSet.of(caves[i][j]);
				if (i == labyrinth.getHeroY() && j == labyrinth.getHeroX())
					states.add(HERO); //show hero icon
				CaveButton btn = new CaveButton(labyrinth, j, i);				
				caveButtons[i * labyrinth.getWidth() + j] = btn;
				mainPanel.add(btn);
			}
		}
				
		
		// Bottom button panel
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveDown();
				mainPanel.repaint();
			}
		});
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonPanel.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonPanel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_buttonPanel.createSequentialGroup()
							.addGap(79)
							.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(165))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonPanel.createSequentialGroup()
							.addGap(57)
							.addComponent(btnDown))
						.addGroup(gl_buttonPanel.createSequentialGroup()
							.addComponent(btnUp)
							.addGap(5)
							.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRight)
								.addComponent(btnLeft))))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		buttonPanel.setLayout(gl_buttonPanel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		
	}
}
