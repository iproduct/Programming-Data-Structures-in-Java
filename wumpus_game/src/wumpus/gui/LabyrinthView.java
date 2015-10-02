package wumpus.gui;

import static java.awt.event.KeyEvent.KEY_PRESSED;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;

import wumpus.controller.LabyrinthController;
import wumpus.model.CaveState;
import wumpus.model.Labyrinth;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
/**
 * MVC View for {@link wumpus.controller.LabyrinthController LabyrinthController} 
 * built using <a href="https://eclipse.org/windowbuilder/">WindowBuilder</a>
 * plugin.
 * 
 * @author Trayan Iliev
 *
 */
public class LabyrinthView extends JFrame{
	private Labyrinth labyrinth;
	private LabyrinthController controller;
	private CaveButton[] caveButtons;
	
	public static final String[] SEARCH_ALGORITHMS = {
		"Depth First Search (DFS)", 
		"Breadth First Search (BFS)"
	};
	
	//Swing components
	JPanel mainPanel = new JPanel(); //main game panel
	JPanel buttonPanel = new JPanel(); //bottom button panel
	
	
	public LabyrinthView(String title, Labyrinth labyrinth, LabyrinthController controller) throws HeadlessException {
		super(title);
		this.labyrinth = labyrinth;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			System.err.println("Nimbus look and feel not available. Using default.");
		}
		
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
				CaveButton btn = new CaveButton(labyrinth, j, i);				
				caveButtons[i * labyrinth.getWidth() + j] = btn;
				mainPanel.add(btn);
			}
		}
		buttonPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				
		
		// Bottom button panel
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		// with anonimous class
//		JButton btnUp = new JButton("Up");
//		btnUp.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.moveUp();
//				mainPanel.repaint();
//			}
//		});
		
		// with lambda
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(
			(ActionEvent e) -> {
				controller.moveUp();
				mainPanel.repaint();
			}
		);
		
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
				controller.moveLeft();
				mainPanel.repaint();
			}
		});
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.moveRight();
				mainPanel.repaint();
			}
		});
		
		JPanel pathSearchPanel = new JPanel();
		pathSearchPanel.setBorder(new TitledBorder(null, " Path Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addGap(91)
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
					.addGap(105)
					.addComponent(pathSearchPanel, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonPanel.createSequentialGroup()
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
							.addContainerGap(23, Short.MAX_VALUE))
						.addComponent(pathSearchPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
		);
		pathSearchPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JComboBox<String> cbSelectAlgorithm = new JComboBox<>();
		cbSelectAlgorithm.setModel(
			new DefaultComboBoxModel<>(new String[] {
					"Depth First Search (DFS)", 
					"Breadth First Search (BFS)"}) //SEARCH_ALGORITHMS
		);
		pathSearchPanel.add(cbSelectAlgorithm);
		
		JButton btnStartSearch = new JButton("Start");
		btnStartSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				controller.startSearch((String)cbSelectAlgorithm.getSelectedItem());
			}
		});
		pathSearchPanel.add(btnStartSearch);
		
		JButton btnNextStep = new JButton("Next Step");
		btnNextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				controller.nextStep();
				mainPanel.repaint();
			}
		});
		pathSearchPanel.add(btnNextStep);
		
		buttonPanel.setLayout(gl_buttonPanel);
		
		//Register application global key listeners
//		KeyboardFocusManager.getCurrentKeyboardFocusManager()
//		  .addKeyEventDispatcher(new KeyEventDispatcher() {
//		      @Override
//		      public boolean dispatchKeyEvent(KeyEvent ev) {
//					switch (ev.getKeyCode()) {
//						case VK_UP: controller.moveUp(); break;
//						case VK_DOWN: controller.moveDown(); break;
//						case VK_LEFT: controller.moveLeft(); break;
//						case VK_RIGHT: controller.moveRight(); break;
//					}
//					System.out.println(ev.getKeyCode() + ", " + VK_UP);
//					mainPanel.repaint();
//					return false;
//				}
//		});
		
		// with lambda
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(ev -> {
			  	if(ev.getID() == KEY_PRESSED) {
					switch (ev.getKeyCode()) {
						case VK_UP: controller.moveUp(); break;
						case VK_DOWN: controller.moveDown(); break;
						case VK_LEFT: controller.moveLeft(); break;
						case VK_RIGHT: controller.moveRight(); break;
					}
					mainPanel.repaint();
			  	}
				return false;
			});

//		KeyListener keyListener = new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent ev) {
//				switch (ev.getKeyCode()) {
//				case VK_UP: controller.moveUp(); break;
//				case VK_DOWN: controller.moveDown(); break;
//				case VK_LEFT: controller.moveLeft(); break;
//				case VK_RIGHT: controller.moveRight(); break;
//				}
//				System.out.println(ev.getKeyCode() + ", " + VK_UP);
//				mainPanel.repaint();
//			}		
//		};
//		addKeyListener(keyListener);
		
		// show the window
		setVisible(true);
	}
}
