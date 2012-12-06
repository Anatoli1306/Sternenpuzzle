package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayWin {
	
	public PlayWin(){
		
		final JFrame frame = new JFrame("Gewonnen!!");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(400,500);
		frame.setBounds(400,225 , 400, 400);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/Gangnam.gif")));
		
		//JPanel panel = new JPanel();
		//panel.add(new JLabel(new ImageIcon(getClass().getResource("/resources/Gangnam.gif"))));
		
		
		
		background.setLayout(null);
		background.setOpaque(false);
		background.setBounds(0,0,400,300);
		
		//panel.add(background);
		
		
		JLabel label = new JLabel();
		label.setLocation(90, 90);
		label.setSize(380, 20);
		label.setBounds(100, 250, 380, 20);
		label.setText("Glückwunsch! Sie haben gewonnen!");
		
		
		JButton btn = new JButton("OK");
		btn.setBounds(165, 300, 75, 75);
		btn.setBorder(null);
		
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				PlayNewGame png = new PlayNewGame();
				frame.dispose();
					
			}
		});
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(background);
		frame.getContentPane().add(btn);
		frame.repaint();
		
	}

}
