import java.awt.Dimension;

import javax.swing.JButton;

public class TerrainButton extends JButton{
	private static final int SIZE = 50; 
	private int row = 0;
	private int col = 0;
	private int nextToHoles = 0;
	private boolean hole = false;
	private boolean revealed = false; 
	
	public TerrainButton (int row, int col) {
		int r= row;
		int c = col;
		//question about this step
		Dimension sizeWide = new Dimension ();
		Dimension sizeHeight = new Dimension ();
		terrainButton.setPreferredSize(SIZE);
	}

	public int getRow() {
		return row;
			}
	public int getCol() {
		return col;
	}
	public boolean hasHole() {
		return hole;
	}
	public boolean isRevealed() {
		return revealed;
	}
}
