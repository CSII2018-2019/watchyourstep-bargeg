import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class UL03MineSweeper extends JFrame {
	
	public UL03MineSweeper() {
		initGUI(); 
		
		setTitle("Mine Sweeper");
		setSize(200, 100); //pixels
		setResizable(false);
		pack(); //pack means pack tightly- overrides size
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
