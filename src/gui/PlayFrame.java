package gui;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

// Klasse enthällt das Layout

public class PlayFrame extends JFrame
{
	public static void main(String[] args)
	{
		PlayFrame wnd = new PlayFrame();
		

	}
	
	
	public PlayFrame()
	{
		super("Sternenhimmel Puzzle");
		
		GridLayout gridLayout;
		
		setLocation(100, 100);
		setSize(1000, 800);
		gridLayout = new GridLayout(3, 1);
		setLayout(gridLayout);
			
		ImageIcon imgBanner = new ImageIcon("Images/HintergrundWide.png");
	    JLabel lblBanner = new JLabel(imgBanner);	
		
		add(lblBanner);		
		setMenuBar(new PlayMenuBar(this));
		add(new PlayMenuButtons(this));
	    
		setVisible(true);
	}
}
