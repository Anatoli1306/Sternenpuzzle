package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


// Klasse enthällt das Layout


/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class PlayFrame extends JFrame
{	
	private GuiElementBoard _oBoard = null;
	/**
	 * 
	 */
	public PlayFrame()
	{
		super("Sternenhimmel Puzzle");
		setResizable(false);
		setSize(800, 850);
		setLocation(100, 100);
		setLayout(null);
		
		drawGameBoard();
	}
	
	/**
	 * 
	 */
	
	public void drawGameBoard()
	{	
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		int cols = 20;
		int rows = 20;
		
		_oBoard = new GuiElementGameBoard(rows, cols);
		_oBoard.setBounds(getLeftPosition(cols), 300, 500, 500);
		drawDefaualtElements();
		
		getContentPane().repaint();
	}
	
	
	/**
	 * 
	 */
	
	public void drawEditorBoard()
	{
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		int cols = 10;
		int rows = 10;
		
		_oBoard = new GuiElementEditorBoard(rows, cols);
		_oBoard.setBounds(getLeftPosition(cols), 300, 500, 500);
		drawDefaualtElements();
		
		getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * little helper methode to calculate left posiition of board
	 * 
	 * @param int cols
	 * @return int
	 * 
	 */
	
	
	public int getLeftPosition(int cols)
	{
		if (cols > 15)
		{
			cols = 15;
		}
		
		int width = 400 / cols;
		
		return 200 - width;
	}
	
	
	/**
	 * 
	 */
	
	public void drawDefaualtElements()
	{
		PlayMenuButtonsTop menuButtonsTop = new PlayMenuButtonsTop(this);
		menuButtonsTop.setBounds(0, 200, 800, 80);
		menuButtonsTop.setBackground(Color.white);
		menuButtonsTop.setOpaque(false);
		add(menuButtonsTop);
		
		ImageIcon imgBanner = new ImageIcon(getClass().getResource("/resources/banner.png"));
	    JLabel lblBanner = new JLabel(imgBanner);
	    lblBanner.setBounds(0, 0, 800, 250);
	    add(lblBanner);		
		
		setMenuBar(new PlayMenuBar(this));
							
		add(_oBoard);
    	
		PlayMenuButtonsBottom menuButtonsBottom = new PlayMenuButtonsBottom(this);
		menuButtonsBottom.setBounds(0, 710, 800, 80);
		menuButtonsBottom.setBackground(Color.white);
		menuButtonsBottom.setOpaque(false);
		add(menuButtonsBottom);
				
        JLabel backImgPanel = new JLabel(new ImageIcon(getClass().getResource("/resources/background.png")));
        backImgPanel.setLayout(null);
        backImgPanel.setOpaque(false);
        add(backImgPanel);
        backImgPanel.setBounds(0,0,800,800);
		    	
		setVisible(true);
	}
	
	
	/**
	 *  shortcut
	 *  everything has to be added to content panel
	 *  adding elements directly to frame causes strange sideeffects
	 */
	
	public Component add(Component comp)
	{
		return getContentPane().add(comp);
	}
}
