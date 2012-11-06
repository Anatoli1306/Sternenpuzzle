package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Klasse enthällt die Reihe der oberen Buttons

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class PlayMenuButtonsTop extends JPanel
{
	
	/**
	 * 
	 * @param PlayFrame frame
	 * 
	 */
	
	public PlayMenuButtonsTop(final PlayFrame frame, String mode)
	{
			
		frame.getContentPane().setBackground(Color.white);
		
		final JButton btnGameMode = new JButton(new ImageIcon(getClass().getResource("/resources/gameMode.png")));
		final JButton btnEditMode = new JButton(new ImageIcon(getClass().getResource("/resources/editMode.png")));
		
		if ("Editor" == mode)
		{
			btnGameMode.setVisible(true);
			btnEditMode.setVisible(false);
		}
		else
		{
			btnGameMode.setVisible(false);
			btnEditMode.setVisible(true);
		}
		
		
		btnGameMode.setAlignmentX(LEFT_ALIGNMENT);
		btnGameMode.setContentAreaFilled(false);
		btnGameMode.setToolTipText("Starte den Spielmodus");
		btnGameMode.setBorder(null);
		
		btnGameMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	frame.drawGameBoard();
            	btnGameMode.setVisible(false);
            	btnEditMode.setVisible(true);
            }
        });        
		add(btnGameMode);
		
		
		
		btnEditMode.setAlignmentX(LEFT_ALIGNMENT);
		btnEditMode.setContentAreaFilled(false);
		btnEditMode.setToolTipText("Starte den Editormodus");
		btnEditMode.setBorder(null);
		
		btnEditMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 frame.drawEditorBoard();
            	 btnGameMode.setVisible(true);
             	btnEditMode.setVisible(false);
            }
        });           
		add(btnEditMode);
				
	}
	

}

