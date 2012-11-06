package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Klasse enthällt die Reihe der unteren Buttons

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class PlayMenuButtonsBottom extends JPanel
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
	
	public PlayMenuButtonsBottom(PlayFrame frame)
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
            	 JOptionPane.showMessageDialog(null,"Marker setzen","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });        
		add(btnSet);
		
		JButton btnCheck;
		btnCheck = new JButton(new ImageIcon(getClass().getResource("/resources/check.png")));
		btnCheck.setAlignmentX(LEFT_ALIGNMENT);
		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorder(null);
		
		btnCheck.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Zurück zum Marker","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
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
            	 JOptionPane.showMessageDialog(null,"Rückgängig zum ersten Fehler","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });        
		add(btnUndo);
	}
}