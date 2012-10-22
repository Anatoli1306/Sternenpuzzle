package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

// Klasse enthällt das Layout


/**
 * 
 * @author Eren
 * @version 0.1
 *
 */

public class PlayFrame extends JFrame
{	
	
	/**
	 * 
	 */
	public PlayFrame()
	{
		super("Sternenhimmel Puzzle");
		
		setResizable(false);
		setLocation(100, 100);
		setSize(800, 800);

		setLayout(null);
			
		ImageIcon imgBanner = new ImageIcon("Images/HintergrundWide.png");
	    JLabel lblBanner = new JLabel(imgBanner);
	    lblBanner.setBounds(0, 0, 800, 250);
		add(lblBanner);		
		
		setMenuBar(new PlayMenuBar(this));	
		
		PlayMenuButtons menuBttons = new PlayMenuButtons(this);
		menuBttons.setBounds(300, 250, 200, 50);
		add(menuBttons);
	    
		GuiElementGameBoard oGameBoard = new GuiElementGameBoard(10, 10);
		oGameBoard.setBounds(50, 300, 500, 500);
    	
    	add(oGameBoard);
		setVisible(true);
	}
}
