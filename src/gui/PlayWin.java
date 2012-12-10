package gui;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.text.StyledEditorKit.FontSizeAction;

public class PlayWin {
	
	public PlayWin(){
		
		final JFrame frame = new JFrame("Gewonnen!!");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(400,500);
		frame.setBounds(400, 225 , 400, 350);
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
		label.setBounds(45, 250, 380, 30);
		label.setText("Glückwunsch! Sie haben gewonnen!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", 0, 18));
		
		
		
	/*	JButton btn = new JButton("OK");
		btn.setBounds(30, 90, 7, 75);
		btn.setBorder(null);
		
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				PlayNewGame png = new PlayNewGame();
				frame.dispose();
					
			}
		});*/
		
		JButton laden = new JButton("Laden");
		laden.setBounds(0, 290, 200, 30);
		laden.setBorder(null);
		
		laden.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose();
				LoadDialog ld = new LoadDialog();
			}
		});
		
		JButton ende = new JButton("Weiter");
		ende.setBounds(200, 290, 200, 30);
		ende.setBorder(null);
		
		ende.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose();				
			}
		});
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(background);
		frame.getContentPane().add(laden);
		frame.getContentPane().add(ende);
		frame.repaint();
		
	}

}
