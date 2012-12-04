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

// Klasse enthällt die Reihe der unteren Buttons

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class PlayMenuMarkerButton extends JPanel
{
	/**
	 * 
	 */
	private PlayFrame playFrame;
	
	
	/**
	 * 
	 * @param PlayFrame frame
	 * 
	 */
	
	public PlayMenuMarkerButton(PlayFrame frame)
	{

		playFrame = frame;
		
		JButton btnSet;
		btnSet = new JButton(new ImageIcon(getClass().getResource("/resources/set.png")));
		btnSet.setAlignmentX(LEFT_ALIGNMENT);
		btnSet.setContentAreaFilled(false);
		btnSet.setBorder(null);
		
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
		
		JButton btnCheck;
		btnCheck = new JButton(new ImageIcon(getClass().getResource("/resources/check.png")));
		btnCheck.setAlignmentX(LEFT_ALIGNMENT);
		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorder(null);
		
		btnCheck.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	if (playFrame._oBoard instanceof GuiElementGameBoard)
            	{
            		JOptionPane.showMessageDialog(null,"Zurück zum Marker","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
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
        });        
		add(btnCheck);
		
		JButton btnUndo;
		btnUndo = new JButton(new ImageIcon(getClass().getResource("/resources/undo.png")));
		btnUndo.setAlignmentX(LEFT_ALIGNMENT);
		btnUndo.setContentAreaFilled(false);
		btnUndo.setBorder(null);
		
		btnUndo.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
//            	 JOptionPane.showMessageDialog(null,"Rückgängig zum ersten Fehler","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            	GameBoard oLogicBoard = (GameBoard)playFrame._oBoard.getLogicBoard();
            	oLogicBoard.getCommandTracker().goBackToLastMarker();
            }
        });  
		if(frame._oBoard instanceof GuiElementGameBoard){
			add(btnUndo);
		}
	}
}