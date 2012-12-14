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
/**
 * Erscheint, wenn das Spiel gewonnen wurde
 * @author Andreas, Mats, Daniel, Eren, Fabian, Anatoli
 */
public class PlayWin {
	
	public PlayWin(){
		
		final JFrame frame = new JFrame("Gewonnen!!"); //Fenster
		frame.setLocationRelativeTo(null); 
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 225 , 400, 350);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/Gangnam.gif"))); //Hintergrundanimation
		background.setLayout(null);
		background.setOpaque(false);
		background.setBounds(0,0,400,300);
				
		JLabel label = new JLabel("Glückwunsch! Sie haben gewonnen!"); //Label mit Text
		label.setLocation(90, 90);
		label.setSize(380, 20);
		label.setBounds(45, 250, 380, 30);
		label.setForeground(Color.WHITE); // Schriftfarbe auf weis setzen
		label.setFont(new Font("Dialog", 0, 18)); // Schriftgröße auf 18
		
		
		JButton laden = new JButton("Laden"); // Laden-Button
		laden.setBounds(0, 290, 200, 30);
		laden.setBorder(null);
		
		laden.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose(); //Fenster Schlißen
				LoadDialog ld = new LoadDialog(); //Ladefenster öffenen
			}
		});
		
		JButton ende = new JButton("Weiter"); // Weiter-Button
		ende.setBounds(200, 290, 200, 30);
		ende.setBorder(null);
		
		ende.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{						
				frame.dispose(); //Fenster schließen		
			}
		});
		//Components ans Frame binden
		frame.getContentPane().add(label);
		frame.getContentPane().add(background);
		frame.getContentPane().add(laden);
		frame.getContentPane().add(ende);
		frame.repaint();
		
	}

}
