package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.CheckEditorBoardDifficulty;
import logic.GameBoard;

/**
 * Klasse beinhaltet die rechten Buttons im Spiel
 * Spielmodus: Marker setzen, Zurück zum Marker, Zurück zum Fehler
 * Editiermodus: Überprüfen
 * 
 * @author Eren, Fabian, Mats, Andreas, Daniel, Anatoli
 * @version 0.1
 *
 */
public class PlayMenuMarkerButton extends JPanel
{
	private PlayFrame playFrame;


	/**
	 * Konstruktor
	 * 
	 * @param PlayFrame frame
	 * @param mode - enhällt den Namen des aktuellen Modus
	 * 
	 */
	public PlayMenuMarkerButton(PlayFrame frame,  String mode)
	{
		playFrame = frame;

		//	Dekl. Button SET ( Marker auf aktuellen Spielstand setzen )
		JButton btnSet;
		btnSet = new JButton(new ImageIcon(getClass().getResource("/resources/set.png")));
		btnSet.setAlignmentX(LEFT_ALIGNMENT);
		btnSet.setContentAreaFilled(false);
		btnSet.setBorder(null);
		btnSet.setToolTipText("Marker setzen");

		btnSet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"Marker gesetzt","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
				GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
				oLogicBoard.getCommandTracker().setMarkerPosition();
			}
		});  
		if(frame._oBoard instanceof GuiElementGameBoard){
			add(btnSet);
		}

		//	Dekl. Button CHECK ( Spiel entspricht den Regeln )
		JButton btnCheck;
		btnCheck = new JButton(new ImageIcon(getClass().getResource("/resources/check.png")));
		btnCheck.setAlignmentX(LEFT_ALIGNMENT);
		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorder(null);

		if ("Editor" == mode) // Im EDITIERMODUS
		{
			btnCheck.setToolTipText("Checkt, ob Spiel den Regeln entspricht"); // ToDo -> "Rückgängig zum ersten Fehler"

			btnCheck.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e)
				{
					if(PlayFrame._oPlayFrame._oBoard.getCols() == 0 && PlayFrame._oPlayFrame._oBoard.getRows() == 0){
						JOptionPane.showMessageDialog(null,"Sie müssen erst ein Spielfeld anlegen","Option so nicht möglich", JOptionPane.PLAIN_MESSAGE);
					}
					else{					
						if (playFrame._oBoard instanceof GuiElementGameBoard)
						{
							JOptionPane.showMessageDialog(null,"Lösbarkeit anzeigen","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
						}
						else
						{
							boolean result = playFrame._oBoard.check();
							String resultDiff = playFrame._oBoard.getDifficulty();
							String message = "Spiel entspricht nicht den Regeln";
							boolean showDiff = false;
							if (!result)
							{
								message = "Spiel entspricht den Regeln";
								showDiff = true;
							}
							JOptionPane.showMessageDialog(null, message, "SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
	
							if (showDiff)
							{
								JOptionPane.showMessageDialog(null, "Das Spiel ist "+resultDiff, "SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
								if (CheckEditorBoardDifficulty.BOARD_DIFFICULTY_NOT_SOLVABLE == resultDiff)
								{
									Map<Integer, HashMap<Integer, Integer>> unsolvableStars = playFrame._oBoard.getUnsolvableStars();
									for (int i = 0; i < unsolvableStars.size(); i++) 
									{
										HashMap<Integer, Integer> starPosMap = null;
										starPosMap = unsolvableStars.get(i);
										for (Entry<Integer, Integer> entry : starPosMap.entrySet()) 
										{
											playFrame._oBoard.getField(entry.getKey(), entry.getValue()).markAsBadStar();
										}
									}
								}
							}
						}
					}
				}
			});        
		}
		else // IM SPIELMODUS
		{
			btnCheck.setToolTipText("Rückgängig zum ersten Fehler");

			btnCheck.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(null,"Zurück vor den ersten Fehler","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
					GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
					oLogicBoard.getCommandTracker().goBackToFirstFailure();
				}
			});
		}
		add(btnCheck);

		//	Dekl. Button UNDO ( Zurück zu letztem gesetzen Marker )
		JButton btnUndo;
		btnUndo = new JButton(new ImageIcon(getClass().getResource("/resources/undo.png")));
		btnUndo.setAlignmentX(LEFT_ALIGNMENT);
		btnUndo.setContentAreaFilled(false);
		btnUndo.setBorder(null);
		btnUndo.setToolTipText("Zurück zu letztem Marker");

		btnUndo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"Zurück zu letztem Marker","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
				GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
				oLogicBoard.getCommandTracker().goBackToLastMarker();
			}
		});  
		if(frame._oBoard instanceof GuiElementGameBoard){
			add(btnUndo);
		}
	}
}