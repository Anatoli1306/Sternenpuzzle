package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	static public PlayFrame _oPlayFrame = null;
	
	public GuiElementBoard _oBoard = null;
	/**
	 * 
	 */
	public PlayFrame()
	{
		super("Sternenhimmel Puzzle");	
		_oPlayFrame = this;
		setSize(1280, 1024);
		setLayout(null);
		

	    BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/msIcon.ico"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    setIconImage(image);
	    
		getContentPane().setBackground(Color.white);		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setExtendedState(this.MAXIMIZED_BOTH);  
		setVisible(true);
		drawGameBoard(0,0);
	}
	
	/**
	 * 
	 */
	
	public void drawGameBoard(int rows, int cols)
	{	
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = new GuiElementGameBoard(rows, cols);
		_oBoard.setBounds(10, 100, 1240, 870);
		drawDefaualtElements("Game");
		
		
		getContentPane().repaint();
		validate();
		this.refreshWindow();
	}
	
	
	/**
	 * 
	 */
	
	public void drawEditorBoard(int rows, int cols)
	{
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = new GuiElementEditorBoard(rows, cols);
		_oBoard.setBounds(10, 100, 1240, 870);
		drawDefaualtElements("Editor");
		
		validate();
		getContentPane().repaint();
		validate();
		this.refreshWindow();
	}
	
	
	public void drawLoadedBoard(GuiElementBoard gui)
	{
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = gui;//new GuiElementEditorBoard(rows, cols);
		_oBoard.setBounds(10, 100, 1240, 870);
		drawDefaualtElements("Editor");
		
		validate();
		getContentPane().repaint();
		validate();
		this.refreshWindow();
	}
	
	public void drawLoadedGameBoard(GuiElementBoard game)
	{
		getContentPane().removeAll();
		GuiElementField.clearImageCache();
		
		_oBoard = game;
		_oBoard.setBounds(10, 100, 1240, 870);
		drawDefaualtElements("Game");
		_oBoard.calculateStars();
		
		getContentPane().repaint();
		validate();
		this.refreshWindow();
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
		PlayMenuModeButton menuButtonsTop = new PlayMenuModeButton(this, mode);
		if(mode =="Game")
		{
			menuButtonsTop.setBtnEditModeVisible(true);
			menuButtonsTop.setBtnGameModeVisible(false);
		}
		else
		{
			menuButtonsTop.setBtnEditModeVisible(false);
			menuButtonsTop.setBtnGameModeVisible(true);
		}
		
		menuButtonsTop.setBounds(180, 10, 100, 80);
		menuButtonsTop.setOpaque(false);
		add(menuButtonsTop);
		
		PlayMenuMarkerButton menuButtonsBottom = new PlayMenuMarkerButton(this);
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
    	validate();
    	
		this.refreshWindow();

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
	
	public static void refreshWindow()
	{
		_oPlayFrame.validate();
		_oPlayFrame.repaint();
	}
}
