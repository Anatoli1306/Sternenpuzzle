package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Klasse enthällt die Reihe der oberen Buttons
 * @author Andreas, Mats, Daniel, Eren, Fabian, Anatoli
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
	/**
	 * Konstruktor
	 * @param frame
	 * @param mode
	 */
	public PlayMenuModeButton(final PlayFrame frame, String mode)
	{
			
		frame.getContentPane().setBackground(Color.white); //Hintergrund weis machen
		
		btnGameMode = new JButton(new ImageIcon(getClass().getResource("/resources/gameMode.png"))); //Modus-Button
		btnEditMode = new JButton(new ImageIcon(getClass().getResource("/resources/editMode.png"))); //Modus-Button
		
		if ("Editor" == mode)
		{
			//Editor-Buttons setzen
			btnGameMode.setVisible(true); 
			btnEditMode.setVisible(false);
		}
		else
		{
			//Game-Buttons setzen
			btnGameMode.setVisible(false);
			btnEditMode.setVisible(true);
		}
		
		
		btnGameMode.setAlignmentX(LEFT_ALIGNMENT);
		btnGameMode.setContentAreaFilled(false);
		btnGameMode.setToolTipText("Spielmodus starten");
		btnGameMode.setBorder(null);
		
		btnGameMode.addActionListener(new ActionListener() {
        	//Spielmodus öffnen
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
		btnEditMode.setToolTipText("Editormodus starten");
		btnEditMode.setBorder(null);
		
		btnEditMode.addActionListener(new ActionListener() {
        	// Editormodus öffnen
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

