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

public class PlayMenuModeButton extends JPanel
{
	
	/**
	 * 
	 * @param PlayFrame frame
	 * 
	 */

	final JButton btnGameMode;
	final JButton btnEditMode;
	
	
	public void setBtnGameModeVisible(Boolean v){
		btnGameMode.setVisible(v);
	}
	
	public void setBtnEditModeVisible(Boolean v){
		btnEditMode.setVisible(v);
	}
	
	public PlayMenuModeButton(final PlayFrame frame, String mode)
	{
			
		frame.getContentPane().setBackground(Color.white);
		
		btnGameMode = new JButton(new ImageIcon(getClass().getResource("/resources/gameMode.png")));
		btnEditMode = new JButton(new ImageIcon(getClass().getResource("/resources/editMode.png")));
		
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
            	QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
            	
            	if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
            		frame.drawGameBoard(0,0);          	
            	
            		btnGameMode.setVisible(false);
            		btnEditMode.setVisible(true);
            	}
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
            	QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
            	
            	System.out.println(questionToSaveDialog.isSave_is_cancel());
            	
            	if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
            		frame.drawEditorBoard(0,0);          	
            	           		
            		btnGameMode.setVisible(false);
            		btnEditMode.setVisible(true);
            	}
            }
        });           
		add(btnEditMode);		
	}
	
	
	
}

