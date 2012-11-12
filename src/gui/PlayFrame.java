package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
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
	public GuiElementBoard _oBoard = null;
	/**
	 * 
	 */
	public PlayFrame()
	{
		super("Sternenhimmel Puzzle");	
		setSize(1280, 1024);
		setLayout(null);
		
		drawGameBoard(40,40);
	}
	
	/**
	 * 
	 */
	
	public void drawGameBoard(int rows, int cols)
	{	
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = new GuiElementGameBoard(rows, cols);
		_oBoard.setBounds(30, 100, 1205, 850);
		drawDefaualtElements("Game");
		
		getContentPane().repaint();
	}
	
	
	/**
	 * 
	 */
	
	public void drawEditorBoard(int rows, int cols)
	{
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = new GuiElementEditorBoard(rows, cols);
		_oBoard.setBounds(30, 100, 1205, 850);
		drawDefaualtElements("Editor");
		
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
	
	public void drawDefaualtElements(String mode)
	{
		PlayMenuGameEditButtons menuButtonsTop = new PlayMenuGameEditButtons(this, mode);
		menuButtonsTop.setBounds(180, 10, 100, 80);
		menuButtonsTop.setOpaque(false);
		add(menuButtonsTop);
		
		PlayMenuButtonsTop menuButtonsBottom = new PlayMenuButtonsTop(this);
		menuButtonsBottom.setBounds(900, 15, 350, 500);
		menuButtonsBottom.setOpaque(false);		
		add(menuButtonsBottom);
		
		ImageIcon imgBanner = new ImageIcon(getClass().getResource("/resources/banner.png"));
	    JLabel lblBanner = new JLabel(imgBanner);
	    lblBanner.setBounds(0, 0, 1280, 110);
	    add(lblBanner);		
		
		setMenuBar(new PlayMenuBar(this));
							
		add(_oBoard);
    				
        JLabel backImgPanel = new JLabel(new ImageIcon(getClass().getResource("/resources/background.png")));
        backImgPanel.setLayout(null);
        backImgPanel.setOpaque(false);
        add(backImgPanel);
        backImgPanel.setBounds(0,0,1280,1024);
		//setExtendedState(MAXIMIZED_BOTH);  
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
