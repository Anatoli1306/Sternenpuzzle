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
 * Klasse enthällt die Buttons der linken Seite
 * Moduswechsel - In den Editiermodus oder in den Spielmodus
 * 
 * @author Eren, Fabian, Mats, Andreas, Anatoli, Daniel
 * @version 0.1
 *
 */
public class PlayMenuModeButton extends JPanel
{
	final JButton btnGameMode;
	final JButton btnEditMode;
	
	/**
	 * Funktion setzt einen Boolean ob der Spielmodus aktiviert werden soll
	 * 
	 * @param v - Boolean
	 */
	public void setBtnGameModeVisible(Boolean v){
		btnGameMode.setVisible(v);
	}
	
	/**
	 * Funktion setzt einen Boolean ob der Editiermodus aktiviert werden soll
	 * 
	 * @param v - Boolean
	 */
	public void setBtnEditModeVisible(Boolean v){
		btnEditMode.setVisible(v);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param frame - PlayFrame
	 * @param mode - Aktuelle Modus
	 */
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
				int temp = 0;
				if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0 || PlayFrame._oPlayFrame._oBoard.isHasChanged() == false){temp = 1;}
				else{
					QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
            	
					if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
						frame.drawGameBoard(0,0);          	
            	
						btnGameMode.setVisible(false);
						btnEditMode.setVisible(true);
					}
            	}
				if(temp == 1){
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
				int temp = 0;
				if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0 || PlayFrame._oPlayFrame._oBoard.isHasChanged() == false){temp = 1;}
				else{
					QuestionToSaveDialog questionToSaveDialog = new QuestionToSaveDialog();
					if(questionToSaveDialog.isYes_no_answer() && questionToSaveDialog.isSave_is_cancel() == false){
						frame.drawEditorBoard(0,0);          	
            	           		
						btnGameMode.setVisible(false);
						btnEditMode.setVisible(true);
					}
            	}
				if(temp == 1){
					frame.drawEditorBoard(0,0);
					btnGameMode.setVisible(false);
					btnEditMode.setVisible(true);
				}
            }
        });           
		add(btnEditMode);		
	}
}

