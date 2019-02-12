import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class UL03MineSweeper extends JFrame {
	private static final int GRIDSIZE = 10; 
	private static final int NUMBEROFHOLES = 10;
	
	private TerrainButton[] [] terrain = new TerrainButton[GRIDSIZE] [GRIDSIZE]; 
	private int totalRevealed = 0; 
	
	public UL03MineSweeper() {
		initGUI(); 
		setHoles(); 
		
		setTitle("Mine Sweeper");
		setSize(700, 500); //pixels
		setResizable(false);
		//pack(); //pack means pack tightly- overrides size
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	} 
	public void initGUI(){
		//Title!! 
		JLabel titleLabel = new JLabel("Mine Sweeper");
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		//customize label
		Font titleFont = new Font ("Papyrus" , Font.BOLD + Font.ITALIC,  32);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.ORANGE);
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setOpaque(true);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r,c);
				centerPanel.add(terrain[r][c]);
			}
		}
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r,c);
				terrain[r][c].addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e) {
						TerrainButton button = (TerrainButton) e.getSource();
						int row = button.getRow();
						int col = button.getCol();
						clickedTerrain(row,col);
					}
				});
				centerPanel.add(terrain[r][c]);
			} 
		} 
	
	}
	private void clickedTerrain (int row, int col) {
		if (terrain[row][col].hasHole()) {
			String message = "You stepped in a hole. Try again?";
			promptForNewGame(message);
			
		} else {
		check(row, col); 
		checkNeighbors(row, col); 
		if (GRIDSIZE * GRIDSIZE - totalRevealed ==0) { 
			String message = "You win! Do you want to play again?";
			promptForNewGame(message); 	
		}
	}
	}
	private void check(int row, int col) {
		if (row > -1 && row < GRIDSIZE && col > -1 && col < GRIDSIZE && !
				terrain[row][col].hasHole() && ! terrain[row][col].isRevealed()) {
			terrain[row][col].reveal(true);
			totalRevealed+= 1; 
			if (terrain[row][col].isNextToHoles()) {
				checkNeighbors (row, col); 
			}
			
		}
			
	}
	private void checkNeighbors (int row, int col) {
		check(row, col-1);
		check(row, col+1);
		check(row + 1, col -1);
		check(row + 1, col);
		check(row + 1, col + 1);
		check(row - 1, col - 1);
		check(row - 1, col);
		check(row - 1, col + 1);
		
		
	}
	private void setHoles() {
		Random rand = new Random();
		int pickRow;
		int pickCol;
		for (int i = 0; i < NUMBEROFHOLES; i++) {
			do {
				pickRow = rand.nextInt(GRIDSIZE);
				pickCol = rand.nextInt(GRIDSIZE);
				
			}
			while (terrain[pickRow][pickCol].hasHole());
			terrain[pickRow][pickCol].setHole(true);
			addToNeighborsHoleCount(pickRow, pickCol);
			//terrain[pickRow][pickCol].reveal(true);
		}
	}
	private void promptForNewGame(String mess) {
		showHoles();
		int option = JOptionPane.showConfirmDialog(this, mess, "Play Again?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			newGame();
		}
		else {
			System.exit(0);
		}
		
	}
	private void showHoles() {
		for (int row = 0; row <GRIDSIZE; row++){
			for ( int col = 0; row <GRIDSIZE; col++  ) {
				if (terrain[row][col].hasHole()) {
					terrain[row][col].reveal(true);
				}
			}
		}
	}
	private void newGame() {
		//CONFUSED,HELP 
		setHoles(); 
		totalRevealed = 0; 
	}


	
	private void addToNeighborsHoleCount(int row, int col) {
		System.out.println("adding to neighbor hole count");
		addToHoleCount(row, col-1);
		addToHoleCount(row, col+1);
		addToHoleCount(row + 1, col -1);
		addToHoleCount(row + 1, col);
		addToHoleCount(row + 1, col + 1);
		addToHoleCount(row - 1, col - 1);
		addToHoleCount(row - 1, col);
		addToHoleCount(row - 1, col + 1);
		
		// TODO Auto-generated method stub
		
	}  
	private void addToHoleCount(int row, int col) {
		if (col > -1 && row > -1  && col < GRIDSIZE && row < GRIDSIZE) {
			terrain[row][col].increaseHoleCount(); 
			//terrain[row][col].reveal(true);
		}
	} 
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new UL03MineSweeper();
            }   
        });
		
		// TODO Auto-generated method stub

	}

}
