package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoFenster {
	
	JFrame frame;
	JLabel label;
	JLabel backGroundImage;
	
	 public InfoFenster() {
	        frame = new JFrame ("Sternenpuzzle - Info");
	        label = new JLabel ("");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setVerticalAlignment(JLabel.TOP);
	        label.setForeground(Color.white);
	        label.setText("<html><p/><p/>Entwickler: <p/><p/> "+                  
	                   "Fabian Hassert <p/>" +
	                   "Eren Arslan <p/>" +
	                   "Mats Bulin <p/>" +
	                   "Daniel Frings <p/>" +
	                   "Anatoly Steinhauer <p/>" +
	                   "Andreas Amberg <p/> <p/>" +
	                   "Auftraggeber: Games4Ever <p/> <p/>" +
	                   "Version: 0.1 <p/> <p/>" +
	                   "Datum: 25.10.2012 </html>");	        
	        frame.add(label);
	        frame.setSize(200, 300);
	        frame.setVisible(true);
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        
	        backGroundImage = new JLabel(new ImageIcon("Images/infoBackground.png"));
	        backGroundImage.setLayout(null);
	        backGroundImage.setOpaque(false);
	        frame.getContentPane().add(backGroundImage);
	        backGroundImage.setBounds(0,0,200,300);
	    }
}
