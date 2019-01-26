import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class UL03MineSweeper extends JFrame {
	private static final int GRIDSIZE = 10; 
	private static final int NUMBEROFHOLES = 10;
	
	private TerrainButton[] [] terrain = new TerrainButton[GRIDSIZE] [GRIDSIZE]; 
	private int totalRevealed = 0; 
	
	public UL03MineSweeper() {
		initGUI(); 
		
		setTitle("Mine Sweeper");
		setSize(700, 500); //pixels
		setResizable(false);
		//pack(); //pack means pack tightly- overrides size
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r,c);
				centerPanel.add(terrain[r][c]);
			}
		}
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
		}
	}

	
	private void addToNeighborsHoleCount(int pickRow, int pickCol) {
		// TODO Auto-generated method stub
		
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
