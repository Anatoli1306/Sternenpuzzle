package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayNewGame {
	
	public PlayNewGame(){
		
		final JFrame frame = new JFrame("Neues Spiel laden?");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(230,150);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel label = new JLabel();
		label.setBounds(5, 5, 210, 75);
		label.setForeground(Color.white);
		label.setText("<html><p/><p/>Möchten Sie ein neues Spiel laden, " +
										"oder das Spiel beeden?<p/></html>");
		
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/boardSizeDialogBackground.png")));
		background.setLayout(null);
		background.setOpaque(false);
		background.setBounds(0,0,230,150);
				
		JButton laden = new JButton("Laden");
		laden.setBounds(30, 90, 70, 30);
		laden.setBorder(null);
		
		laden.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose();
				LoadDialog ld = new LoadDialog();
			}
		});
		
		JButton ende = new JButton("Ende");
		ende.setBounds(120, 90, 70, 30);
		ende.setBorder(null);
		
		ende.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose();				
			}
		});
				
		frame.getContentPane().add(label);
		frame.getContentPane().add(laden);	
		frame.getContentPane().add(ende);	
		frame.getContentPane().add(background);	
		frame.repaint();
	}
}
