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
	
	public PlayMenuButtonsTop(final PlayFrame frame)
	{
		frame.getContentPane().setBackground(Color.white);
		
		JButton btnGameMode;
		btnGameMode = new JButton(new ImageIcon(getClass().getResource("/resources/gameMode.png")));
		btnGameMode.setAlignmentX(LEFT_ALIGNMENT);
		btnGameMode.setContentAreaFilled(false);
		btnGameMode.setToolTipText("Starte den Spielmodus");
		btnGameMode.setBorder(null);
		
		btnGameMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"GameMode","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            	 frame.drawGameBoard();
            }
        });        
		//setComponentZOrder(btnGameMode, 1);
		add(btnGameMode);
		
		
		JButton btnEditMode;
		btnEditMode = new JButton(new ImageIcon(getClass().getResource("/resources/editMode.png")));
		btnEditMode.setAlignmentX(LEFT_ALIGNMENT);
		btnEditMode.setContentAreaFilled(false);
		btnEditMode.setToolTipText("Starte den Editormodus");
		btnEditMode.setBorder(null);
		
		btnEditMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"EditMode","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            	 frame.drawEditorBoard();
            }
        });           
		add(btnEditMode);
		
		JButton btnLoad;
		btnLoad = new JButton(new ImageIcon(getClass().getResource("/resources/load.png")));
		btnLoad.setAlignmentX(LEFT_ALIGNMENT);
		btnLoad.setContentAreaFilled(false);
		btnLoad.setToolTipText("Lade einen vorhandenen Spielstand");
		btnLoad.setBorder(null);
		
		btnLoad.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 LoadDialog loadDialog = new LoadDialog();
            }
        });           
        add(btnLoad);
        
		JButton btnSave;
		btnSave = new JButton(new ImageIcon(getClass().getResource("/resources/save.png")));
		btnSave.setAlignmentX(LEFT_ALIGNMENT);
		btnSave.setContentAreaFilled(false);
		btnSave.setToolTipText("Speichere den aktuellen Spielstand");
		btnSave.setBorder(null);
		
		btnSave.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Save","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });           
        add(btnSave);
        
		JButton btnInfo;
		btnInfo = new JButton(new ImageIcon(getClass().getResource("/resources/info.png")));
		btnInfo.setAlignmentX(LEFT_ALIGNMENT);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setToolTipText("Zeige Informationen");
		btnInfo.setBorder(null);
		
		btnInfo.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	InfoDialog infofenster = new InfoDialog();
            }
        });           
        add(btnInfo);
        
        JButton btnClose;
        btnClose = new JButton(new ImageIcon(getClass().getResource("/resources/close.png")));
        btnClose.setAlignmentX(LEFT_ALIGNMENT);
        btnClose.setContentAreaFilled(false);
        btnClose.setToolTipText("Programm beenden");
        btnClose.setBorder(null);
		
        btnClose.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	frame.dispose();
            }
        });           
        add(btnClose);
	}
	

}

