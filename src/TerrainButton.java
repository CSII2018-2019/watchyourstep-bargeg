import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class TerrainButton extends JButton{
	private static final int SIZE = 50; 
	private int row = 0;
	private int col = 0;
	private int nextToHoles = 0;
	private boolean hole = false;
	private boolean revealed = false; 
	
	public TerrainButton (int r, int c) {
		row = r;
		col = c;
		//question about this step
		Dimension size = new Dimension (SIZE, SIZE);
		setPreferredSize(size);
	}
	public void setHole(boolean hasHole) {
		hole = hasHole; 
	}
	public void increaseHoleCount() {
		nextToHoles += 1; 
	}
	public boolean isNextToHoles() {
		if (nextToHoles > 0) {
			return true;
		}
		else {
			return false; 
		}
	}
	public void reveal (boolean reveal) {
		revealed = reveal; 
		if (revealed == true) {
			if (hole == true) {
			setBackground(Color.BLACK); 	
		}
			else {
				setBackground(Color.CYAN); 
			}
			if (nextToHoles > 0) {
				setText("" + nextToHoles);
			}
		} 
		else {
			setBackground(null);
			setText(""); 
			setFocusPainted(false);
		}
	}
	public void reset() {
		hole = false;
		revealed = false; 
		nextToHoles = 0; 
		setText(""); 
		setBackground(null); 
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
