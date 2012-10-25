package gui;

import java.awt.Color;
import java.awt.MenuBar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

// Klasse enthällt das Layout


/**
 * 
 * @author Eren, Fabian
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
		setSize(800, 850);

		setLayout(null);
		
		PlayMenuButtonsTop menuButtonsTop = new PlayMenuButtonsTop(this);
		menuButtonsTop.setBounds(0, 200, 800, 80);
		menuButtonsTop.setBackground(Color.white);
		menuButtonsTop.setOpaque(false);
		add(menuButtonsTop);
		
		ImageIcon imgBanner = new ImageIcon("Images/banner.png");
	    JLabel lblBanner = new JLabel(imgBanner);
	    lblBanner.setBounds(0, 0, 800, 250);
		add(lblBanner);		
		
		setMenuBar(new PlayMenuBar(this));	
							
		GuiElementGameBoard oGameBoard = new GuiElementGameBoard(10, 10);
		oGameBoard.setBounds(200, 300, 500, 500);
    	add(oGameBoard);
    	
		PlayMenuButtonsBottom menuButtonsBottom = new PlayMenuButtonsBottom(this);
		menuButtonsBottom.setBounds(0, 710, 800, 80);
		menuButtonsBottom.setBackground(Color.white);
		menuButtonsBottom.setOpaque(false);
		add(menuButtonsBottom);
				
        JLabel backImgPanel = new JLabel(new ImageIcon("Images/background.png"));
        backImgPanel.setLayout(null);
        backImgPanel.setOpaque(false);
        getContentPane().add(backImgPanel);
        backImgPanel.setBounds(0,0,800,800);
		    	
		setVisible(true);
	}
}
