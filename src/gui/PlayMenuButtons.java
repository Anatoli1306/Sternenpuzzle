package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Klasse enthällt die Reihe der oberen Buttons

public class PlayMenuButtons extends JPanel{
	
	private PlayFrame playFrame;
	
	public PlayMenuButtons(PlayFrame frame)
	{
		playFrame = frame;
		
		JButton a;
		a = new JButton(new ImageIcon("Images/Spielmodus_schwarz.jpg"));
		a.setAlignmentX(LEFT_ALIGNMENT);
		a.setContentAreaFilled(false);
		a.setBorder(null);
		
        a.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Test","Test2", JOptionPane.PLAIN_MESSAGE);
            }
        });           
		add(a);
		
		JButton b;
		b = new JButton(new ImageIcon("Images/Spielmodus_schwarz.jpg"));
		b.setAlignmentX(LEFT_ALIGNMENT);
		b.setContentAreaFilled(false);
		b.setBorder(null);
		
        b.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Test","Test2", JOptionPane.PLAIN_MESSAGE);
            }
        });           
		add(b);
		
		JButton c;
		c = new JButton(new ImageIcon("Images/Spielmodus_schwarz.jpg"));
		c.setAlignmentX(LEFT_ALIGNMENT);
		c.setContentAreaFilled(false);
		c.setBorder(null);
		
        c.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	 JOptionPane.showMessageDialog(null,"Test","Test2", JOptionPane.PLAIN_MESSAGE);
            }
        });           
        add(c);
	}
	

}

