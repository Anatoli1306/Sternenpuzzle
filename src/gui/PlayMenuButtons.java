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

public class PlayMenuButtons extends JPanel
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
	
	public PlayMenuButtons(PlayFrame frame)
	{

		playFrame = frame;
		playFrame.getContentPane().setBackground(Color.white);
		
		JButton btnGameMode;
		btnGameMode = new JButton(new ImageIcon("images/gameMode.png"));
		btnGameMode.setAlignmentX(LEFT_ALIGNMENT);
		btnGameMode.setContentAreaFilled(false);
		btnGameMode.setBorder(null);
		
		btnGameMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"GameMode","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });        
		//setComponentZOrder(btnGameMode, 1);
		add(btnGameMode);
		
		
		JButton btnEditMode;
		btnEditMode = new JButton(new ImageIcon("images/editMode.png"));
		btnEditMode.setAlignmentX(LEFT_ALIGNMENT);
		btnEditMode.setContentAreaFilled(false);
		btnEditMode.setBorder(null);
		
		btnEditMode.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"EditMode","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });           
		add(btnEditMode);
		
		JButton btnLoad;
		btnLoad = new JButton(new ImageIcon("images/load.png"));
		btnLoad.setAlignmentX(LEFT_ALIGNMENT);
		btnLoad.setContentAreaFilled(false);
		btnLoad.setBorder(null);
		
		btnLoad.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Load","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });           
        add(btnLoad);
        
		JButton btnSave;
		btnSave = new JButton(new ImageIcon("images/save.png"));
		btnSave.setAlignmentX(LEFT_ALIGNMENT);
		btnSave.setContentAreaFilled(false);
		btnSave.setBorder(null);
		
		btnSave.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Save","SternenHimmelPuzzle", JOptionPane.PLAIN_MESSAGE);
            }
        });           
        add(btnSave);
        
		JButton btnInfo;
		btnInfo = new JButton(new ImageIcon("images/info.png"));
		btnInfo.setAlignmentX(LEFT_ALIGNMENT);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorder(null);
		
		btnInfo.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	InfoFenster infofenster = new InfoFenster();
            }
        });           
        add(btnInfo);
        
        JButton btnClose;
        btnClose = new JButton(new ImageIcon("images/close.png"));
        btnClose.setAlignmentX(LEFT_ALIGNMENT);
        btnClose.setContentAreaFilled(false);
        btnClose.setBorder(null);
		
        btnClose.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	playFrame.dispose();
            }
        });           
        add(btnClose);
	}
	

}

